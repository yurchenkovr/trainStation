INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (120, 'Odessa', 'Kharkiv', '2018-10-25 12:50', '2018-10-25 13:00', 'A');
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (130, 'Kharkiv', 'Odessa', '2018-10-26 12:30', '2018-10-26 12:50', 'B');
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (140, 'Kharkiv', 'Kyiv', '2018-10-25 16:10', '2018-10-25 16:25', 'C');
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (100, 'Rivne', 'Lviv', '2018-10-27 13:10', '2018-10-27 13:50', 'D');
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (150, 'Rivne', 'Zorya', '2018-10-24 11:20', '2018-10-24 11:50', 'A');
INSERT INTO trainstation.trains(TrainNumber, ArrivalTo, DepartureFrom,departureTime,  arrivalTime, Platform)
    VALUES (160, 'Kyiv', 'Rivne', '2018-10-25 22:40', '2018-10-25 22:50', 'B');

INSERT  INTO trainstation.prices( TrainNumber,  TypeCar,  Price)
    VALUES (100, 'Electricity', 120);
INSERT INTO  trainstation.prices( TrainNumber,  TypeCar,  Price)
    VALUES (120, 'Planeboard', 120);
INSERT INTO  trainstation.prices( TrainNumber,  TypeCar,  Price)
    VALUES (130, 'Compartment', 560);
INSERT INTO  trainstation.prices( TrainNumber,  TypeCar,  Price)
    VALUES (140, 'Planeboard', 80);
INSERT INTO  trainstation.prices( TrainNumber,  TypeCar,  Price)
    VALUES (150, 'Compartment', 520);
INSERT INTO  trainstation.prices( TrainNumber,  TypeCar,  Price)
    VALUES (160, 'Planeboard', 135);


INSERT INTO trainstation.users ( id, username, password, role)
    VALUES (1, 'yurchenkovr', '12345' , '1');
INSERT INTO trainstation.users ( id, username, password, role)
    VALUES (2, 'qwerty', '12345' , '0');
INSERT INTO trainstation.users ( id, username, password, role)
    VALUES (3, 'asdf', '12345' , '0');
INSERT INTO trainstation.users ( id, username, password, role)
    VALUES (4, 'zxcv', '12345' , '0');
