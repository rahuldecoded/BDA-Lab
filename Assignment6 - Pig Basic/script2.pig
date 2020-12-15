customers = LOAD 'customers.txt' USING PigStorage(',') AS (id:int,
uname:chararray, age:int, loc:chararray, sal:float);

custsalagesort = ORDER customers BY sal DESC, age ASC;

STORE custsalagesort INTO 'Output/script2Output' USING PigStorage(',');

