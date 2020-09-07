-- # Write your MySQL query statement below
select c.Name as Customers
from Customers as c
where c.Id not in (select CustomerId from Orders)
