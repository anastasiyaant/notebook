import java.util.Date;

public class Notebook {
   private Note[] notes;
   private static final int SIZE=10;
   private int notebookSize;
   private int expandSize;
   private int notesCount;

   public Notebook() {
       notebookSize = SIZE;
       notes = new Note[notebookSize];
       notesCount=0;
       expandSize = SIZE;
   }

   public void addNote(Date date, String header, String text) {
       if (notesCount+1>=notebookSize) {
           expandNotebook();
       }
       notes[notesCount] = new Note(date!=null ? date : new Date(), header, text);
       notesCount++;
   }

   public void deleteNote(int noteNum) {
       if (noteNum<=notesCount&&noteNum>0) {
           noteNum--;
           for (int i = noteNum; i < notesCount - 1; i++) {
               notes[i] = notes[i + 1];
           }
           notesCount--;
           notes[notesCount]=null;
           if (notebookSize - notesCount > (expandSize+(expandSize/2))) {
               reduceNotebook();
           }
       }
       else {
           System.out.printf("Unable to delete! Note with number %d doesn't exist!\n", noteNum);
       }
   }

   public void editNote(int noteNum, String header, String text, Date date) {
       if (noteNum<=notesCount&&noteNum>0) {
           if (date != null) {
               notes[noteNum - 1].setDate(date);
           }
           notes[noteNum - 1].setHeader(header);
           notes[noteNum - 1].setText(text);
       }
       else {
           System.out.printf("Unable to edit! Note with number %d doesn't exist!\n", noteNum);
       }
   }
    public void editNote(int noteNum, String header, String text) {
        if (noteNum<=notesCount&&noteNum>0) {
            notes[noteNum - 1].setHeader(header);
            notes[noteNum - 1].setText(text);
        }
        else {
            System.out.printf("Unable to edit! Note with number %d doesn't exist!\n", noteNum);
        }
    }

    public void editNote(int noteNum, String header) {
        if (noteNum<=notesCount&&noteNum>0) {
            notes[noteNum - 1].setHeader(header);
        }
        else {
            System.out.printf("Unable to edit! Note with number %d doesn't exist!\n", noteNum);
        }
    }


   public void showNotebook() {
       if (notesCount==0) {
           System.out.println("Notebook is empty:(\n");
       }else {
           for (int i = 0; i < notesCount; i++) {
               System.out.println(i + 1);
               System.out.println(notes[i].getDate());
               System.out.println(notes[i].getHeader());
               System.out.println(notes[i].getText());
               System.out.println();
           }
       }
   }

   private void  expandNotebook() {
       Note[] newNotebook= new Note[notebookSize+expandSize];
       cloneNotebook(newNotebook);
       notebookSize+=expandSize;
   }

    private void  reduceNotebook() {
        Note[] newNotebook= new Note[notebookSize-expandSize];
        cloneNotebook(newNotebook);
        notebookSize-=expandSize;
    }

    private void cloneNotebook(Note[] newNotebook){
       for (int i=0; i<notesCount; i++) {
           newNotebook[i]=notes[i];
       }
       notes=newNotebook;
    }

}
