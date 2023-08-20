package com.kraft.tests.jdbc_tests.day1;

import java.sql.*;

public class Jdbc2_Practice {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "password";


        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from locations");

        //get the locationId, streetaddress and postcode of first row
        resultSet.next();
        System.out.println("resultSet.getString(\"locationid\") = " + resultSet.getString("locationid"));
        System.out.println("resultSet.getString(\"streetaddress\") = " + resultSet.getString("streetaddress"));
        System.out.println("resultSet.getString(\"postcode\") = " + resultSet.getString("postcode"));

        System.out.println("    ");

        //get the locationid, streetaddress, city and region of second row
        resultSet.next();
        System.out.println("resultSet.getString(\"locationid\") = " + resultSet.getString("locationid"));
        System.out.println("resultSet.getString(\"streetaddress\") = " + resultSet.getString("streetaddress"));
        System.out.println("resultSet.getString(\"city\") = " + resultSet.getString("city"));
        System.out.println("resultSet.getString(\"region\") = " + resultSet.getString("region"));

        System.out.println("    ");

        //get all information of 5th row
        resultSet.next();
        resultSet.next();
        resultSet.next();
        for (int i = 1; i <= 6 ; i++) {
            System.out.println("resultSet.getString(i) = " + resultSet.getString(i));
        }

        System.out.println("    ");

        //get the region of last row
        resultSet.next();
        resultSet.next();
        resultSet.next();
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));

        connection.close();
        statement.close();
        resultSet.close();


    }

}
