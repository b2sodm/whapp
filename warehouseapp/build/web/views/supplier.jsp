<%-- 
    Document   : supplier
    Created on : 04 Oct 2018, 6:00:32 PM
    Author     : Brian
--%>

<%@page import="warehouse.Supplier" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warehouse app</title>
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body>
        <a href="../index.jsp?wcode=#ind">Home.</a>
        <hr>
        <%
            String id = request.getParameter("ssupid");
            String company = request.getParameter("compname");
            String contact = request.getParameter("contname");
            String title = request.getParameter("contt");
            String address = request.getParameter("addr");
            String city = request.getParameter("city");
            String region = request.getParameter("regi");
            String code = request.getParameter("postc");
            String country = request.getParameter("countr");
            String phone = request.getParameter("phon");
            String fax = request.getParameter("fax");
            String hpage = request.getParameter("homep");
            Supplier supp = new Supplier();
            String feedBack = supp.addSupplier(id, company, contact, title, address, city, region, code, country, phone, fax, hpage);
            java.util.Date date = new java.util.Date();
            String [] supplierl = supp.SupplierList();
        %>
        <h1>Suppliers</h1>
        <br>
        id: <%=supplierl[0]%> <br>
        company: <%=supplierl[1]%> <br>
        contact: <%=supplierl[2]%> <br>
        title: <%=supplierl[3]%> <br>
        address: <%=supplierl[4]%> <br>
        city: <%=supplierl[5]%> <br>
        region: <%=supplierl[6]%> <br>
        code: <%=supplierl[7]%> <br>
        country: <%=supplierl[8]%> <br>
        phone: <%=supplierl[9]%> <br>
        fax: <%=supplierl[10]%> <br>
        page: <%=supplierl[11]%> <br>
        feedBack: <%=feedBack%> <br>
        date: <%=date%> <br>
        
    </body>
</html>
