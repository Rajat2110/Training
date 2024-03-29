-- union and union all
CREATE TABLE Salesman (
    salesman_id INT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255),
    commission DECIMAL(4, 2)
);

-- Create the Customer table
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    cust_name VARCHAR(255),
    city VARCHAR(255),
    grade INT,
    salesman_id INT,
    FOREIGN KEY (salesman_id) REFERENCES Salesman(salesman_id)
);

-- select all salesperson and customers living in london
select
  salesman_id, 
  name,
  "Salesman"
from Salesman
where city='London'
union
select 
  customer_id,
  cust_name,
  "Customer"
from Customer
where city='London';


create table employee
 (
   id int,
   ename varchar(30),
   dept varchar(20),
   salary int
 );
 
insert into employee values (102, "Peter", "Sales", 60000);

select
 id,
 ename,
 dept,
 salary,
 row_number() over (order by salary desc) as row_num,
 rank() over (order by salary desc) as salary_rank,
 dense_rank() over (order by salary desc) as salary_dense_rank,
 lead(salary) over (order by salary desc) as lead_column,
 lag(salary) over (order by salary desc) as lag_column
from employee;
 