students = LOAD 'student_details.txt' USING PigStorage(',') AS
(sid:int, fname:chararray, lname:chararray, age:int,
mobile:biginteger, place:chararray);

group_place = GROUP students BY place;

STORE group_place INTO 'Output/script5Output' USING PigStorage(',');
