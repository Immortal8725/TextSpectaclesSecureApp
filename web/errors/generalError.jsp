<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>Error</title><link rel="stylesheet" href="../resources/css/style.css" /></head>
<body>
    <div class="container card">
        <h2>System Error</h2>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } else { %>
            <p class="error">An unexpected error occurred.</p>
        <% } %>
        <p><a href="../index.jsp">Home</a></p>
    </div>
</body>
</html>
