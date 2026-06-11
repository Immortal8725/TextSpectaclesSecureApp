package za.ac.textspectacles.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.crypto.SecretKey;
import za.ac.textspectacles.dao.MessageDAO;
import za.ac.textspectacles.model.Message;
import za.ac.textspectacles.util.CryptoUtil;
import za.ac.textspectacles.util.ValidationUtil;

@Stateless
public class MessageServiceBean {
    private final MessageDAO messageDAO = new MessageDAO();

    public String encryptAndSave(String agentName, String agentId, String plainText, String classification, String keyString) throws Exception {
        ValidationUtil.require(ValidationUtil.isValidAgentId(agentId), "Invalid field agent ID. It must be numeric and exactly 3 digits.");
        ValidationUtil.require(ValidationUtil.isValidClassification(classification), "Invalid classification.");
        ValidationUtil.require(plainText != null && !plainText.trim().isEmpty(), "Message may not be empty.");

        SecretKey key = CryptoUtil.stringToKey(keyString);
        String ciphertext = CryptoUtil.encrypt(plainText, key);

        Message msg = new Message();
        msg.setAgentName(agentName);
        msg.setAgentId(agentId);
        msg.setCiphertext(ciphertext);
        msg.setClassification(classification);
        messageDAO.saveMessage(msg);
        return ciphertext;
    }

    public boolean retractMessage(int id) throws Exception {
        return messageDAO.deleteMessage(id);
    }

    public List<Message> getOrderedMessages() throws Exception {
        return messageDAO.findAllOrdered();
    }

    public int countLowMessages(String agentName) throws Exception {
        return messageDAO.countLowMessagesByAgentName(agentName);
    }
}
