<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="za.ac.textspectacles.model.AgentStats"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Worst Agent</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container card">
        <h2>Worst-Performing Agent</h2>
        <% AgentStats a = (AgentStats) request.getAttribute("worstAgent"); %>
        <% if (a != null) { %>
            <p><strong>Name:</strong> <%= a.getAgentName() %></p>
            <p><strong>ID:</strong> <%= a.getAgentId() %></p>
            <p><strong>Total Messages:</strong> <%= a.getTotalMessages() %></p>
        <% } else { %>
            <p>No data available.</p>
        <% } %>
        <p><a href="managerHome.jsp">Back</a></p>
    </div>
</body>
</html>
