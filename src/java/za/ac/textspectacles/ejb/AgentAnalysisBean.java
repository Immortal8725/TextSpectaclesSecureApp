package za.ac.textspectacles.ejb;

import javax.ejb.Stateless;
import za.ac.textspectacles.dao.MessageDAO;
import za.ac.textspectacles.model.AgentStats;

@Stateless
public class AgentAnalysisBean {
    private final MessageDAO messageDAO = new MessageDAO();

    public AgentStats getWorstPerformingAgent() throws Exception {
        return messageDAO.findWorstPerformingAgent();
    }
}
