select employee_id, first_name, department_name
from HR.employees e join HR.departments d 
on e.department_id = d.department_id;