<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.textspectacles.model.Message"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Decrypted Messages</title>
    <link rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>
    <div class="container card wide">
        <h2>Decrypted Messages (Critical → High → Low)</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Agent Name</th>
                <th>Agent ID</th>
                <th>Classification</th>
                <th>Decrypted Message</th>
                <th>Timestamp</th>
            </tr>
            <%
                List<Message> messages = (List<Message>) request.getAttribute("messages");
                if (messages != null) {
                    for (Message m : messages) {
            %>
            <tr>
                <td><%= m.getId() %></td>
                <td><%= m.getAgentName() %></td>
                <td><%= m.getAgentId() %></td>
                <td><%= m.getClassification() %></td>
                <td><%= m.getDecryptedText() %></td>
                <td><%= m.getTimestamp() %></td>
            </tr>
            <%      }
                }
            %>
        </table>
        <p><a href="managerHome.jsp">Back</a></p>
    </div>
</body>
</html>
