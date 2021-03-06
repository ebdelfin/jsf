package apc.entjava.jkem.dataobjects;

import apc.entjava.jkem.services.LoginService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao implements LoginService{
    private DataSource ds;

    public LoginDao() {
        try {
            Context initialContext = new InitialContext();
            this.ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/JKEMDB");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean login(String username, String password) {
        try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE username =? AND password=?")){
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
