# 문제 : https://programmers.co.kr/learn/courses/30/lessons/59045
SELECT o.animal_id, o.animal_type, o.name
from animal_outs as o
join animal_ins as i
on o.animal_id = i.animal_id
where o.sex_upon_outcome <> i.sex_upon_intake