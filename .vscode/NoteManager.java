import java.util.List;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class NoteManager {
      private LinkedHashMap<String, List<Note>> notesBySubject = new LinkedHashMap<>();

      public NoteManager(){}

      public void addNote(String subject, Note note){
        notesBySubject.putIfAbsent(subject, new ArrayList<>());
        notesBySubject.get(subject).add(note);
      }
      public List<Note> searchByDate(String date){
        List<Note> results = new ArrayList<>();
        for(List<Note> list : notesBySubject.values()){
          for(Note note : list){
            if(note.getDate().equals(date)){
              results.add(note);
            }
          }

  
       }  
       return results; 
   }
   public List<Note> searchByTitle(String title){
    List<Note> results = new ArrayList<>();
    for(List<Note> list : notesBySubject.values()){
      for(Note note : list){
        if(note.getTitle().equals(title)){
          results.add(note);
        }
      }


    }  
   return results; 
  }
  public void printNotes(){
    for(String subject : notesBySubject.keySet()){
      System.out.println("Subject: "+ subject);
      for(Note note : notesBySubject.get(subject)){
        System.out.println(note.print());
        System.out.println("........");
      }
    }
  }
}