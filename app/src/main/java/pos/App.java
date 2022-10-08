package pos;
import java.util.ArrayList;
import java.util.HashMap;

public class App{
    public static void main(String[] args) {
        
        ItemDatabase.initialize("/mnt/c/Code/java/pprojects/POS/data/preloaded_items.csv");
        // String id = "000001";
        // System.out.println(ItemDatabase.containsID(id));
        // System.out.println(ItemDatabase.getItemName(id));
        // System.out.println(ItemDatabase.getItemDescription(id));

        // System.out.println("**************************");

        // String id2 = "000002";
        // System.out.println(ItemDatabase.containsID(id2));
        // System.out.println(ItemDatabase.getItemName(id2));
        // System.out.println(ItemDatabase.getItemDescription(id2));

        // System.out.println("**************************");

        // String id3 = "300003";
        // System.out.println(ItemDatabase.containsID(id3));
        // System.out.println(ItemDatabase.getItemName(id3));
        // System.out.println(ItemDatabase.getItemDescription(id3));
        // System.out.println(ItemDatabase.getMenuHeading(id3));
        // System.out.println(ItemDatabase.getPrice(id3));


        
        //testing order calculation/add item/remove item
        ArrayList<String> seatOne = new ArrayList<String>();
        ArrayList<String> seatTwo = new ArrayList<String>();
        ArrayList<String> seatThree= new ArrayList<String>();
       //add items
        seatOne.add("100001");
        seatOne.add("200002");
        seatTwo.add("200002");
        seatTwo.add("400004");
        seatThree.add("300003");
        seatThree.add("300003");
        seatThree.add("400004");
        seatThree.add("100001");

        //make order
        HashMap<String,ArrayList<String>> orderMap = new  HashMap<String,ArrayList<String>>();
        orderMap.put("1",seatOne);
        orderMap.put("2",seatTwo);
        orderMap.put("3",seatThree);

        //assign a table
        int tableNumber = 50;
        
        //create and order object
        Order firstOrder = new Order(orderMap, 50);

        //peek at the order
        System.out.println(firstOrder.getOrderAndSeatPos());
        
        //get the total price before tax and grat
        System.out.println(firstOrder.getOrderTotalPrice());

        //add item to order
        firstOrder.addItemToOrder("2", "400004");
        firstOrder.addItemToOrder("2", "300003");

        //sanity check
        //peek at the order
        System.out.println(firstOrder.getOrderAndSeatPos());
        
        //get the total price before tax and grat
        System.out.println(firstOrder.getOrderTotalPrice());


        System.out.println("exit code 0");

        //need to test Order Queue setup 
        
    }
}