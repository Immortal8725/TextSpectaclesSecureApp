<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Retract Message</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container card">
        <h2>Retract a Ciphertext</h2>
        <% if (request.getAttribute("success") != null) { %>
            <p class="success"><%= request.getAttribute("success") %></p>
        <% } %>
        <form method="post" action="../AgentServlet">
            <input type="hidden" name="action" value="retractMessage" />
            <label>Ciphertext ID</label>
            <input type="number" name="messageId" required />
            <button type="submit">Retract</button>
        </form>
        <p><a href="agentHome.jsp">Back</a></p>
    </div>
</body>
</html>
