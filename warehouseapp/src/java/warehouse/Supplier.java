/*
 * Supplier.java
 */
package warehouse;

/**
 *
 * @author Brian
 */
public class Supplier 
{
    private String supplierId;
    private String companyName;
    private String contact;
    private String title;
    private String address;
    private String city;
    private String region;
    private String code;
    private String country;
    private String phone;
    private String fax;
    private String page;
    Warehouse supp;
    public Supplier()
    {
        supp = new Warehouse();
    }
    
    public String addSupplier(String id, String company, String name, String cTitle, String cAddress, String cCity, String cRegion, String pCode, String cCountry, String cPhone, String cFax, String homePage)
    {
        String feedBack = "AddCat: \n";
        char []cTrim = { '"', ' ', '<', '>', ';', '=', '\\', ',', '\'', '-', '+', '#' };
        supplierId = id.trim();
        companyName = company.trim();
        contact = name.trim();
        title = cTitle.trim();
        address = cAddress.trim();
        city = cCity.trim();
        region = cRegion.trim();
        code = pCode.trim();
        country = cCountry.trim();
        phone = cPhone.trim();
        fax = cFax.trim();
        page = homePage.trim();
        for(int i = 0 ; i < cTrim.length; i++)
        {
            supplierId = supplierId.replace(cTrim[i], ' ');
            companyName = companyName.replace(cTrim[i], ' ');
            contact = contact.replace(cTrim[i], ' ');
            title = title.replace(cTrim[i], ' ');
            address = address.replace(cTrim[i], ' ');
            city = city.replace(cTrim[i], ' ');
            region = region.replace(cTrim[i], ' ');
            code = code.replace(cTrim[i], ' ');
            country = country.replace(cTrim[i], ' ');
            phone = phone.replace(cTrim[i], ' ');
            fax = fax.replace(cTrim[i], ' ');
            page = page.replace(cTrim[i], ' ');
        }
        try
        {
            supp.SupplierT(supplierId, companyName, contact, title, address, city, region, code, country, phone, fax, page);
            return supp.FeedBack();
        }
        catch(Exception e)
        {
            feedBack += e.getMessage();
        }
        return feedBack;
    }
    
    public String [] SupplierList()
    {
        String [] newSupplier = {supplierId, companyName, contact, title, address, city, region, code, country, phone, fax, page};        
        return newSupplier;
    }
    
}
