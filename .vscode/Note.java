import java.util.*;
public record order(String subject, String date){
    public Order{
         System.out.println("Subject: "+ subject + " Date: " + date);
    }
}
public class Note {
    private Order one;
    public Note(Order one){
        this.order = one;
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
        noteEntry = stringBuilder.toString();
       
    }
    public String Print(){
        return noteEntry;
    }
    public static void main( String [] args){
        Order one = new Order("Data Structures","03/12/2025");
        Note pr = new Note(one);

        pr.Entry();


    
    }
}
