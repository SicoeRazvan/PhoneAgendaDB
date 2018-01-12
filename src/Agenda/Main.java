package Agenda;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        int optiune;

        do {
            operations.displayMenu();
            System.out.print("Optiune -> ");
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();

            if (optiune >= 0 && optiune <= 5) {
                switch (optiune) {
                    case 1: {
                        try {
                            operations.displayPersons();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 2: {
                        try {
                            operations.add();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 3: {
                        try {
                            operations.deletePersons();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 4: {
                        try {
                            operations.updatePersons();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            } else {
                System.out.println("Optiune invalida");
            }
        } while (optiune != 0);
    }
}

