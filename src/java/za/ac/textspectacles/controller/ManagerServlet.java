package za.ac.textspectacles.controller;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.crypto.SecretKey;
import za.ac.textspectacles.ejb.AgentAnalysisBean;
import za.ac.textspectacles.ejb.KeyServiceBean;
import za.ac.textspectacles.ejb.MessageServiceBean;
import za.ac.textspectacles.model.AgentStats;
import za.ac.textspectacles.model.Message;
import za.ac.textspectacles.util.CryptoUtil;

@WebServlet(name = "ManagerServlet", urlPatterns = {"/ManagerServlet"})
public class ManagerServlet extends HttpServlet {

    @EJB
    private MessageServiceBean messageService;

    @EJB
    private AgentAnalysisBean analysisBean;

    @EJB
    private KeyServiceBean keyService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("viewMessages".equals(action)) {
                List<Message> messages = messageService.getOrderedMessages();
                String keyString = keyService.getAnyAgentKey();
                if (keyString != null) {
                    SecretKey key = CryptoUtil.stringToKey(keyString);
                    for (Message m : messages) {
                        try {
                            m.setDecryptedText(CryptoUtil.decrypt(m.getCiphertext(), key));
                        } catch (Exception ex) {
                            m.setDecryptedText("[Decryption failed]");
                        }
                    }
                }
                request.setAttribute("messages", messages);
                request.getRequestDispatcher("/manager/viewMessages.jsp").forward(request, response);
                return;
            }

            if ("worstAgent".equals(action)) {
                AgentStats stats = analysisBean.getWorstPerformingAgent();
                request.setAttribute("worstAgent", stats);
                request.getRequestDispatcher("/manager/worstAgent.jsp").forward(request, response);
                return;
            }

            response.sendRedirect(request.getContextPath() + "/manager/managerHome.jsp");
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/errors/generalError.jsp").forward(request, response);
        }
    }
}
