package pos;

public class OrderNumerator {
    
    //generates a linear value for table numbers starting at 100
    private static Integer count = 100;

    public  static Integer numberAnOrder(){
        count ++;
        return count;

    }
}
