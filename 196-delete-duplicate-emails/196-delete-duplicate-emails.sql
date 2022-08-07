# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below

delete P from Person P,Person Q
where P.email = Q.email and P.id > Q.id
