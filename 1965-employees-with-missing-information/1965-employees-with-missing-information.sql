# Write your MySQL query statement below


# employees with missing salary won't be in SALARY table and similar reasoning for name also..

select employee_id from Employees where employee_id NOT IN(select employee_id from Salaries)
UNION
select employee_id from Salaries where employee_id NOT IN(select employee_id from Employees)
order by employee_id;