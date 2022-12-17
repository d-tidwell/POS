package pos.databaseutilities;
import pos.models.Item;

import java.util.HashMap;
import java.util.ArrayList;



public class ItemDatabase{
    /**
     * ItemDatabase acts as a local class to store .csv records for retrieval in a hashmap
     */
    private static HashMap<String, Item> ItemMap;

//    public static void initialize(String itemfile){
//        if(ItemMap == null){
//            ItemMap = new HashMap<String, Item>();
//            loadItems(itemfile);
//        }
//    }

    /**
     * initialize() is a public static method that creates a new HashMap<String, Item>() then calls loadItems
     * to populate it with the hardcoded preloaded_items.csv minimal dataframe.
     */
    public static void initialize() {
        if (ItemMap == null) {
            ItemMap = new HashMap<String, Item>();
            loadItems("preloaded_items.csv");
        }
    }

    /**
     * loadItems is a private static method that takes a filename and populates HashMap<String, Item>() with ID,Item
     * @param filename passed in from initialize
     */
    private static void loadItems(String filename) {
        ItemParser fr = new ItemParser();
        ArrayList<Item> list = fr.loadItems(filename);
        for (Item i : list) {
            ItemMap.put(i.getID(), i);
        }
    }

    /**
     * containsID() is a public static boolean method to query the ItemDatabase HashMap
     * @param id ID number of Item
     * @return boolean if contains
     */
    public static boolean containsID(String id) {
        initialize();
        return ItemMap.containsKey(id);
    }

    /**
     * getItemName is a public static method that returns the String itemName
     * @param id ID number of Item
     * @return String Item Name
     */
    public static String getItemName(String id) {
        initialize();
        return ItemMap.get(id).getItemName();
    }
    /**
     * Returns the description of the item with the given ID.
     *
     * @param id the ID of the item
     * @return the description of the item
     */
    public static String getItemDescription(String id) {
        initialize();
        return ItemMap.get(id).getItemDescription();
    }

    /**
     * Returns the menu heading of the item with the given ID.
     *
     * @param id the ID of the item
     * @return the menu heading of the item
     */
    public static String getMenuHeading(String id) {
        initialize();
        return ItemMap.get(id).getMenuHeading();
    }

    /**
     * Returns the price of the item with the given ID.
     *
     * @param id the ID of the item
     * @return the price of the item
     */
    public static String getPrice(String id) {
        initialize();
        return ItemMap.get(id).getPrice();
    }

}