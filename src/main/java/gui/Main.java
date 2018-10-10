package gui;

import controllers.TicketController;
import controllers.TrainController;
import controllers.UserController;
import db.dao_exception.PersistException;
import enums.Platform;
import services.modelsUI.Train;
import services.modelsUI.TrainTicket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        UserController userController = new UserController();
        TrainController trainController = new TrainController();
        TicketController ticketController = new TicketController();
        int choice;

        String username;
        String password;
        String verifyPassword;
        int id;
        String oldPassword;
        String newPassword;

        while (true) {
            System.out.print("1.Login as Admin\n2.Login as Client\n0.Exit\n: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1://Admin
                    System.out.print("Username: ");
                    username = sc.next();
                    System.out.print("Password: ");
                    password = sc.next();
                    try {
                        if (userController.loginUser(username, password)) {
                            while (true) {
                                System.out.print("1.Users\n2.Trains\n3.Change password\n4.Back\n0.Exit\n: ");
                                choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        while (true) {
                                            System.out.print("1.Show all users\n2.Find user\n" +
                                                    "3.Delete user\n4.Create user\n6.Back\n0.Exit\n: ");
                                            choice = sc.nextInt();
                                            switch (choice) {
                                                case 1:
                                                    List users = userController.getAll();
                                                    for (Object e : users) {
                                                        System.out.println(e);
                                                    }
                                                    continue;
                                                case 2:
                                                    System.out.print("Enter id: ");
                                                    id = sc.nextInt();
                                                    userController.getUser(id);
                                                    continue;
                                                case 3:
                                                    System.out.println("Enter id: ");
                                                    id = sc.nextInt();
                                                    userController.delete(id);
                                                    continue;
                                                case 4:
                                                    System.out.print("Username: ");
                                                    username = sc.next();
                                                    System.out.print("Password: ");
                                                    password = sc.next();
                                                    System.out.print("Verify your password: ");
                                                    verifyPassword = sc.next();
                                                    if (userController.createUser(username, password, verifyPassword)) {
                                                        System.out.println("User created.");
                                                    }
                                                    System.out.println("Wrong input data.");
                                                    continue;

                                                case 5:
                                                    break;
                                                case 0:
                                                    System.exit(0);
                                                default:
                                                    System.out.println("Wrong data.Repeat.");
                                                    continue;

                                            }
                                        }
                                    case 2:
                                        while (true) {
                                            System.out.print("1.Show all trains\n2.Find train\n" +
                                                    "3.Delete train\n4.Add train\n5.Update train\n6.Back\n0.Exit\n: ");
                                            choice = sc.nextInt();
                                            switch (choice) {
                                                case 1:
                                                    List trains = trainController.getAll();
                                                    for (Object e : trains) {
                                                        System.out.println(e);
                                                    }
                                                    continue;
                                                case 2:
                                                    System.out.print("Enter number of Train: ");
                                                    try {
                                                        id = Integer.parseInt(br.readLine());
                                                        System.out.println(trainController.getTrain(id));
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                    continue;
                                                case 3:
                                                    System.out.print("Enter number of Train: ");
                                                    id = sc.nextInt();
                                                    trainController.deleteTrain(id);
                                                    continue;
                                                case 4:
                                                    try {
                                                        System.out.print("Arrival To: ");
                                                        String arrivalTo = br.readLine();
                                                        System.out.print("Departure From: ");
                                                        String departureFrom = br.readLine();
                                                        System.out.print("Arrival Time: ");
                                                        String arrivalTime = br.readLine();
                                                        System.out.print("Departure Time: ");
                                                        String departureTime = br.readLine();
                                                        System.out.print("Platform: ");
                                                        String p = br.readLine();
                                                        Train trainUI = new Train(arrivalTo, departureFrom, Timestamp.valueOf(arrivalTime), Timestamp.valueOf(departureTime), Platform.valueOf(p));
                                                        trainController.createTrain(trainUI);
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                case 5:
                                                    try {
                                                        System.out.print("Enter number of train: ");
                                                        int trNum = Integer.parseInt(br.readLine());
                                                        System.out.print("Arrival To: ");
                                                        String arrivalToUPD = br.readLine();
                                                        System.out.print("Departure From: ");
                                                        String departureFromUPD = br.readLine();
                                                        System.out.print("Arrival Time: ");
                                                        String arrivalTimeUPD = br.readLine();
                                                        System.out.print("Departure Time: ");
                                                        String departureTimeUPD = br.readLine();
                                                        System.out.print("Platform: ");
                                                        String pl = br.readLine();
                                                        Train trainUpdateUI = new Train(trNum, departureFromUPD, arrivalToUPD, Timestamp.valueOf(arrivalTimeUPD), Timestamp.valueOf(departureTimeUPD), Platform.valueOf(pl));
                                                        trainController.updateTrain(trainUpdateUI);
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                    continue;
                                                case 6:
                                                    break;
                                                case 0:
                                                    System.exit(0);
                                                default:
                                                    System.out.println("Wrong data.Repeat.");
                                                    continue;
                                            }
                                        }
                                    case 3:
                                        System.out.print("Id: ");
                                        id = sc.nextInt();
                                        System.out.print("Old Password: ");
                                        oldPassword = sc.next();
                                        System.out.print("New Password: ");
                                        newPassword = sc.next();
                                        userController.changePassword(id, oldPassword, newPassword);
                                        continue;
                                    case 4:
                                        break;
                                    case 0:
                                        System.exit(0);
                                    default:
                                        System.out.println("Wrong data.Repeat.");
                                        continue;
                                }
                            }
                        } else {
                            System.out.println("Wrond data.Repeat");
                            continue;
                        }
                    } catch (PersistException e) {
                        System.out.println("Wrong input data.");
                        continue;
                    }
                case 2:
                    //CLient
                    while (true) {
                        System.out.print("Username: ");
                        username = sc.next();
                        System.out.print("Password: ");
                        password = sc.next();
                        try {
                            if (userController.loginUser(username, password)) {
                                while (true) {
                                    System.out.print("1.Show all trains\n2.Find train\n" +
                                            "3.Show Tickets\n4.Buy Ticket\n\n6.Back\n0.Exit\n: ");
                                    choice = Integer.parseInt(br.readLine());
                                    switch (choice) {
                                        case 1:
                                            List list = trainController.getAll();
                                            for (Object o : list) {
                                                System.out.println(o);
                                            }
                                            continue;
                                        case 2:
                                            System.out.print("Enter number of Train: ");
                                            id = Integer.parseInt(br.readLine());
                                            System.out.println(trainController.getTrain(id));
                                            continue;
                                        case 3:
                                            List listOfTickets = ticketController.getAll();
                                            for (Object o : listOfTickets) {
                                                System.out.println(o);
                                            }
                                            continue;
                                        case 4:
                                            System.out.print("Enter number of Train: ");
                                            id = Integer.parseInt(br.readLine());
                                            ticketController.buyTicket(ticketController.getTicket(id));
                                            continue;
                                        case 0:
                                            System.exit(0);
                                        default:
                                            System.out.println("Wrong data.Repeat.");
                                            continue;
                                    }
                                }
                            }
                        } catch (PersistException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wrong data.Repeat.");
                    continue;
            }
        }
    }
}

