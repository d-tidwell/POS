package pos.models;

public class Item{

    private final String id;
    private String itemName;
    private String itemDescription;
    private String menuHeading;
    private String price;
    private String station;

    public Item(String id, String itemName, String itemDescription, String menuHeading, String price){
        this.id = id;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.menuHeading = menuHeading;
        this.price = price;
        if(this.id.charAt(0) == '1'){
            this.station = "GRILL";
        }
        if(this.id.charAt(0) == '2'){
            this.station = "SAUTE";
        }
        if(this.id.charAt(0) == '3'){
            this.station = "SALAD";
        }
        if(this.id.charAt(0) == '4'){
            this.station = "BAR";
        }
        if(this.id.charAt(0) == '5'){
            this.station = "DESSERT";
        }
        if(this.id.charAt(0) == '6'){
            this.station = "MISC";
        }
    }

    public String getID(){
        return this.id;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getItemDescription(){
        return this.itemDescription;
    }
    public String getMenuHeading(){
        return this.menuHeading;
    }
    public String getPrice(){
        return this.price;
    }

    public String getStation(){
        return this.station;
    }

    // Returns a string of the item's information
    public String toString () {
        return "Item [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + "]";
    }
}