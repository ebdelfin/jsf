package apc.entjava.logindemo.dataobjects;

import apc.entjava.logindemo.services.LoginService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by student on 12/9/2017.
 */
public class LoginDao implements LoginService {

    private DataSource ds;

    public LoginDao() {
        try {
            Context initialContext = new InitialContext();
            ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/LoginDB");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean login(String username, String password) {
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM users WHERE username=? AND password=?"
             )) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return true;
                }
                else {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
