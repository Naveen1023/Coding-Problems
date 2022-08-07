# Write your MySQL query statement below


# ....................USING IF....................

update Salary Set sex = IF(sex = 'm','f','m')


# ..............USING CASE...............
# update Salary 
# SET sex = 
#     CASE 
#         when sex = 'm' then 'f'
#         when sex = 'f' then 'm'
#     END

# ..... ANother way to write ...........
# update Salary 
# SET sex = 
#     CASE SEX
#         when 'm' then 'f'
#         when 'f' then 'm'
#     END