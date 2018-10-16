/*
 *Category.java
 */
package warehouse;

/**
 *
 * @author Brian
 */

public class Category 
{
    private String categoryId;
    private String categoryName;
    private String description;
    private String picture;
    Warehouse cat;
    public Category()
    {
        cat = new Warehouse();
    }
    
    public String addCategory(String id, String name, String des, String pic)
    {
        String feedBack = "AddCat: \n";
        char []cTrim = { '"', ' ', '<', '>', ';', '=', '\\', ',', '\'', '-', '+', '#' };
        categoryId = id.trim();
        categoryName = name.trim();
        description = des.trim();
        picture = pic.trim();
        for(int i = 0 ; i < cTrim.length; i++)
        {
            categoryId = categoryId.replace(cTrim[i], ' ');
            categoryName = categoryName.replace(cTrim[i], ' ');
            description = description.replace(cTrim[i], ' ');
            picture = picture.replace(cTrim[i], ' ');
        }
        try
        {
            cat.CategoryT(categoryId, categoryName, description, picture);
            return cat.FeedBack();
        }
        catch(Exception e)
        {
            feedBack += e.getMessage();
        }
        return feedBack;
    }
    
    public String [] CategoryList()
    {
        String [] newCategory = {categoryId, categoryName, description, picture};        
        return newCategory;
    }
    
    /////////////////////Test////////////////////////
    
    public String getCategoryId()
    {
        return categoryId;
    }
    public void setCategoryId(String catid)
    {
        categoryId = catid;
    }
    
    public String getCategoryName()
    {
        return categoryName;
    }
    public void setCategoryName(String name)
    {
        categoryName = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String des) {
        description = des;
    }
     public String getPicture()
    {
        return picture;
    }
    public void setPicture(String pic)
    {
        picture = pic;
    }
    
    ////////////////////2018/////////////////////
}
