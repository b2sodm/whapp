<%-- 
    Document   : category
    Created on : 01 Oct 2018, 4:31:06 PM
    Author     : Brian
--%>

<%@page import="warehouse.Category" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warehouse App</title>
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body>
        <a href="../index.jsp?wcode=#ind">Home.</a>
        <hr>
        <%
            String catid = request.getParameter("ccatid");
            String catName = request.getParameter("catname");
            String catdes = request.getParameter("descr");
            String catpic = request.getParameter("pict");
            Category ctp = new Category();
            String feedBack = ctp.addCategory(catid, catName, catdes, catpic);
            String [] categoryl = ctp.CategoryList();
            java.util.Date date = new java.util.Date();
        %>
       
        <jsp:useBean id="category" class="warehouse.Category"></jsp:useBean>
        <h1>Category</h1>
        <jsp:setProperty name="category" property="description" value="<%=categoryl[2]%>"/>
        <jsp:getProperty name="category" property="description"/>
        <jsp:setProperty name="category" property="categoryName" value="<%=categoryl[1]%>"/>
        <jsp:getProperty name="category" property="categoryName"/>
        
        <br>
        Cat id: <%=categoryl[0]%> <br>
        Cat name: <%=categoryl[1]%> <br>
        Cat description: <%=categoryl[2]%> <br>
        Cat picture: <%=categoryl[3]%> <br>
        Cat feedBack: <%=feedBack%> <br>
        Cat date: <%=date%> <br>
    </body>
</html>
