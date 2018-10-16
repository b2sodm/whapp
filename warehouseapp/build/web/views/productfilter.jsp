<%-- 
    Document   : productfilter
    Created on : 05 Oct 2018, 10:15:50 AM
    Author     : Brian
--%>

<%@page import="java.util.*"%>
<%@page import="warehouse.Product" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warehouse app</title>
        <script src="../js/jquery-1.js"></script>
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body>
        <a href="../index.jsp?wcode=#ind">Home.</a>
        <hr>
        <h1>Product filter</h1>
        <%
            String filter = request.getParameter("wcode");
            String test = " ";
            Product pro = new Product();
            List prolist = new ArrayList();
            switch(filter.charAt(0))
            {
                case 'c':
                    test = "cat";
                    prolist = pro.ProductList(test);
                    break;
                case 's':
                    test = "sup";
                    prolist = pro.ProductList(test);
                    break;
                default:
                    test = "Please select your options.<br>";
                    test += "<a href=" + "warehouse.html?wcode=#adm" + ">Admin.</a>";
                    break;
            }
        %>
        <br>
        Filter by: <input type="text" id="txbFilter" value="<%=test%>" readonly=""> <br>
        <%
            int res = prolist.size();  
            if(res < 1)
            {
                prolist.add("Test123");
                prolist.add("Test456");
                prolist.add("Test789");
                prolist.add("Test101");
            }
            int res2 = prolist.size();
        %>
        <hr>
        Results: <%=res2%> <br>
        <form action="" method="get">
            <select id="result">
                <option value="<%=res2%>"><%=res2%></option>
                <option value="Test">Test</option>
                <%for(int i = 0; i < res2; i++){%>
                <option value="<%=prolist.get(i)%>"><%=prolist.get(i)%></option>
                <%}%>
            </select>
            <input type="button" id="btnOK" name="btnOK" value="OK">
        </form>
        <hr>    
        <div id="divResult" style="background-color: blueviolet">
            Results1.    
        </div>
        <div id="divResult2" style="background-color: deepskyblue">
            Results2
        </div>
        <script src="../js/productfilter.js"></script>    
    </body>
</html>
