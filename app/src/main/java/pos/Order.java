package pos;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.math3.util.*;


public class Order {

    //hashmap is string seatNum and ArrayList of item ids for order
    private HashMap<String, ArrayList<String>> orderMap;
    
    //needs a time/date object
    
    private int tableNumber;

    private double orderTotalPrice;

    public Order(HashMap<String, ArrayList<String>> orderMap, int tableNumber){

        this.orderMap = orderMap;
        this.tableNumber = tableNumber;
        this.orderTotalPrice = calculateOrderPriceTotal();
    }

    public int gettableNumber(){
        //returns table number and number indicates
        return this.tableNumber;
    }

    public double getOrderTotalPrice(){
        // returns orders running total price
        calculateOrderPriceTotal();
        return orderTotalPrice;
    }

    public String gettableType(){
        //returns tableType "delivery" "takeOut", "dineIn"
        if (gettableNumber() > 100){
            return "delivery";
        }
        else if(gettableNumber() > 500){
            return "takeOut";
        }
        else{
            return "dineIn";
        }
        
    }


    public double calculateOrderPriceTotal(){
        //takes the map of seat to get id's and returns a total price 
        double total = 0;

        //for seat in keys
        for(String seat: orderMap.keySet()){

            //for itemId in seatpos
            for(String itemId: orderMap.get(seat)){

                //parse the double value of the price based on id
                total += Double.parseDouble(ItemDatabase.getPrice(itemId));
            }
        }
        return Precision.round(total, 2);
    }

    public void addItemToOrder(String seatNum, String itemId){
        
        //add a single item to the order by seat pos
        if(orderMap.containsKey(seatNum)){
            // System.out.println("Before Add map " + this.orderMap );
            // System.out.println("Item to Add: " + itemId);
            // System.out.println("Seat to Add to: " + seatNum);
            ArrayList<String> currOrders = orderMap.get(seatNum);
            // System.out.println("Seat Number Items: " + orderMap.get(seatNum));
            
            currOrders.add(itemId);
            // System.out.println("After addition: " + currOrders);
            orderMap.put(seatNum, currOrders);
            // System.out.println("After Add map " + this.orderMap );
            orderTotalPrice = calculateOrderPriceTotal();
        }
        else{
            // System.out.println("Hit else statement additemtoorder");
            ArrayList<String> currOrders = new ArrayList<String>();
            currOrders.add(itemId);
            orderMap.put(seatNum, currOrders);
            orderTotalPrice = calculateOrderPriceTotal();
        }
    }

    // **PROBLEM java.util.ConcurrentModificationException ** ?do I need this 10-7-2022
    // public void addItemListToOrder(String seatNum, ArrayList<String> items){

    //    //add a list of items by seat pos
    //    if(orderMap.containsKey(seatNum)){
    //     ArrayList<String> currOrders = orderMap.get(seatNum);
    //         for(String item: items){
    //             currOrders.add(item);
    //         }
    //         orderMap.put(seatNum, currOrders);
    //     }
    //     else{
    //         ArrayList<String> currOrders = new ArrayList<String>();
    //         for(String item: items){
    //             currOrders.add(item);
    //         }
    //         orderMap.put(seatNum, currOrders);
    //     }
    // }

    public String removeItemFromOrder(String seatNum, String id){

        //removes an item by seatpos and id
        if(orderMap.containsKey(seatNum)){
            //needs a try catch block here
            orderMap.get(seatNum).remove(String.valueOf(id));
            orderTotalPrice =calculateOrderPriceTotal();
            return "Succesfully remove" + id + " from seat position " + seatNum;
        }
        else{
            return "Seat position " + seatNum + " does not exist or does not contain" + id;
        }
    }

     //send the order out to stations

    public HashMap<String, ArrayList<String>> getOrderAndSeatPos(){

        return this.orderMap;
    }
    
}
