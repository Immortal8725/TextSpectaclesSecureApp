package za.ac.textspectacles.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.textspectacles.ejb.KeyServiceBean;
import za.ac.textspectacles.ejb.MessageServiceBean;

@WebServlet(name = "AgentServlet", urlPatterns = {"/AgentServlet"})
public class AgentServlet extends HttpServlet {

    @EJB
    private KeyServiceBean keyService;

    @EJB
    private MessageServiceBean messageService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        try {
            if ("generateKey".equals(action)) {
                String key = keyService.generateAndStoreKey(username, "agent");
                session.setAttribute("sharedKey", key);
                request.setAttribute("success", "Secret key generated and stored successfully.");
                request.setAttribute("generatedKey", key);
                request.getRequestDispatcher("/agent/generateKey.jsp").forward(request, response);
                return;
            }

            if ("sendMessage".equals(action)) {
                String agentName = request.getParameter("agentName");
                String agentId = request.getParameter("agentId");
                String message = request.getParameter("message");
                String classification = request.getParameter("classification");
                String key = (String) session.getAttribute("sharedKey");
                if (key == null || key.trim().isEmpty()) {
                    key = keyService.getKeyForUser(username);
                }
                String ciphertext = messageService.encryptAndSave(agentName, agentId, message, classification, key);
                request.setAttribute("success", "Ciphertext saved to HQ successfully.");
                request.setAttribute("ciphertext", ciphertext);
                request.getRequestDispatcher("/agent/sendMessage.jsp").forward(request, response);
                return;
            }

            if ("retractMessage".equals(action)) {
                int messageId = Integer.parseInt(request.getParameter("messageId"));
                boolean removed = messageService.retractMessage(messageId);
                request.setAttribute("success", removed ? "Ciphertext removed from HQ." : "Ciphertext could not be removed.");
                request.getRequestDispatcher("/agent/retractMessage.jsp").forward(request, response);
                return;
            }

            if ("countLow".equals(action)) {
                String agentName = request.getParameter("agentName");
                int total = messageService.countLowMessages(agentName);
                request.setAttribute("lowCount", total);
                request.getRequestDispatcher("/agent/lowCount.jsp").forward(request, response);
                return;
            }

            response.sendRedirect(request.getContextPath() + "/agent/agentHome.jsp");
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/errors/generalError.jsp").forward(request, response);
        }
    }
}
