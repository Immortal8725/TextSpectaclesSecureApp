<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agent Home</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container">
        <h2>Agent Dashboard</h2>
        <p>Siri: Welcome <strong><%= session.getAttribute("displayName") != null ? session.getAttribute("displayName") : "Agent" %></strong>.</p>
        <ul>
            <li><a href="generateKey.jsp">Generate / View Secret Key</a></li>
            <li><a href="sendMessage.jsp">Encrypt and Send Message</a></li>
            <li><a href="retractMessage.jsp">Retract Ciphertext</a></li>
            <li><a href="lowCount.jsp">View Low Priority Count</a></li>
            <li><a href="../LogoutServlet">Logout</a></li>
        </ul>
    </div>
</body>
</html>
