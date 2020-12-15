customers = LOAD 'customers.txt' USING PigStorage(',') AS (id:int,
uname:chararray, age:int, loc:chararray, sal:float);

orders = LOAD 'orders.txt' USING PigStorage(',') AS (oid:int,
odt:chararray, cid:int, oamt:int);

cust_ord_join = JOIN customers BY id, orders BY cid;

cust_ord_join_view = FOREACH cust_ord_join GENERATE uname, oid,
odt, oamt;

STORE cust_ord_join_view INTO 'Output/script4Output' USING PigStorage(',');

