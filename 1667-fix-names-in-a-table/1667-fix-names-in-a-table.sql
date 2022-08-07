# Write your MySQL query statement below

select USERS.user_id, CONCAT(UPPER(SUBSTR(Users.name,1,1)), LOWER(SUBSTR(Users.name, 2))) as name 
FROM USERS order by user_id;