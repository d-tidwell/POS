package pos;

public class Item{

    private String id;
    private String itemName;
    private String itemDescription;
    private String menuHeading;
    private String price;

    public Item(String id, String itemName, String itemDescription, String menuHeading, String price){
        this.id = id;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.menuHeading = menuHeading;
        this.price = price;
    }

    public String getID (){
        return id;
    }

    public String getItemName (){
        return itemName;
    }

    public String getItemDescription (){
        return itemDescription;
    }
    public String getMenuHeading (){
        return menuHeading;
    }
    public String getPrice (){
        return price;
    }

    // Returns a string of the item's information
    public String toString () {
        String result = "Item [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + "]";
        return result;
    }
}