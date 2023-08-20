package com.kraft.tests.jdbc_tests.day2;

import com.kraft.utilities.DBUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Jdbc5_DbUtilsPractice {
    @Test
    public void listOfMap() {
        //create connection
        DBUtils.createConnection();

        //get all employees information and put them into a list of map
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap("select * from employees");
        //print all information that belongs the employees table
        System.out.println("queryResultMap = " + queryResultMap);
        //get the firstname of 5th row
        String actual = (String) queryResultMap.get(4).get("firstname");
        String expected = "Fethi";
        Assert.assertEquals(actual,expected);

        //close connection
        DBUtils.destroy();
    }


    @Test
    public void oneSingleRow(){
        //create connection
        DBUtils.createConnection();

        //get one row employee information and put them into a map
        Map<String, Object> rowMap = DBUtils.getRowMap("select * from employees where firstname = 'Elif'");
        System.out.println("rowMap = " + rowMap);

        int expectedEmployeeId = 1010;
        int actualEmployeeId = (int) rowMap.get("employeeid");

        Assert.assertEquals(actualEmployeeId,expectedEmployeeId);


        DBUtils.destroy();
    }
}
