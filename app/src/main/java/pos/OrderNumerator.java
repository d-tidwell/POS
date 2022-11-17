package pos;

public class OrderNumerator {
    /**
     * OrderNumerator is a class with static methods to number instances of various classes such as
     * orders, tickets and menus.
     */
    //generates a linear value for table numbers starting at 100
    private static Integer count = 100;

    //generates a linear value for table numbers starting at 400
    private static Integer ticketCount = 400;

    private static Integer menuCount = 10000;

    /**
     * Method to assign a number to Order object instances.
     * @return Integer count starting at 100.
     */
    public  static Integer numberAnOrder(){
        count ++;
        return count;

    }

    /**
     * Method to number Ticket object instances starting at 400.
     * @return Integer count starting from 400
     */
    public  static Integer numberTicket(){
        ticketCount ++;
        return count;

    }

    /**
     * Method to number Menu object instances prefaced with "M" and starting at 10000
     * @return String "M" + number of Menu
     */
    public  static String numberMenu(){
        menuCount ++;
        return "M" + String.valueOf(count);

    }
}
