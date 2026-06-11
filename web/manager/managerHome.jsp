<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Home</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container">
        <h2>Manager Dashboard</h2>
        <p>Siri: Welcome <strong><%= session.getAttribute("displayName") != null ? session.getAttribute("displayName") : "Manager" %></strong>.</p>
        <ul>
            <li><a href="../ManagerServlet?action=viewMessages">View Decrypted Messages</a></li>
            <li><a href="../ManagerServlet?action=worstAgent">View Worst-Performing Agent</a></li>
            <li><a href="../LogoutServlet">Logout</a></li>
        </ul>
    </div>
</body>
</html>
