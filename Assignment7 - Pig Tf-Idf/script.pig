
DEFINE tokenize_docs `tokenize_documents.py` SHIP('tokenize_documents.py');


raw_documents = LOAD 'txt' USING PigStorage(' ','-tagFile') AS (doc_id:chararray, text:chararray);
tokenized = STREAM raw_documents THROUGH tokenize_docs AS (doc_id:chararray, token:chararray);


doc_tokens = GROUP tokenized BY (doc_id, token);
doc_token_counts = FOREACH doc_tokens GENERATE FLATTEN(group) AS (doc_id, token), COUNT(tokenized) AS num_doc_tok_usages;


doc_usage_bag = GROUP doc_token_counts BY doc_id;
doc_usage_bag_fg = FOREACH doc_usage_bag GENERATE group AS doc_id, FLATTEN(doc_token_counts.(token, num_doc_tok_usages)) AS (token, num_doc_tok_usages), SUM(doc_token_counts.num_doc_tok_usages) AS doc_size;

STORE doc_usage_bag_fg INTO 'Output/1_bow' USING PigStorage(',');


bag_group = group doc_usage_bag_fg all;
bag_size = foreach bag_group generate COUNT(doc_usage_bag_fg);

STORE bag_size INTO 'Output/2_bow_size' USING PigStorage(',');


term_freqs = FOREACH doc_usage_bag_fg GENERATE doc_id AS doc_id, token AS token, ((double)num_doc_tok_usages / (double)doc_size) AS term_freq;


term_usage_bag  = GROUP term_freqs BY token;

token_usages  = FOREACH term_usage_bag GENERATE FLATTEN(term_freqs) AS (doc_id, token, term_freq), COUNT(term_freqs)   AS num_docs_with_token;



tfidf_all = FOREACH token_usages { idf = LOG((double)3035 / (double)num_docs_with_token); tf_idf = (double)term_freq*idf; GENERATE doc_id AS doc_id, token  AS token, tf_idf AS tf_idf;};


STORE tfidf_all INTO 'Output/3_tfidf' USING PigStorage(',');
