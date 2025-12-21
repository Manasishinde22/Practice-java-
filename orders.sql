SELECT user_id
FROM orders
GROUP BY user_id
HAVING SUM(amount) > 1000;
