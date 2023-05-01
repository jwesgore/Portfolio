select * from apply;
select * from college;
select * from student;

-- 1 -- 
select MIN(GPA) as min_gpa, MAX(gpa) as max_gpa from student
join apply on student.sID = apply.sID
where major = 'CS';

-- 2 --
select MIN(GPA) as min_gpa, MAX(gpa) as max_gpa, MAX(GPA) - MIN(GPA) as spread from student
join apply on student.sID = apply.sID;

-- 3 --
select MIN(GPA) as min_gpa, MAX(gpa) as max_gpa, major from student
join apply on student.sID = apply.sID
group by major;

-- 4 --
select state, sum(enrollment) as total_enrollment from college
group by state;

-- 5 --
select avg(student.gpa) as average_gpa from student 
where sID in (select distinct sID from apply where major = 'CS');

-- 6 --
select cs.agpa - ncs.agpa as gpa_diff from 
	(select avg(student.gpa) as agpa from student 
    where sID in (select distinct sID from apply where major = 'CS')) as cs,
    (select avg(student.gpa) as agpa from student
    where sID not in (select distinct sID from apply where major = 'CS')) as ncs;
    
-- 7 --
select count(*) from student;
 
-- 8 --
select count(distinct sID) from apply where cName = 'Cornell';
 
-- 9a --
select sID, count(cName) from apply group by sID; 
 
-- 9b --
select sName, apply.sID, count(cName) from apply 
join student where student.sID = apply.sID group by sName, apply.sID; 

-- 10 --
select cName from apply group by cName having count(cName) < 5;

-- A --
SELECT * FROM Student;
Insert into Student values (432, 'Kevin', null, 1500);
Insert into Student values (321, 'Lori', null, 2500);
SELECT * FROM Student;

-- B --
SELECT count(*) FROM Student;

-- C --
SELECT count(GPA) FROM Student;

-- D --
SET SQL_SAFE_UPDATES = 0;
DELETE FROM Student WHERE GPA is null;