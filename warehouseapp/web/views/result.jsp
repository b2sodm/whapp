<%-- 
    Document   : result
    Created on : 10 Oct 2018, 10:32:37 AM
    Author     : Brian
--%>

<%@page import="java.time.*"%>
<%@page import="java.util.*"%>
<%@page import="warehouse.Product" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WHApp</title>
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body>
        <%
            String wcd = request.getParameter("wcode");
            String [] wrs = wcd.split(",");
            int res2 = wrs.length;
            String option = "Products";
            Product pro2 = new Product();
            List prolist2 = new ArrayList();
            String prolist;
            String [] prol;
            int pl2;
            String [] product = {"ProductID", "ProductName", "SupplierID", "CategoryID", "UnitPrice", "UnitsInStock","Discontinued"};
            int pl = product.length;
            if(res2 > 2)
            {
                option = wrs[2];
                prolist2 = pro2.ProductList(wrs[0], wrs[1], wrs[2]);
            }
            Date d = new Date();
            prolist2.add(d.getTime());
            int pl3 = prolist2.size();
            
        %>
        
        <%!
            String [] productList3(String listStr)
            {
               String listX = listStr.replace("[", "");
               listX = listX.replace("]", "");
               String [] prol2 = listX.split(",");
               return prol2;
            }
        %>
        
        <h1>WHApp</h1>
        <br>
        <table witdth="100%" border="1" align="center">
            <caption><%=option%></caption>
            <thead>
                <tr>
                    <%for(int i = 0; i < pl; i++){%>
                    <th><%=product[i]%></th>
                    <%}%>
                </tr>
            </thead>
            <tbody>
                <%for(int i = 0; i < pl3; i++){%>
                <% 
                    prolist = prolist2.get(i).toString();
                    prol = productList3(prolist);
                    pl2 = prol.length;
                %>
                <tr>
                    <%for(int j = 0; j < pl2; j++){%>
                    <td><%=prol[j]%></td>
                    <%}%>
                </tr>
                <%}%>
            </tbody>
        </table>
        <br>
        <%=pro2.updateProduct()%><br>
    </body>
</html>
