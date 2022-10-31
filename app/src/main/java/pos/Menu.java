package pos;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private final String menuId;
    private String name;
    private String dayPart;

    private String menuStatus; //yes/no
    private HashMap<String, ArrayList<String>> sections;

    public Menu(String name, String dayPart, String active){
        this.name = name;
        this.dayPart = dayPart;
        this.menuStatus = active;
        this.menuId = OrderNumerator.numberMenu();
    }

    public String getMenuId(){
        return this.menuId;
    }

    public String getName(){
        return this.name;
    }

    public String getDayPart(){
        return this.dayPart;
    }

    public String getMenuStatus(){
        return this.menuStatus;
    }

    public HashMap<String, ArrayList<String>> getSections(){

        HashMap<String, ArrayList<String>> copyMap = new HashMap<String, ArrayList<String>>();

        for(String section: sections.keySet()){
            ArrayList<String> ids = new ArrayList<String>(sections.get(section));
            copyMap.put(section, ids);
        }
        return copyMap;
    }

    public void populateMenu(final HashMap<String, ArrayList<String>> sectionsAndIds){
        for(String section: sectionsAndIds.keySet()) {
            ArrayList<String> ids = new ArrayList<>(sectionsAndIds.get(section));
            this.sections.put(section, ids);
        }
    }

    public void addSection(final String section, ArrayList<String> itemIds){
        ArrayList<String> newList = new ArrayList<>(itemIds);
        this.sections.put(section, newList);

    }

    public void removeSection(String section){
        this.sections.remove(section);
    }

    public void editSection(String section, final ArrayList<String> addItems, final ArrayList<String> removeItems){
        //defensive copies
        ArrayList<String> newAdds = new ArrayList<String>(addItems);
        ArrayList<String> newRemove = new ArrayList<String>(removeItems);

        for(String item: newAdds){
            this.sections.get(section).add(item);
        }
        for(String removeItem: newRemove){
            this.sections.get(section).remove(removeItem);
        }
    }

    public void setMenuStatus(String status){
        this.menuStatus = status;
    }
}
