# Write your MySQL query statement below

select USERS.user_id, CONCAT(UPPER(SUBSTR(Users.name,1,1)), LOWER(SUBSTR(Users.name, 2))) as name 
FROM USERS order by user_id;

/*
Let's breakdown the steps that we are required to do in this before jumping into SQL

    FIrstly we need to fetch the first letter and convert it to upperCase

    Secondly we need to fetch the remaing string to lowerCase and then concat them

    We will be using four functions here that are present in SQL

        UPPER(A) where A is string
        LOWER(A) where A is string
        SUBSTR(A,index,length) where A is string index is starting index(1 index insead of 0 index) and length which is optional
            So to get first letter we can use SUBSTR(name,1,1)
            To get the remaining string we can use SUBSTR(name,2) // length is not required here
        CONCAT(A,B) where we concat two strings A+B


*/