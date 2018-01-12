package Agenda;

import DatabaseOperations.DatabaseOperations;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Operations {
    Scanner scanner = new Scanner(System.in);
    DatabaseOperations databaseOperations = new DatabaseOperations();

    public void displayMenu() {
        System.out.println("1.Display Persons");
        System.out.println("2.Add");
        System.out.println("3.Delete");
        System.out.println("4.Update");
    }

    public void add() throws ClassNotFoundException, SQLException{


            System.out.println("Enter name and phone");

            System.out.print("Name = ");
            String name = scanner.next();

            System.out.print("Phone = ");
            String phone = scanner.next();

            Person p = new Person(name, phone);
            databaseOperations.addOnDatabase(p);

    }

    public void displayPersons() throws ClassNotFoundException, SQLException{
        List  <Person> personList = databaseOperations.readFromDatabase();

        for(int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getName());
            System.out.println(personList.get(i).getPhone() + "\n-------");
        }
    }

    public void deletePersons() throws ClassNotFoundException, SQLException{
        System.out.print("Enter a name to delete ");
        String name=scanner.next();
        databaseOperations.deleteFromDatabase(name);
    }

    public void updatePersons() throws ClassNotFoundException, SQLException{
        System.out.print("Change the following name");
        String oldName = scanner.next();

        System.out.print("New name = ");
        String newName = scanner.next();

        System.out.print("New Password = ");
        String newPassword = scanner.next();

        databaseOperations.updateDatabase(oldName,newName,newPassword);
    }
}
