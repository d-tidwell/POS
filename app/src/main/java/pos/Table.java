package pos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Table {

    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Ticket> tickets= new ArrayList<>();
    private int tableNumber;
    private String tableOwner;
    private LocalDateTime tableOpened;
    private LocalDateTime tableClosed;

    public Table(int tableNumber, String tableOwner){
        this.tableNumber = tableNumber;
        this.tableOwner = tableOwner;
        this.tableOpened = LocalDateTime.now();

    }

    public int getTableNumber(){
        return this.tableNumber;
    }

    public String getTableOwner(){
        return this.tableOwner;
    }
    
    public String getTableOpened(){
        //returns formatted datetime obj
        DateTimeFormatter formatOrderEntryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:nn");
        String formattedDate = tableOpened.format(formatOrderEntryTime);
        return formattedDate;
    }
    

    public String getTableClosed(){
        //returns formatted datetime obj
        DateTimeFormatter formatOrderEntryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:nn");
        String formattedDate = tableClosed.format(formatOrderEntryTime);
        return formattedDate;
    }

    public ArrayList<Integer> getOpenOrders(){
        //returns all open orders on table
        ArrayList<Integer> openOrders = new ArrayList<Integer>();
        for(Order order: this.orders){
            if(order.getOrderStatus().equals("OPEN")){
                openOrders.add(order.getOrderNumber());
            }
        }
        return openOrders;
    }

    public ArrayList<Integer> getClosedOrders(){
        //returns all open orders on table
        ArrayList<Integer> closedOrders = new ArrayList<Integer>();
        for(Order order: this.orders){
            if(order.getOrderStatus().equals("CLOSED")){
                closedOrders.add(order.getOrderNumber());
            }
        }
        return closedOrders;
    }

    public ArrayList<Integer> getOpenTickets(){
        //returns all open orders on table
        ArrayList<Integer> openTickets = new ArrayList<Integer>();
        for(Ticket ticket: this.tickets){
            if(ticket.getTicketStatus().equals("OPEN")){
                openTickets.add(ticket.getTicketNumber());
            }
        }
        return openTickets;
    }

    public ArrayList<Integer> getClosedTickets(){
        //returns all open orders on table
        ArrayList<Integer> closedTickets = new ArrayList<Integer>();
        for(Ticket ticket: this.tickets){
            if(ticket.getTicketStatus().equals("CLOSED")){
                closedTickets.add(ticket.getTicketNumber());
            }
        }
        return closedTickets;
    }
}
