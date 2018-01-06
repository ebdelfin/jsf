package apc.entjava.jkem.dataobjects;

import apc.entjava.jkem.services.CourseService;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CourseDao implements CourseService{
    private DataSource ds;

    public CourseDao() {
        try {
            Context initialContext = new InitialContext();
            this.ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/JKEMDB");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean apply(String username, int courseId) {


        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             stmt.executeUpdate("INSERT INTO `user_course`(`Courses_id`, `User_id`) VALUES (?,(SELECT id FROM `user` WHERE user.username = ?))");

             )
        {


            System.out.print(username);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
