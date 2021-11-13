
--Sample view for pivoting based on rows.
create view pivot_parent_child_view as
select pp.id, pp.name, pp.age,
max(case when pc.address_type = 'PERMANENT' then pc.city end) as permanent_city,
max(case when pc.address_type = 'CURRENT' then pc.city end) as current_city
from pivot_parent pp left join pivot_child pc on pc.pivot_parent_id = pp.id
group by pp.id, pp.name, pp.age