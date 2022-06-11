create view age_view as
select age,count(age) as frequency from student group by (age)