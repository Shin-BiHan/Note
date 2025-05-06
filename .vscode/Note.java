import java.util.*;
    

public class Note {
    private Order order;
    private String subject;
    private String noteEntry;
    private static List<Note> noteList = new ArrayList<>();


    public Note(String subject, Order order) {
        this.order = order;
        this.subject = subject;

    }

    public void entry() {
        Scanner input = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("Done")) {
                break;
            }

            stringBuilder.append(line).append("\n");
        }
        noteEntry = stringBuilder.toString();

    }

    public String print() {
        return noteEntry;
    }

    public String getDate() {
        return order.date();
    }

    public String getTitle() {
        return order.title();
    }

    public String getSubject() {
        return subject;
    }

    public Order getOrder() {
        return order;
    }

    public static void main(String[] args) {
        NoteManager manager = new NoteManager();
        Note note = new Note("intro to hashcode", new Order("Data Structures", "05/05/2025"));
        note.entry();

        manager.addNote(note.getSubject(), note);
        manager.printNotes();


    }
}