package DatabaseOperations;

import Agenda.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {
    public void addOnDatabase(Person person) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/razvan7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO agenda (name, phone) VALUES (?,?)");
        pSt.setString(1, person.getName());
        pSt.setString(2, person.getPhone());

        // 5. execute a prepared statement
        pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public List<Person> readFromDatabase() throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/razvan7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT name,phone FROM agenda");

        //read

        List<Person> persons = new ArrayList();
        while (rs.next()) {
            Person p = new Person();
            p.setName(rs.getString("name"));
            p.setPhone(rs.getString("phone"));
            persons.add(p);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return persons;
    }

    public void deleteFromDatabase(String name) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/razvan7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM agenda WHERE name=?");
        pSt.setString(1, name);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();
        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public void updateDatabase(String oldName, String newName, String newPassword) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/razvan7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE agenda SET name=?,phone=? WHERE name=?");
        pSt.setString(1, newName);
        pSt.setString(2, newPassword);
        pSt.setString(3, oldName);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }
}
