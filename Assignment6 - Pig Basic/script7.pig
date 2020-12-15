customers = LOAD 'customers.txt' USING PigStorage(',') AS (id:int,
uname:chararray, age:int, loc:chararray, sal:float);

rich_people = FILTER customers BY sal > 2000.00;

STORE rich_people INTO 'Output/script7Output' USING PigStorage(',');
