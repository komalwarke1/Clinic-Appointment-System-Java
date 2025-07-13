create database if not exists Clinic;

use Clinic;

create table Doctor(
  id int auto_increment primary key,
  name varchar(50),
  specialization varchar(50)

);

create table Patient(
  id int auto_increment primary key,
  name varchar(50),
  age int,
  gender varchar(50)
);

create table Appointment(
   id int auto_increment primary key,
   doctor_id int,
   patient_id int,
   date Date,
   time Time,
   foreign key (doctor_id) references Doctor(id),
   foreign key (patient_id) references Patient(id)

);


