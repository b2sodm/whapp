<%-- 
    Document   : order
    Created on : 03 Oct 2018, 9:01:58 PM
    Author     : Brian
--%>

<%@page import="warehouse.Order" %>
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
            String id = request.getParameter("order");
            String product = request.getParameter("prod");
            String unitp = request.getParameter("unitp");
            String quantity = request.getParameter("quan");
            String discount = request.getParameter("disc");
            String btn1 = request.getParameter("btnOkOrd");
            String selb2 = request.getParameter("selupDate");
            Order ord = new Order();
            String test = "3";
            String feedBack = " ";
            if(selb2.charAt(0) == 'n')
            {
                test = "newOrder";
                feedBack = ord.addOrder(id, product, unitp, quantity, discount);
            }
            else
            {
                test = "upDateProductTable";
                feedBack = ord.updateOrder(product, unitp, quantity, id);
            }
            
            
            
            java.util.Date date = new java.util.Date();
            String [] oders = ord.OrderList();
        %>
        <h1>Order Details</h1>
        
        <br>
        id: <%=oders[0]%> <br>
        product: <%=oders[1]%> <br>
        unitp: <%=oders[2]%> <br>
        quantity: <%=oders[3]%> <br>
        discount: <%=oders[4]%> <br>
        feedBack: <%=feedBack%> <br>
        date: <%=date%> <br>
        btn1: <%=btn1%> <br>
        selb2: <%=selb2%> <br>
        test: <%=test%> <br>
    </body>
</html>
