package za.ac.textspectacles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KeyDAO {

    public void saveOrUpdateKey(String username, String roleName, String secretKey) throws Exception {
        String sql = "INSERT INTO shared_keys(username, role_name, secret_key) VALUES(?,?,?) " +
                     "ON DUPLICATE KEY UPDATE role_name=VALUES(role_name), secret_key=VALUES(secret_key)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, roleName);
            ps.setString(3, secretKey);
            ps.executeUpdate();
        }
    }

    public String findKeyByUsername(String username) throws Exception {
        String sql = "SELECT secret_key FROM shared_keys WHERE username=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("secret_key");
                }
            }
        }
        return null;
    }

    public String findAnyAgentKey() throws Exception {
        String sql = "SELECT secret_key FROM shared_keys WHERE role_name='agent' ORDER BY id DESC LIMIT 1";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("secret_key");
            }
        }
        return null;
    }
}
