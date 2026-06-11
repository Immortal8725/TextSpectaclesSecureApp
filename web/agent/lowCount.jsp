<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Low Count</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container card">
        <h2>Total Low-Priority Messages</h2>
        <% if (request.getAttribute("lowCount") != null) { %>
            <p class="success">Low-priority messages sent to HQ: <strong><%= request.getAttribute("lowCount") %></strong></p>
        <% } %>
        <form method="post" action="../AgentServlet">
            <input type="hidden" name="action" value="countLow" />
            <label>Agent Name</label>
            <input type="text" name="agentName" required />
            <button type="submit">Count Low Messages</button>
        </form>
        <p><a href="agentHome.jsp">Back</a></p>
    </div>
</body>
</html>
