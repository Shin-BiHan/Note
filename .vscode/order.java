import java.util.*;
public record order(String subject, String date){
    public order{
         System.out.println("Subject: "+ subject + " Date: " + date);
    }
}
public class Note {
    private Order order;
    public note(Order order){
        this.order = order;
    }
    public void add(){
        Entry();
    }
    public void Entry(){
        Scanner input = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while(input.hasNextLine()){
            String line = input.nextLine();
            if(line.equals("Done")){
                break;
            }
    
            stringBuilder.append(line).append("\n");
        }
        input.close();
    }
    public static void main( String [] args){
        order one = new order("Data Structures","03/12/2025");
        note pr = new note(one);

        pr.entry();


    
    }
}
