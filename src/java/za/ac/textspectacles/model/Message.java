package za.ac.textspectacles.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
    private int id;
    private String agentName;
    private String agentId;
    private String ciphertext;
    private String classification;
    private Timestamp timestamp;
    private String decryptedText;

    public Message() {}

    public Message(int id, String agentName, String agentId, String ciphertext, String classification, Timestamp timestamp) {
        this.id = id;
        this.agentName = agentName;
        this.agentId = agentId;
        this.ciphertext = ciphertext;
        this.classification = classification;
        this.timestamp = timestamp;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }
    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }
    public String getCiphertext() { return ciphertext; }
    public void setCiphertext(String ciphertext) { this.ciphertext = ciphertext; }
    public String getClassification() { return classification; }
    public void setClassification(String classification) { this.classification = classification; }
    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
    public String getDecryptedText() { return decryptedText; }
    public void setDecryptedText(String decryptedText) { this.decryptedText = decryptedText; }
}
