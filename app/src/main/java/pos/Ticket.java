package pos;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Ticket {

    //SeatPos / Item list
    private HashMap<String, ArrayList<Item>> ticketMap;

    //an unchangeable time/date object
    private final LocalDateTime ticketTime;

    //an ordernumber that self generates on entry
    private final Integer ticketNumber;

    //where it goes
    private int tableNumber;

    //who owns the order?
    private String ticketOwner;

    //live or dead?
    private String ticketStatus = "OPEN";  // "CLOSED"

    public Ticket(HashMap<String, ArrayList<Item>> ticketMap,int tableNumber, String ticketOwner){
        this.ticketMap = ticketMap;
        this.ticketTime = LocalDateTime.now();
        this.ticketNumber = OrderNumerator.numberTicket();
        this.tableNumber = tableNumber;
        this.ticketOwner = ticketOwner;
        
    }

    public int getTicketNumber(){
        //returns ticket number 
        return this.ticketNumber;
    }


    public int getTableNumber(){
        //returns table number and number indicates
        return this.tableNumber;
    }

    public String getTicketTime(){
        //returns formatted datetime obj
        DateTimeFormatter formatOrderEntryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:nn");
        String formattedDate = ticketTime.format(formatOrderEntryTime);
        return formattedDate;
    }

    public String getTicketOwner(){
        //returns the server or orderoriginator
        return this.ticketOwner;
    }

    public String getTicketStatus(){
       //OPEN or CLOSED
        return this.ticketStatus;
        
    }

    public String setTicketStatus(boolean statuscode){
        //Sets open or closed for order
        if(statuscode == false){
            return this.ticketStatus = "CLOSED";
        }
        return "OPEN";
    }

    public HashMap<String, HashMap<String, Integer>> consolidateTicket(){
        //makes a consolidated order for each station in stations for easier viewing of ticket in stations
        // Station: Item: Count
        // {"GRILL": "100001": 3}
        HashMap<String, HashMap<String, Integer>> consolidated = new  HashMap<String, HashMap<String, Integer>>();

        //for seatPos in map
        for(String seatPos: this.ticketMap.keySet()){

            //for item in array of items
            for(int i = 0; i < this.ticketMap.get(seatPos).size(); i++){

                //get the station of the item
                String station = this.ticketMap.get(seatPos).get(i).getStation();

                //get the item object
                Item item = this.ticketMap.get(seatPos).get(i);
                

                //if the station does not exist initialize it to zero
                if(!consolidated.containsKey(station)){
                    //create an item hash map of items and values for redundancy of items
                    HashMap<String, Integer> itemCount = new HashMap<String, Integer>();
                    itemCount.put(item.getID(), 1);
                    consolidated.put(station, itemCount);
                    
                }
                else{
                    //otherwise get the station the item and add one to the count
                    HashMap<String, Integer> stationMap = consolidated.get(station);
                    stationMap.put(item.getID(), stationMap.get(item.getID()) + 1);
                    consolidated.put(station,stationMap);
                    
                }

            }
        }

        return consolidated;


    }

}
