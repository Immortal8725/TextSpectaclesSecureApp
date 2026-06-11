package za.ac.textspectacles.model;

import java.io.Serializable;

public class AgentStats implements Serializable {
    private String agentName;
    private String agentId;
    private int totalMessages;

    public AgentStats() {}

    public AgentStats(String agentName, String agentId, int totalMessages) {
        this.agentName = agentName;
        this.agentId = agentId;
        this.totalMessages = totalMessages;
    }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }
    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }
    public int getTotalMessages() { return totalMessages; }
    public void setTotalMessages(int totalMessages) { this.totalMessages = totalMessages; }
}
