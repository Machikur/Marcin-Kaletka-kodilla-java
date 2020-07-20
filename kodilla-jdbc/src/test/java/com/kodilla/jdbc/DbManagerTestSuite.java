package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FISTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {

        //given
        DbManager dbManager = DbManager.getInstance();

        //when
        String stQuery = "SELECT U.ID,\n" +
                "CONCAT (U.FISTNAME ,\" \", U.LASTNAME) AS USER,\n" +
                "COUNT(P.USER_ID) AS NUMBER_OF_POSTS\n" +
                "FROM POSTS P\n" +
                "JOIN USERS U ON U.ID=P.USER_ID\n" +
                "GROUP BY U.ID\n" +
                "HAVING COUNT(*)>2";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(stQuery);


        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("USER"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(0, counter);
    }
}