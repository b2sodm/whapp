<%-- 
    Document   : index
    Created on : 02 Oct 2018, 11:04:38 AM
    Author     : Brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warehouse App.</title>
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body>
        <h1>Warehouse app.</h1>
        <ul>
            <li><a href="views/warehouse.html?wcode=#cat">Categories.</a>
            <li><a href="views/warehouse.html?wcode=#pro">Products.</a>
            <li><a href="views/warehouse.html?wcode=#sup">Suppliers.</a>
            <li><a href="views/warehouse.html?wcode=#ord">Order Details.</a>
            <li><a href="views/warehouse.html?wcode=#adm">Admin.</a>
        </ul>
        <%
            java.util.Date date = new java.util.Date();
        %>
        <div>
            <%=date.toString()%>
        </div>
    </body>
</html>
