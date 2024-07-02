							Hotel-Management-System Java
This project has been created using Java SWING and MySQL database.
   1. Download the repository as a zip file, unzip and open it in java ide.
   2. In project structure set up two modules from given jar files as given in module folder.
   3. Finally download MySql database and execute the following commands.
   4.  create database hotelms.
   5.   use hotelms.
   6.   CREATE TABLE booking (
               bill_id VARCHAR(100),
               customer VARCHAR(100),
               table_number VARCHAR(100),
                veg INT,
               egg INT,
               fish INT,
               chicken INT,
               mutton INT,
               ala INT
            );
7.    CREATE TABLE customer (
    document VARCHAR(20) NOT NULL,
    number VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    country VARCHAR(20) NOT NULL,
    room VARCHAR(20) NOT NULL,
    checkintime VARCHAR(50) NOT NULL,
    deposit VARCHAR(20) NOT NULL,
    days INT
);
8.   CREATE TABLE department (
    department VARCHAR(50) NOT NULL,
    budget VARCHAR(50)
);
9.  CREATE TABLE driver (
    name VARCHAR(20),
    age VARCHAR(20),
    gender VARCHAR(20),
    company VARCHAR(20),
    carname VARCHAR(20),
    available VARCHAR(20),
    location VARCHAR(20)
);
10.  CREATE TABLE employee (
    name VARCHAR(20) NOT NULL,
    age VARCHAR(20) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    job VARCHAR(20) NOT NULL,
    salary VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    aadhar VARCHAR(20) NOT NULL,
    avail VARCHAR(25)
);
11.    CREATE TABLE expenditure (
    name VARCHAR(20) NOT NULL,
    job VARCHAR(20) NOT NULL,
    salary VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    pay_interval VARCHAR(20) NOT NULL,
    aadhar VARCHAR(50)
);
12.   CREATE TABLE login (
    username VARCHAR(25),
    password VARCHAR(25)
);
13.  CREATE TABLE login2 (
    username VARCHAR(25),
    password VARCHAR(25)
);
14.   INSERT INTO login2 (username, password) VALUES ('Shubhayu@123', 'Shubhayu@789');

15.   CREATE TABLE menu (
    meal VARCHAR(100),
    cost VARCHAR(100),
    price VARCHAR(100)
);
16.  CREATE TABLE rest_expend (
    bill_id VARCHAR(100),
    customer VARCHAR(100),
    table_num VARCHAR(100),
    cost_price VARCHAR(100)
);
17.  CREATE TABLE rest_income (
    bill_id VARCHAR(100),
    customer VARCHAR(100),
    table_num VARCHAR(100),
    total VARCHAR(100)
);
18.  CREATE TABLE room (
    roomnumber VARCHAR(20) PRIMARY KEY,
    availabilty VARCHAR(20) NOT NULL,
    cleaning_status VARCHAR(20) NOT NULL,
    price VARCHAR(20) NOT NULL,
    bed_type VARCHAR(20) NOT NULL
);
19.  CREATE TABLE room_income (
    customer_name VARCHAR(50),
    customer_number VARCHAR(50),
    room_occupied VARCHAR(50),
    checkin VARCHAR(50),
    checkout VARCHAR(50),
    income VARCHAR(50)
);
20. CREATE TABLE scheduled_service (
    serviceId VARCHAR(100) PRIMARY KEY,
    service_member VARCHAR(100),
    service_member_name VARCHAR(100),
    service_type VARCHAR(100),
    room_number VARCHAR(100),
    time_of_service VARCHAR(100),
    customer_id VARCHAR(100)
);
21.  CREATE TABLE service_charge (
    customer VARCHAR(50),
    due VARCHAR(50)
);
22.  CREATE TABLE table_s (
    number VARCHAR(100),
    avail VARCHAR(50),
    people VARCHAR(50)
);

23. Now build and run the project.












