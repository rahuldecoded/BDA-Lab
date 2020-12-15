customers = LOAD 'customers.txt' USING PigStorage(',') AS (id:int,
uname:chararray, age:int, loc:chararray, sal:float);

custagesort = ORDER customers BY age ASC;

STORE custagesort INTO 'Output/script1Output' USING PigStorage(',');
