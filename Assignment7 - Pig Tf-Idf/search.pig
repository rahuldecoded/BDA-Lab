tfidf_all = LOAD 'Output/3_tfidf' USING PigStorage(',')  AS (doc_id: chararray, token: chararray, tf_idf: FLOAT);

filtered_records = FILTER tfidf_all BY token == 'law';

sorted_records = ORDER filtered_records BY tf_idf DESC;

top_3_records = LIMIT sorted_records 3;

STORE top_3_records INTO 'Output/4_top_3_docs' USING PigStorage(',');


