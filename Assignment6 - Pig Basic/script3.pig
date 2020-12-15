customers = LOAD 'customers.txt' USING PigStorage(',') AS (id:int,
uname:chararray, age:int, loc:chararray, sal:float);

custsalsort = ORDER customers BY sal DESC;

limitcustsal = LIMIT custsalsort 3;

STORE limitcustsal INTO 'Output/script3Output' USING PigStorage(',');

