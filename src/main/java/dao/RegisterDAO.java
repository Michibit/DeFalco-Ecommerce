package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    public static int registerUser(String username, String pass, String email) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        int rs;
        conn = ConnectionDB.getConnection();

        try {
            pst = conn.prepareStatement("INSERT INTO Cliente ( Username, Pass, Email) VALUES(?,?,?)");

            pst.setString(1, username);
            pst.setString(2, pass);
            pst.setString(3, email);

            rs = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
