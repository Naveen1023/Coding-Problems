# Write your MySQL query statement below
 # we can use if statement, SYNTAX : 
 #                       IF(condition, value_if_true, value_if_false)
 
 # select employee_id, 
 # IF(name NOT LIKE 'M%' && employee_id % 2 = 1, salary, 0) as bonus
 # from employees order by employee_id;
 
 # .............................Using CASE.............................
 
 select employee_id, 
 CASE 
    when employee_id % 2 = 1 and name NOT LIKE "M%" then salary
    else 0
end as bonus
 from employees order by employee_id;
 
 # ORDER BY sort the data in ascending order by defaut,, otherwise mention DESC
 
 