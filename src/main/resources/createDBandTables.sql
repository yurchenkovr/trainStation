CREATE DATABASE IF NOT EXISTS trainstation;
CREATE SCHEMA IF NOT EXISTS trainstation  DEFAULT CHARACTER SET utf8 ;

CREATE  TABLE IF NOT EXISTS trainstation.trains (
  TrainNumber INT NOT NULL AUTO_INCREMENT,
  ArrivalTo VARCHAR(45),
  DepartureFrom VARCHAR(45),
  departureTime TIME ,
  arrivalTime TIME,
  Platform VARCHAR(1),
  PRIMARY KEY (TrainNumber) );

CREATE  TABLE IF NOT EXISTS trainstation.Prices (
  TrainNumber INT NOT NULL AUTO_INCREMENT,
  TypeCar VARCHAR(45),
  price INT ,
  PRIMARY KEY (TrainNumber) );

CREATE TABLE IF NOT EXISTS trainstation.Workers (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name     VARCHAR(15),
  SurName  VARCHAR(20),
  Age      INT,
  Salary   INT,
  Position VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS trainstation.Users(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR (15),
  password VARCHAR (20),
  role VARCHAR(1)
);