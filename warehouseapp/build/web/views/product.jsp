<%-- 
    Document   : product
    Created on : 04 Oct 2018, 9:44:05 AM
    Author     : Brian
--%>

<%@page import="warehouse.Product" %>
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
            String id = request.getParameter("proid");
            String product = request.getParameter("proname");
            String supplier = request.getParameter("supid");
            String category = request.getParameter("catid");
            String quantity = request.getParameter("quantpu");
            String price = request.getParameter("prounitp");
            String uStock = request.getParameter("unitins");
            String uOrder = request.getParameter("unitono");
            String reOlevel = request.getParameter("reorderl");
            String disco = request.getParameter("discon");
            Product pro = new Product();
            String feedBack = pro.addProduct(id, product, supplier, category, quantity, price, uStock, uOrder, reOlevel, disco);
            java.util.Date date = new java.util.Date();
            String [] products = pro.ProductList();
        %>
        <h1>Products</h1>
        <br>
        id: <%=products[0]%> <br>
        name: <%=products[1]%> <br>
        supplier: <%=products[2]%> <br>
        category: <%=products[3]%> <br>
        quantityPerUnit: <%=products[4]%> <br>
        price: <%=products[5]%> <br>
        unitInStock: <%=products[6]%> <br>
        unitsOnOrder: <%=products[7]%> <br>
        reorderLevel: <%=products[8]%> <br>
        discontinued: <%=products[9]%> <br>
        feedBack: <%=feedBack%> <br>
        date: <%=date%> <br>
        
    </body>
</html>
