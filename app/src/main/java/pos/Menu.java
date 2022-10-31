package pos;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private String menuId;
    private String name;

    private String dayPart;

    private HashMap<String, ArrayList<String>> sections;

    public Menu(String name, String dayPart){
        this.name = name;
        this.dayPart = dayPart;
        this.menuId = OrderNumerator.numberMenu();
    }

    public String getMenuId(){
        return this.menuId;
    }

    public String getName(String menuId){
        return this.name;
    }

    public String getDayPart(String menuId){
        return this.dayPart;
    }

    public HashMap<String, ArrayList<String>> getSections(String menuId){

        HashMap<String, ArrayList<String>> copyMap = new HashMap<String, ArrayList<String>>();

        for(String section: sections.keySet()){
            ArrayList<String> ids = new ArrayList<String>(sections.get(section));
            copyMap.put(section, ids);
        }
        return copyMap;
    }

    public void populateMenu(final HashMap<String, ArrayList<String>> sectionsAndIds){
        for(String section: sectionsAndIds.keySet()){
            ArrayList<String> ids = new ArrayList<>(sectionsAndIds.get(section));
            this.sections.put(section, ids);
        }
    }

}
