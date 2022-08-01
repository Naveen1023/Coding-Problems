# Write your MySQL query statement below
select name as Customers from Customers
Where id NOT In(select customerId from Orders);