package pos.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The Table class represents a physical table or digital table and ties together Orders and Ticket objects.
 * Each table has a number, owner, timestamp of when opened and another when closed. Each Table has a list of Order
 * and Ticket objects as well as serves as a tracking object for available space and time of experience.
 */
public class Table {

    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Ticket> tickets= new ArrayList<>();
    private int tableNumber;
    private String tableOwner;
    private LocalDateTime tableOpened;
    private LocalDateTime tableClosed;

    /**
     * The Table constructor enforces only a tableNumber and tableOwner to be passed to "Open" a table. The Table is
     * automatically timestamped at generation of the object.
     * @param tableNumber
     * @param tableOwner
     */
    public Table(int tableNumber, String tableOwner){
        this.tableNumber = tableNumber;
        this.tableOwner = tableOwner;
        this.tableOpened = LocalDateTime.now();

    }

    /**
     * Getter for tableNumber
     * @return int of the tables number
     */
    public int getTableNumber(){
        return this.tableNumber;
    }

    /**
     * Getter for tableOwner
     * @return String of tableOwner
     */
    public String getTableOwner(){
        return this.tableOwner;
    }

    /**
     * Getter for when the table was opened.
     * @return String representation of the time when opened.
     */
    public String getTableOpened(){
        //returns formatted datetime obj
        DateTimeFormatter formatOrderEntryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:nn");
        String formattedDate = tableOpened.format(formatOrderEntryTime);
        return formattedDate;
    }

    /**
     * Getter for the time the table was closed.
     * @return  String representation of the time the table was closed
     */
    public String getTableClosed(){
        //returns formatted datetime obj
        DateTimeFormatter formatOrderEntryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:nn");
        String formattedDate = tableClosed.format(formatOrderEntryTime);
        return formattedDate;
    }

    /**
     * Method to return an ArrayList of all open orders associated with the Table object and are OPEN.
     * @return  ArrayList<Integer> of Order object orderNumbers
     */
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

    /**
     * Method to return all the closed orders that exist within the class.
     * @return ArrayList<Integer> of the closed Order numbers
     */
    public ArrayList<Integer> getClosedOrders(){
        //returns all closed orders on table
        ArrayList<Integer> closedOrders = new ArrayList<Integer>();
        for(Order order: this.orders){
            if(order.getOrderStatus().equals("CLOSED")){
                closedOrders.add(order.getOrderNumber());
            }
        }
        return closedOrders;
    }

    /**
     * Method to return an ArrayList of all open ticket numbers associated with the Table object and are OPEN.
     * @return  ArrayList<Integer> of Ticket object ticketNumbers
     */
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

    /**
     * Method to return all the closed ticketNumbers that exist within the class.
     * @return ArrayList<Integer> of the closed ticketNumbers
     */
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

    /**
     * Method to set the timestamp of the ticketClosed to the current time.
     */
    public void setTableClosed(){
        this.tableClosed = LocalDateTime.now();
    }

    /**
     * Method to add an Order object to the list within Table of Orders.
     * @param order Order
     */
    public void addOrderToTable(Order order){
        this.orders.add(order);
    }

    /**
     * Method to add a Ticket object to the list within the Table of Tickets.
     * @param ticket Ticket
     */
    public void addTicketToTable(Ticket ticket){
        this.tickets.add(ticket);
    }

    /**
     * Method to remove Order object from Tables list of Orders.
     * @param order Order
     */
    public void removeOrderFromTable(Order order){
        this.orders.remove(order);
    }

    /**
     * Method to remove Ticket object from the Table list of Tickets.
     * @param ticket Ticket
     */
    public void removeTicketFromTable(Ticket ticket){
        this.tickets.remove(ticket);

    }
}
