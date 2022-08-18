# Write your MySQL query statement below
select  distinct a.id 
FROM Weather a , Weather b
where TO_DAYS(a.recordDate) - TO_DAYS(b.recordDate) = 1 and a.temperature > b.temperature;

#  TO_DAYS(date) gives number of days between year 0 to till date