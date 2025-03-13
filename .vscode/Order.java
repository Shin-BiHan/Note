import java.io.*;
import java.util.*;
public record Order(String subject, String date){
    
    }
// the note class basically take notes and it also accosiates its selve with the order record
class Note {
    private Order order;
    private String noteEntry = "";
    // an arraylist that saves the note from the note entry
    private static List<Note> noteList = new ArrayList<>();

    // this method is create to match a note with a specific date and subject
    public Note(Order order){
        this.order = order;
    }

    //

    // Entry scans the input or note of the user and stops only when "Done" is printed in a new line
    // it also saves the note to the private instance variable "noteEntry"
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
        noteList.add(this);
        input.close();
    }
    public String Print(){
        return noteEntry;
    }
    // a stat
    public static void saveNote(String fileName){
        try(BufferedWriter read = new BufferedWriter(new FileWriter(fileName))){
            for(Note note: noteList){
                read.write("Subject: "+ note.order.subject()+"\n");
                read.write("date : "+ note.order.date()+"\n");
                read.write("Note: \n"+ note.noteEntry+  "\n");

            }



        } catch(IOException e){
            System.out.println("Error while saving the notes");
        }
    }


    public static void main( String [] args){
        Scanner scan = new Scanner(System.in);
        boolean willContinue  = true;
        // I did a while loop that would continue. only if they answer yes to adding more notes
        while(willContinue){
            System.out.println("Enter Subject:");
            String subject = scan.next();
            System.out.println("Enter Date: (mm-dd-year) or (mm/dd/year)");
            String date = scan.next();
            Order org = new Order(subject, date);
            Note noteOne = new Note(org);

            noteOne.Entry();
            System.out.println("Do you want to add another  note? Yes/NO?");
            String answer = scan.next();
            if(answer.equals("No") || answer.equals("NO")){
                willContinue = false;
            }
            else{
                willContinue =  true;
            }


            }


        }

    }