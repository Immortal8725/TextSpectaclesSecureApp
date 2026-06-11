<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
    <div class="container card">
        <h2>Secure Login</h2>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
        <% if (request.getParameter("loggedOut") != null) { %>
            <p class="success">You have successfully logged out.</p>
        <% } %>
        <form method="post" action="LoginServlet">
            <label>Username</label>
            <input type="text" name="username" required />
            <label>Password</label>
            <input type="password" name="password" required />
            <button type="submit">Login</button>
        </form>
        <p class="small">Users: agent1 / 123, agent2 / 321, boss / 123</p>
    </div>
</body>
</html>
