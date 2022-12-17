package pos.models;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.commons.math3.util.Precision;
import pos.databaseutilities.ItemDatabase;
import pos.helpermethods.OrderNumerator;


public class Order {

    //hashmap is string seatNum and ArrayList of item ids for order
    private HashMap<String, ArrayList<String>> orderMap; 
    
    //an unchangeable time/date object
    private final LocalDateTime orderEntryTime;

    //an ordernumber that self generates on entry

    private final Integer orderNumber;

    //where it goes
    private final int tableNumber;

    //running total
    private double orderTotalPrice;

    //who owns the order?
    private final String orderOwner;

    //live or dead?
    private String orderStatus = "OPEN";  // "CLOSED"

    public Order(HashMap<String, ArrayList<String>> orderMap, String orderOwner, int tableNumber){

        this.orderMap = orderMap;
        this.tableNumber = tableNumber;
        this.orderTotalPrice = calculateOrderPriceTotal();
        this.orderEntryTime = LocalDateTime.now();
        this.orderOwner = orderOwner;
        this.orderNumber = OrderNumerator.numberAnOrder();
    }

    public int getOrderNumber(){
        //returns order number and number indicates
        return this.orderNumber;
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

            ArrayList<String> currOrders = orderMap.get(seatNum);
            
            currOrders.add(itemId);

            orderMap.put(seatNum, currOrders);

            orderTotalPrice = calculateOrderPriceTotal();
        }
        else{

            ArrayList<String> currOrders = new ArrayList<String>();
            currOrders.add(itemId);
            orderMap.put(seatNum, currOrders);
            orderTotalPrice = calculateOrderPriceTotal();
        }
    }

    public String removeSeatFromOrder(String seatNum){
        if(orderMap.containsKey(seatNum)){
            orderMap.remove("seatNum");
            System.out.println(this.orderMap);
            return "Seat Position " + seatNum + " has been removed.";
        }
        else{
            return "Seat position " + seatNum + " does not exist";
        }
    }

    public String removeItemFromOrder(String seatNum, String id){

        //removes an item by seatpos and id
        if(orderMap.containsKey(seatNum)){
            //needs a try catch block here
            orderMap.get(seatNum).remove(String.valueOf(id));
            orderTotalPrice =calculateOrderPriceTotal();
            return "Successfully remove" + id + " from seat position " + seatNum;
        }
        else{
            return "Seat position " + seatNum + " does not exist or does not contain" + id;
        }
    }

     //send the order out to stations

    public String getOrderEntryTime(){
        //returns formatted datetime obj
        DateTimeFormatter formatOrderEntryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:nn");
        return orderEntryTime.format(formatOrderEntryTime);
    }

    public String getOrderOwner(){
        //returns the server or orderoriginator
        return this.orderOwner;
    }

    public String getOrderStatus(){
       //OPEN or CLOSED
        return this.orderStatus;
        
    }

    public String setOrderStatus(boolean statuscode){
        //Sets open or closed for order
        if(!statuscode){
            return this.orderStatus = "CLOSED";
        }
        return "OPEN";
    }

    public HashMap<String, ArrayList<String>> getOrderAndSeatPos(){

        return this.orderMap;
    }
    
}
