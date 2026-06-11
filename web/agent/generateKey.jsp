<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Generate Key</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container card">
        <h2>Generate and View Secret Key</h2>
        <% if (request.getAttribute("success") != null) { %>
            <p class="success"><%= request.getAttribute("success") %></p>
            <p><strong>Generated Key:</strong> <%= request.getAttribute("generatedKey") %></p>
        <% } %>
        <form method="post" action="../AgentServlet">
            <input type="hidden" name="action" value="generateKey" />
            <button type="submit">Generate Key</button>
        </form>
        <p><a href="agentHome.jsp">Back</a></p>
    </div>
</body>
</html>
