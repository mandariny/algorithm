-- 문제 : https://programmers.co.kr/learn/courses/30/lessons/59043
select o.animal_id, o.name
from animal_outs as o, animal_ins as i
where o.datetime < i.datetime and o.animal_id = i.animal_id
order by i.datetime;

select i.animal_id, i.name
from animal_outs as o
join animal_ins as i
on o.animal_id = i.animal_id
where o.datetime < i.datetime
order by i.datetime;
