/*
 * Warehouse.java
 */
package warehouse;

/**
 *
 * @author Brian
 */

import java.util.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Warehouse 
{
    private static final String NAME = "postgres";
    private static final String PASSWORD = "";
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/whdb";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String SQLICAT  = "insert into tblcategory values (?,?,?,?);";
    private static final String SQLIORD = "insert into tblorderdetail values (?,?,?,?,?);";
    private static final String SQLISUPP = "insert into tblsupplier values (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SQLIPROD = "insert into tblproduct values(?,?,?,?,?,?,?,?,?,?);";
    private static final String SQLSCPROD = "select * from tblproduct where tblproduct.categoryid =?;";
    private static final String SQLSSPROD = "select * from tblproduct where tblproduct.supplierid =?;";
    private static final String SQLSPROD = "select tblproduct.supplierid from tblproduct";
    private static final String SQLCPROD = "select tblproduct.categoryid from tblproduct";
    private static final String SQLSELECTUISPROD = "select tblproduct.unitsinstock from tblproduct where tblproduct.productid=?";
    private static final String SQLUPDATEPRO1 = "update tblproduct set unitprice =?, unitsonorder =? where productid=? ;";
    private static final String SQLUPDATEPRO2 = "update tblproduct set unitprice =?, unitsinstock =?, unitsonorder =? where productid=? ;";
    private PreparedStatement stmt;
    private String feedBack;
    private Connection connectDb;
    
    //String productId;
    //String productName;
    //String supplierId;
    //String categoryId;
    //double unitPrice;
    //double unitsInStock;
    //boolean discontinued;
    
    public Warehouse()
    {
        feedBack = "FeedBack: ";
        connectDb = null;
    }
    
    public void CategoryT(String id, String name, String des, String pic)
    {
        boolean autoCommit = true;
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement(SQLICAT);
            stmt.setString(1, ValidStr(id));
            stmt.setString(2, name);
            stmt.setString(3, des);
            stmt.setString(4, pic);
            stmt.execute();
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit(autoCommit);
            connectDb.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            feedBack += "\n"+ e.getMessage();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception exce)
            {
                feedBack += exce.getMessage();
            }
        }
        catch(Exception ex)
        {
            feedBack += ex.getMessage();
        }
        feedBack += "\n Done.";
    }
    
    public void OrderT(String id, String product, double price, double quantity, double discount)
    {
        boolean autoCommit = true;
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement(SQLIORD);
            stmt.setString(1, ValidStr(id));
            stmt.setString(2, product);
            stmt.setDouble(3, price);
            stmt.setDouble(4, quantity);
            stmt.setDouble(5, discount);
            stmt.execute();
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit(autoCommit);
            connectDb.close();
            updateProduct(price, quantity, id);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            feedBack += "\n"+ e.getMessage();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception exc)
            {
                feedBack += exc.getMessage();
            }
        }
        catch(Exception ex)
        {
            feedBack += ex.getMessage();
        }
        feedBack += "\n Done.";
        
    }
    
    public void ProductT(String id, String name, String supplier, String category, double quantity, double price, double unitsStock, double unitsOrd, double reordeL, boolean disco)
    {
        boolean autoCommit = true;
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement(SQLIPROD);
            stmt.setString(1, ValidStr(id));
            stmt.setString(2, name);
            stmt.setString(3, supplier);
            stmt.setString(4, category);
            stmt.setDouble(5, quantity);
            stmt.setDouble(6, price);
            stmt.setDouble(7, unitsStock);
            stmt.setDouble(8, unitsOrd);
            stmt.setDouble(9, reordeL);
            stmt.setBoolean(10, disco);
            stmt.execute();
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit(autoCommit);
            connectDb.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            feedBack += "\n"+ e.getMessage();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception exc)
            {
                feedBack += exc.getMessage();
            }
        }
        catch(Exception exce)
        {
            feedBack += exce.getMessage();
        }
        feedBack += "\n Done.";
        
    }
    
    public void SupplierT(String id, String company, String contact, String title, String addres, String city, String region, String code, String country, String phone, String fax, String page)
    {
        boolean autoCommit = true;
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement(SQLISUPP);
            stmt.setString(1, ValidStr(id));
            stmt.setString(2, company);
            stmt.setString(3, contact);
            stmt.setString(4, title);
            stmt.setString(5, addres);
            stmt.setString(6, city);
            stmt.setString(7, region);
            stmt.setString(8, code);
            stmt.setString(9, country);
            stmt.setString(10, phone);
            stmt.setString(11, fax);
            stmt.setString(12, page);
            stmt.execute();
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit(autoCommit);
            connectDb.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            feedBack += "\n"+ e.getMessage();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception exc)
            {
                feedBack += exc.getMessage();
            }
        }
        catch(Exception exce)
        {
            feedBack += exce.getMessage();
        }
        feedBack += "\n Done.";
    }
    
    public String FeedBack()
    {
        return feedBack;
    }
    
    public List FilterT(String queryStr)
    {
        List<String> qlist = new ArrayList<>();
        /////////////////////////////////////
        String x;
        feedBack = "OK";
        String q = SQLSPROD;
        String columnl = "SupplierID";
        String query = ValidStr(queryStr);
        if(query.charAt(0) == 'c')
        {
            q = SQLCPROD;
            columnl = "CategoryID";
        }
        //qlist.add(columnl);
        boolean autoCommit = true;
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit ();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement (q);
            ResultSet rs = stmt.executeQuery ();
            while(rs.next())
            {
                x = rs.getString(columnl);
                qlist.add(x);
            }
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit ( autoCommit );
            connectDb.close();
        }
        catch(ClassNotFoundException|SQLException ex)
        {
            feedBack = ex.getMessage ();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            }
            catch(SQLException ex1)
            {
                feedBack = ex1.getMessage ();
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception e)
            {
                feedBack += e.getMessage();
            }
        }
        catch(Exception exc)
        {
            feedBack += exc.getMessage();
        }
        ///////////////////////////////
        return qlist;
    }
    
    public void updateProduct(double price, double quantity, String idStr)
    {
        boolean autoCommit = true;
        String q = SQLUPDATEPRO1;
        String id = ValidStr(idStr);
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement(q);
            stmt.setDouble(1, price);
            stmt.setDouble(2, quantity);
            stmt.setString(3, id);
            stmt.execute();
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit(autoCommit);
            connectDb.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            feedBack += "\n"+ e.getMessage();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception exc)
            {
                feedBack += exc.getMessage();
            }
        }
        catch(Exception exce)
        {
            feedBack += exce.getMessage();
        }
        feedBack += "\n Done.";
    }
    
    public void updateProduct(double price, double uinstock, double order, String idStr)
    {
        boolean autoCommit = true;
        String q = SQLUPDATEPRO2;
        String id = ValidStr(idStr);
        double unitsin = UnitsIn(id);
        unitsin += uinstock;
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement(q);
            stmt.setDouble(1, price);
            stmt.setDouble(2, unitsin);
            stmt.setDouble(3, order);
            stmt.setString(4, id);
            stmt.execute();
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit(autoCommit);
            connectDb.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            feedBack += " uin: "+ unitsin + " <br> "+ e.getMessage();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception exc)
            {
                feedBack += exc.getMessage();
            }
        }
        catch(Exception exce)
        {
            feedBack += exce.getMessage();
        }
        feedBack += "\n Done.";   
    }
    
    public double UnitsIn(String id)
    {
        double x = 0.00;
        String columnl = "unitsinstock";
        String q = SQLSELECTUISPROD;
        boolean autoCommit = true;
        try
        {
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit ();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement (q);
            stmt.setString(1, ValidStr(id));
            ResultSet rs = stmt.executeQuery ();
            while(rs.next())
            {
                x = rs.getDouble(columnl);
            }
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit ( autoCommit );
            connectDb.close();
            feedBack += " x:"+ x+" <br>";
            return x;
        }
        catch(ClassNotFoundException|SQLException ex)
        {
            feedBack += "x \n"+ ex.getMessage ();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            }
            catch(SQLException ex1)
            {
                feedBack += ex1.getMessage ();
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception e)
            {
                feedBack += e.getMessage();
            }
        }
        catch(Exception exc)
        {
            feedBack += exc.getMessage();
        }
        ///////////////////////////////
        
        return x;
    }

    List FilterT(String fil, String reqId, String val) 
    {
        List<List> qlist = new ArrayList<>();
        /////////////////////////////////////
        List<Object> x = new ArrayList<>();
        feedBack = "OK";
        String q = SQLSPROD;
        String id = ValidStr(reqId);
        /////////////////////////////////
        boolean autoCommit = true;
        try
        {
            if(val.charAt(0) == 'c')
            {
                q = SQLSCPROD;
            }
            else if(val.charAt(0) == 's')
            {
                q = SQLSSPROD;
            }
            if(val.charAt(1) == fil.charAt(1))
            {
                feedBack += "Connecting...<br>";
            }
            Class.forName(DRIVER);
            connectDb = DriverManager.getConnection(DATABASE,NAME,PASSWORD);
            autoCommit = connectDb.getAutoCommit ();
            connectDb.setAutoCommit(false);
            stmt = connectDb.prepareStatement (q);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery ();
            while(rs.next())
            {
                x.add(rs.getString("productId"));
                x.add(rs.getString("productName"));
                x.add(rs.getString("supplierId"));
                x.add(rs.getString("categoryId"));
                x.add(rs.getDouble("unitprice"));
                x.add(rs.getDouble("unitsinstock"));
                x.add(rs.getBoolean("discontinued"));
                qlist.add(x);
                x = new ArrayList<>();
            }
            stmt.close();
            connectDb.commit();
            connectDb.setAutoCommit ( autoCommit );
            connectDb.close();
        }
        catch(ClassNotFoundException|SQLException ex)
        {
            feedBack = ex.getMessage ();
            try
            {
                connectDb.rollback ();
                connectDb.setAutoCommit ( autoCommit );
            }
            catch(SQLException ex1)
            {
                feedBack = ex1.getMessage ();
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception e)
            {
                feedBack += e.getMessage();
            }
        }
        catch(Exception exc)
        {
            feedBack += exc.getMessage();
        }
        ///////////////////////////////
        feedBack += " Done. <br>";
        /////////////////////////////////////////
        
        return qlist;
    }
    
    private String ValidStr(String str)
    {
        char []cTrim = { '"', ' ', '<', '>', ';', '=', '\\', ',', '\'', '-', '+', '#' };
        String idStr = str.trim();
        for(int i = 0 ; i < cTrim.length; i++)
        {
            idStr = idStr.replace(cTrim[i], ' ');
        }
        return idStr.trim();
    }
    
}
