-- # Write your MySQL query statement below
select Email
from (select Email, count(Email) as e
      from Person
      group by Email
) as p
where e > 1