package pos;

public class OrderNumerator {
    
    //generates a linear value for table numbers starting at 100
    private static Integer count = 100;

    //generates a linear value for table numbers starting at 400
    private static Integer ticketCount = 400;


    public  static Integer numberAnOrder(){
        count ++;
        return count;

    }

    public  static Integer numberTicket(){
        ticketCount ++;
        return count;

    }
}
