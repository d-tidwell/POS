package pos.models;

/**
 * Represents an item in a restaurant menu.
 */
public class Item {
    private final String id;
    private String itemName;
    private String itemDescription;
    private String menuHeading;
    private String price;
    private String station;

    /**
     * Constructs a new Item with the given ID, name, description, menu heading, and price.
     * The station is determined based on the first character of the ID.
     *
     * @param id the ID of the item
     * @param itemName the name of the item
     * @param itemDescription the description of the item
     * @param menuHeading the menu heading of the item
     * @param price the price of the item
     */
    public Item(String id, String itemName, String itemDescription, String menuHeading, String price) {
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

    /**
     * Returns the ID of this item.
     *
     * @return the ID of the item
     */
    public String getID() {
        return this.id;
    }

    /**
     * Returns the name of this item.
     *
     * @return the name of the item
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Returns the description of this item.
     *
     * @return the description of the item
     */
    public String getItemDescription() {
        return this.itemDescription;
    }

    /**
     * Returns the menu heading of this item.
     *
     * @return the menu heading of the item
     */
    public String getMenuHeading() {
        return this.menuHeading;
    }

    /**
     * Returns the price of this item.
     *
     * @return the price of the item
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * Returns the station of this item.
     *
     * @return the station of the item
     */
    public String getStation() {
        return this.station;
    }

    /**
     * Returns a string of the item's information
     * @return the entire Item to a String
     */

    public String toString () {
        return "Item [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + "]";
    }
}