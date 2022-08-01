# Write your MySQL query statement below


# # select name as Customers from Customers
# Where id NOT In(select customerId from Orders);


select C.name AS Customers from Customers C
where NOT EXISTS(Select O.customerId from Orders O where C.id = O.customerId);
