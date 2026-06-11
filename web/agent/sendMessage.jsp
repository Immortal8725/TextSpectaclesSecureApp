<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Message</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container card">
        <h2>Encrypt and Send Message</h2>
        <% if (request.getAttribute("success") != null) { %>
            <p class="success"><%= request.getAttribute("success") %></p>
            <p><strong>Ciphertext Preview:</strong></p>
            <textarea rows="5" cols="80" readonly><%= request.getAttribute("ciphertext") %></textarea>
        <% } %>
        <form method="post" action="../AgentServlet">
            <input type="hidden" name="action" value="sendMessage" />
            <label>Agent Name</label>
            <input type="text" name="agentName" required />
            <label>Agent ID (3 digits)</label>
            <input type="text" name="agentId" maxlength="3" required />
            <label>Message</label>
            <textarea name="message" rows="5" required></textarea>
            <label>Classification</label>
            <select name="classification">
                <option value="Low">Low</option>
                <option value="High">High</option>
                <option value="Critical">Critical</option>
            </select>
            <button type="submit">Encrypt & Send to HQ</button>
        </form>
        <p><a href="agentHome.jsp">Back</a></p>
    </div>
</body>
</html>
