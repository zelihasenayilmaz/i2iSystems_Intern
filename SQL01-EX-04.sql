create table HR.emp as select * from HR.employees;

INSERT INTO HR.EMP values (207, 'sena', 'yilmaz', 'zsy', '551.123.4563', '10/08/2007',
'PU_CLERK', 2500, NULL, 114, 30);

update HR.EMP set first_name='Sena', last_name='YILMAZ', phone_number=1234 where employee_id=102;

delete from HR.EMP where employee_id=102;

drop table HR.EMP;