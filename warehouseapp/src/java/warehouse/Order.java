/*
 * Order.java
 */
package warehouse;

//import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class Order 
{
    private String orderId;
    private String productId;
    private String price;
    private String quantity;
    private String discount;
    Warehouse ord;
    public Order()
    {
        ord = new Warehouse();
        discount = "0.00";
        quantity = "0.00";
        price = "0.00";
        productId = "0.00";
        orderId = "0.00";
    }
    
    public String addOrder(String id, String product, String uprice, String quant, String disc)
    {
        String feedBack = "AddCat: \n";
        char []cTrim = { '"', ' ', '<', '>', ';', '=', '\\', ',', '\'', '-', '+', '#' };
        orderId = id.trim();
        productId = product.trim();
        price = uprice.trim();
        quantity = quant.trim();
        discount = disc.trim();
        for(int i = 0 ; i < cTrim.length; i++)
        {
            orderId = orderId.replace(cTrim[i], ' ');
            productId = productId.replace(cTrim[i], ' ');
            price = price.replace(cTrim[i], ' ');
            quantity = quantity.replace(cTrim[i], ' ');
            discount = discount.replace(cTrim[i], ' ');
        }
        try
        {
            ord.OrderT(orderId, productId, Double.parseDouble(price), Double.parseDouble(quantity), Double.parseDouble(discount));
            return ord.FeedBack();
        }
        catch(Exception e)
        {
            feedBack += e.getMessage();
        }
        return feedBack;
    }
    
    public String [] OrderList()
    {
        String [] newOrders = {orderId,productId,price,quantity,discount};        
        return newOrders;
    }
    
    public String updateOrder(String product, String unitp, String quantityp, String id)
    {
        String feedBack = "AddCat: \n";
        double ordu = 0.00;
        
        char []cTrim = { '"', ' ', '<', '>', ';', '=', '\\', ',', '\'', '-', '+', '#' };
        productId = product.trim();
        price = unitp.trim();
        quantity = quantityp.trim();
        orderId = id.trim();
        for(int i = 0 ; i < cTrim.length; i++)
        {
            productId = productId.replace(cTrim[i], ' ');
            price = price.replace(cTrim[i], ' ');
            quantity = quantity.replace(cTrim[i], ' ');
            orderId = orderId.replace(cTrim[i], ' ');
        }
        try
        {
            ord.updateProduct(Double.parseDouble(price), Double.parseDouble(quantity), ordu, productId);
            return ord.FeedBack(); 
        }
        catch(Exception e)
        {
            feedBack += e.getMessage();
        }
       return feedBack;
    }
}
