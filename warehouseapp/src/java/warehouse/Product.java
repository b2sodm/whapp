/*
 * Product.java
 */
package warehouse;

import java.util.*;

/**
 *
 * @author Brian
 */
public class Product 
{
    private String productId;
    private String productName;
    private String supplierId;
    private String categoryId;
    private String quantityPu;
    private String unitP;
    private String unitS;
    private String unitO;
    private String reorderL;
    private String discontinued;
    Warehouse pro;
    public Product()
    {
        pro = new Warehouse();
    }
    
    public String addProduct(String id, String name, String supplier, String category, String quantity, String price, String uStock, String uOrder, String reOlevel, String disco)
    {
        String feedBack = "AddCat: \n";
        char []cTrim = { '"', ' ', '<', '>', ';', '=', '\\', ',', '\'', '-', '+', '#' };
        productId = id.trim();
        productName = name.trim();
        supplierId = supplier.trim();
        categoryId = category.trim();
        quantityPu = quantity.trim();
        unitP = price.trim();
        unitS = uStock.trim();
        unitO = uOrder.trim();
        reorderL = reOlevel.trim();
        discontinued = disco.trim();
        for(int i = 0 ; i < cTrim.length; i++)
        {
            productId = productId.replace(cTrim[i], ' ');
            productName = productName.replace(cTrim[i], ' ');
            supplierId = supplierId.replace(cTrim[i], ' ');
            categoryId = categoryId.replace(cTrim[i], ' ');
            quantityPu = quantityPu.replace(cTrim[i], ' ');
            unitP = unitP.replace(cTrim[i], ' ');
            unitS = unitS.replace(cTrim[i], ' ');
            unitO = unitO.replace(cTrim[i], ' ');
            reorderL = reorderL.replace(cTrim[i], ' ');
            discontinued = disco.replace(cTrim[i], ' ');
            
        }
        try
        {
            pro.ProductT(productId, productName, supplierId, categoryId, Double.parseDouble(quantityPu), Double.parseDouble(unitP), Double.parseDouble(unitS), Double.parseDouble(unitO), Double.parseDouble(reorderL), Boolean.parseBoolean(discontinued));
            return pro.FeedBack();
        }
        catch(Exception e)
        {
            feedBack += e.getMessage();
        }
        return feedBack;
    }
    
    public String [] ProductList()
    {
        String [] newProduct = {productId, productName, supplierId, categoryId, quantityPu, unitP, unitS, unitO, reorderL, discontinued};        
        return newProduct;
    }
    
    public List ProductList(String q)
    {
        return pro.FilterT(q);
    }
    
    public List ProductList(String filter, String reqId, String val)
    {
        //String feedBack = "AddCat: \n";
        char []cTrim = { '"', ' ', '<', '>', ';', '=', '\\', ',', '\'', '-', '+', '#' };
        String filt = filter.trim();
        String vald = val.trim();
        String id = reqId.trim();
        for(int i = 0 ; i < cTrim.length; i++)
        {
            filt = filt.replace(cTrim[i], ' ');
            vald = vald.replace(cTrim[i], ' ');
            id = id.replace(cTrim[i], ' ');
        }
        return pro.FilterT(filt, id, vald);
    }
    
    public String updateProduct()
    {
        return pro.FeedBack();
    }
}
