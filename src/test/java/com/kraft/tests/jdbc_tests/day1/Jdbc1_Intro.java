package com.kraft.tests.jdbc_tests.day1;

import java.sql.*;

public class Jdbc1_Intro {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "password";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        //create a statement object
        Statement statement = connection.createStatement();

        //run query and get the result in result set object
        ResultSet resultSet = statement.executeQuery("select * from employees");

        //move pointer to the next row
        resultSet.next();
        //getting the information by column name
        String employeeid = resultSet.getString("employeeid");
        System.out.println("employeeid = " + employeeid);

        System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstname"));

        //getting the information by index number
        System.out.println("resultSet.getString(3) = " + resultSet.getString(3));

        //move pointer to the 2nd row
        resultSet.next();
        //get the phonenumber by column name
        System.out.println("resultSet.getString(\"phonenumber\") = " + resultSet.getString("phonenumber"));
        //get the phonenumber by index number
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));
        
        //get all employeeId, firstname and lastname in one shot
        while (resultSet.next()){
            System.out.println("resultSet.getString(\"employeeid\") = " + resultSet.getString("employeeid"));
            System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstname"));
            System.out.println("resultSet.getString(\"lastname\") = " + resultSet.getString("lastname"));
        }





        resultSet.close();
        statement.close();
        connection.close();
    }
}
