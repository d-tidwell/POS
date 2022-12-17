package pos.databaseutilities;

import java.util.ArrayList;
import org.apache.commons.csv.*;
import pos.helpermethods.FileResource;
import pos.models.Item;


public class ItemParser{

    public ArrayList<Item> loadItems(String filename){
        //returns AL<Item> with all the Item data from .csv
        FileResource fr = new FileResource(filename);
        ArrayList<Item> Items = new ArrayList<Item>();
        for(CSVRecord rec : fr.getCSVParser(true,",")){
           
           String id = rec.get("id");
           String itemName = rec.get("itemName");
           String itemDescription = rec.get("itemDescription");
           String menuHeading = rec.get("menuHeading");
           String price = rec.get("price");

           Item mov = new Item(id,itemName, itemDescription, menuHeading, price);
            //check if its already in the list before adding 
           Items.add(mov);
        }
        
        return Items;
    }

}