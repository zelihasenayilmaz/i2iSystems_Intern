select substr(phone_number, 1, 3) "Operator", 
count(*) "Total" from HR.employees group by substr(phone_number, 1, 3);

select * from (substr(phone_number, 1, 3) x from HR.employees a
JOIN HR.employees b on a.phone_number like substr(b.phone_number, 1, 3) || '%' group by a.phone_number)
PIVOT (count(*) for x in(515,590,603,011,650));