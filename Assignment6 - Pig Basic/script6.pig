
customers = LOAD 'customers.txt' USING PigStorage(',') AS (id:int,
uname:chararray, age:int, loc:chararray, sal:float);

students = LOAD 'student_details.txt' USING PigStorage(',') AS
(sid:int, fname:chararray, lname:chararray, age:int,
mobile:biginteger, place:chararray);

cogroup_age = COGROUP students BY age, customers BY age;

STORE cogroup_age INTO 'Output/script6Output' USING PigStorage(',');



