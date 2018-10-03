INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (120, 'Odessa', 'Kharkiv', '11:10', '14:20', 'A');    
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (130, 'Kharkiv', 'Odessa', '11:10', '14:20', 'B');    
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (140, 'Kharkiv', 'Kyiv', '21:10', '14:20', 'C');    
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (100, 'Rivne', 'Lviv', '10:00', '13.20', 'D');    
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (150, 'Rivne', 'Zorya', '15:02', '18.20', 'A');    
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (160, 'Kyiv', 'Rivne', '11:04', '15.20', 'B');

``
INSERT INTO  trainstation.Prices( TrainNumber,  TypeCar,  Price)
    VALUES (120, 'Planeboard', 120);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (120, 'Compartment', 420);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (130, 'Planeboard', 100);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (130, 'Compartment', 560);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (140, 'Planeboard', 80);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (140, 'Compartment', 320);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (150, 'Planeboard', 140);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (150, 'Compartment', 520);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (160, 'Planeboard', 135);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (160, 'Compartment', 500);
INSERT INTO  trainstation. Prices( TrainNumber,  TypeCar,  Price)
    VALUES (100, 'Electricity', 60);

INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Vitalii', 'Yurchenko', 18 , 12000, 'ADMIN');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Andrii', 'Kopart', 22 , 6500, 'CASHIER');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Olga', 'Rut', 25 , 6500, 'CASHIER');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Dmytro', 'Lossa', 21 , 8200 , 'MACHINIST');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Roman', 'Gerus', 19 , 8200 , 'MACHINIST');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Oleksandr', 'Lvivsa', 25, 7500 , 'CONDUCTOR');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Sergii', 'Manet', 22, 7500 , 'CONDUCTOR');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Nataliia', 'Kiran', 25, 6200 , 'CLEANER');
INSERT INTO trainstation.Workers ( Name, SurName, Age, Salary, Position)
    VALUES ('Vitalii', 'Kolan', 35, 6200 , 'CLEANER');
