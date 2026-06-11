package za.ac.textspectacles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import za.ac.textspectacles.model.AgentStats;
import za.ac.textspectacles.model.Message;

public class MessageDAO {

    public void saveMessage(Message message) throws Exception {
        String sql = "INSERT INTO messages(agent_name, agent_id, ciphertext, classification) VALUES(?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, message.getAgentName());
            ps.setString(2, message.getAgentId());
            ps.setString(3, message.getCiphertext());
            ps.setString(4, message.getClassification());
            ps.executeUpdate();
        }
    }

    public boolean deleteMessage(int id) throws Exception {
        String sql = "DELETE FROM messages WHERE id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<Message> findAllOrdered() throws Exception {
        String sql = "SELECT * FROM messages ORDER BY FIELD(classification, 'Critical', 'High', 'Low'), timestamp DESC";
        List<Message> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Message m = new Message();
                m.setId(rs.getInt("id"));
                m.setAgentName(rs.getString("agent_name"));
                m.setAgentId(rs.getString("agent_id"));
                m.setCiphertext(rs.getString("ciphertext"));
                m.setClassification(rs.getString("classification"));
                m.setTimestamp(rs.getTimestamp("timestamp"));
                list.add(m);
            }
        }
        return list;
    }

    public int countLowMessagesByAgentName(String agentName) throws Exception {
        String sql = "SELECT COUNT(*) total FROM messages WHERE classification='Low' AND agent_name=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, agentName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        }
        return 0;
    }

    public AgentStats findWorstPerformingAgent() throws Exception {
        String sql = "SELECT agent_name, agent_id, COUNT(*) total_messages FROM messages GROUP BY agent_name, agent_id ORDER BY total_messages ASC, agent_name ASC LIMIT 1";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new AgentStats(rs.getString("agent_name"), rs.getString("agent_id"), rs.getInt("total_messages"));
            }
        }
        return new AgentStats("N/A", "N/A", 0);
    }
}
