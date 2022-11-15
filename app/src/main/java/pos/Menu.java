package pos;

import java.util.ArrayList;
import java.util.HashMap;



public class Menu {


    /** Menu is a clas that consists of a HashMap of Menu Items indexed by sections and item id
     * The class consists of a name, autogenerated menuID, daypart, active status, and Hashmap of (k:section,
     * value:itemID).
     * This class is used to generate the front end icons for the POS as well as store Menus for historical purposes.
     * @author Darek Tidwell
     */

    private final String menuId;
    private String name;
    private String dayPart;

    private String menuStatus; //yes/no
    private HashMap<String, ArrayList<String>> sections;

    /**
     * Constructs a minimal Menu Object. menuID is autogenerated.
     * @param name - name of menu, can be changed with setter
     * @param dayPart - breakfast, lunch, dinner etc
     * @param active - is this menu active or hidden from POS
     */

    public Menu(String name, String dayPart, String active){
        this.name = name;
        this.dayPart = dayPart;
        this.menuStatus = active;
        this.menuId = OrderNumerator.numberMenu();
    }

    /**
     * Get MenuId supplies the autogenerated id assigned at obj creation.
     * Not modifiable. Preceeded by "M".
     * @return   String id assigned at obj creation
     */
    public String getMenuId(){
        return this.menuId;
    }

    /**
     * Method to return the name of the menu passed at generation of obj. Setter available.
     * @return  String name
     */

    public String getName(){
        return this.name;
    }

    /**
     * Returns daypart of menu created at generation of obj.
     * @return   String dayPart
     */

    public String getDayPart(){
        return this.dayPart;
    }

    /**
     * Returns the active / not active menuStatus of obj. Settable with other method.
     * @return    String menuStatus
     */
    public String getMenuStatus(){
        return this.menuStatus;
    }

    /**
     * Returns a HashMap copy of the menu sections and itemId's. For front end use or others.
     * @return  HashMap<String, ArrayList<String>> of the menu sections and itemId's
     */

    public HashMap<String, ArrayList<String>> getSections(){

        HashMap<String, ArrayList<String>> copyMap = new HashMap<String, ArrayList<String>>();

        for(String section: sections.keySet()){
            ArrayList<String> ids = new ArrayList<String>(sections.get(section));
            copyMap.put(section, ids);
        }
        return copyMap;
    }

    /**
     * Returns nothing. Populates the sections map of k:menu sections, v:itemIds that live within the menu obj,
     * by defensive copy of the Hashmap passed to the function.
     * @param sectionsAndIds HashMap<String, ArrayList<String>>
     */

    public void populateMenu(final HashMap<String, ArrayList<String>> sectionsAndIds){
        for(String section: sectionsAndIds.keySet()) {
            ArrayList<String> ids = new ArrayList<>(sectionsAndIds.get(section));
            this.sections.put(section, ids);
        }
    }

    /**
     * Method to add a section and corresponding itemIds for that section at one time to the HashMap sections.
     * @param section String section
     * @param itemIds ArrayList<String>
     */

    public void addSection(String section, final ArrayList<String> itemIds){
        ArrayList<String> newList = new ArrayList<>(itemIds);
        this.sections.put(section, newList);

    }

    /**
     * Drops a section and all the itemId's stored in that section HashMap
     * @param section String key identifyer of the section in the HashMap
     */
    public void removeSection(String section){
        this.sections.remove(section);
    }

    /**
     * Method to add or remove itemId's from the sections HashMap in one method at the same time. Changes are made by
     * retrieving the section values and editing via the addAll or removeAll collections method.
     * @param section  String name of the key of the section
     * @param addItems  ArrayList<String> List of Items to add
     * @param removeItems    ArrayList<String> List of Items to remove
     */

    public void editSection(String section, final ArrayList<String> addItems, final ArrayList<String> removeItems){
        //defensive copies
        ArrayList<String> newAdds = new ArrayList<String>(addItems);
        ArrayList<String> newRemove = new ArrayList<String>(removeItems);

        ArrayList<String> old = this.sections.get(section);
        old.addAll(newAdds);
        old.removeAll(newRemove);
        this.sections.put(section, old);

    }

    /**
     * Setter method for menuStatus
     * @param status String "yes" or "no"
     */

    public void setMenuStatus(String status){
        this.menuStatus = status;
    }

    /**
     * Setter method for menuName.
     * @param newName String newName
     */

    public void setMenuName(String newName){
        this.name = newName;
    }

    /**
     * Setter method to change dayPart.
     * @param newDayPart String new dayPart
     */

    public void setDayPart(String newDayPart){
        this.dayPart = newDayPart;
    }
}
