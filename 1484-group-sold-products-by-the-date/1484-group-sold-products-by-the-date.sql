# Write your MySQL query statement below

# select sell_date,
#     COUNT(DISTINCT product) as num_sold 
#     GROUP_CONCAT(DISTINCT product ORDER BY product ASC SEPARATOR ',') AS Products
# from Activities 
# GROUP BY sell_date
# ORDER BY sell_date

SELECT sell_date,
		COUNT(DISTINCT(product)) AS num_sold, 
		GROUP_CONCAT(DISTINCT(product) ORDER BY product) AS products
FROM Activities
GROUP BY sell_date
ORDER BY sell_date ASC