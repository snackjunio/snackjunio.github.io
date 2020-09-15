-- # Write your MySQL query statement below
select w1.Id
from Weather as w1, Weather as w2
where w1.recordDate = date_add(w2.recordDate, interval 1 day) and w1.Temperature > w2.Temperature