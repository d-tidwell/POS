package pos;
import java.util.HashMap;
import java.util.ArrayList;


public class ItemDatabase{

    private static HashMap<String,Item> ItemMap;

    public static void initialize(String itemfile){
        if(ItemMap == null){
            ItemMap = new HashMap<String, Item>();
            loadItems(itemfile);
        }
    }
    //default items .csv file
    public static void initialize() {
        if (ItemMap == null) {
            ItemMap = new HashMap<String, Item>();
            loadItems("data/preloaded_items.csv");
        }
    }

    private static void loadItems(String filename) {
        ItemParser fr = new ItemParser();
        ArrayList<Item> list = fr.loadItems(filename);
        for (Item i : list) {
            ItemMap.put(i.getID(), i);
        }
    }

    public static boolean containsID(String id) {
        initialize();
        return ItemMap.containsKey(id);
    }


    public static String getItemName(String id) {
        initialize();
        return ItemMap.get(id).getItemName();
    }

    public static String getItemDescription(String id) {
        initialize();
        return ItemMap.get(id).getItemDescription();
    }

    public static String getMenuHeading(String id) {
        initialize();
        return ItemMap.get(id).getMenuHeading();
    }
    public static String getPrice(String id) {
        initialize();
        return ItemMap.get(id).getPrice();
    }

    public static String getStation(String id) {
        initialize();
        return ItemMap.get(id).getStation();
    }

    


}