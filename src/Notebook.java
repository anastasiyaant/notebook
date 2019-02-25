import java.util.Date;

public class Notebook {
   private Note[] notes;
   private int notebook_size = 10;
   private int expand_size = 10;
   private int notes_count;

   public Notebook()
   {
       notes = new Note[notebook_size];
       notes_count=0;
   }

   public void addNote(Date date, String header, String text)
   {
       //System.out.println("Adding");
       if (notes_count+1>=notebook_size)
       {
           expandNotebook();
       }

       if (date!=null) {
           notes[notes_count] = new Note(date, header, text);
       } else
       {
           notes[notes_count] = new Note(new Date(), header, text);
       }
       notes_count++;
   }

   public void delNote(int note_num)
   {
       if ((note_num<=notes_count)&&(note_num>0)) {
           note_num--;
           for (int i = note_num; i < notes_count - 1; i++) {
               notes[i] = notes[i + 1];
           }
           notes[notes_count - 1]=null;
           notes_count--;
           if (notebook_size - notes_count > (expand_size+(expand_size/2))) {
               reduceNotebook();
           }
       }
   }

   public void editNote(int note_num, String header, String text, Date date)
   {
       if ((note_num<=notes_count)&&(note_num>0))
       {
           if (date != null) {
               notes[note_num - 1].setDate(date);
           }
           notes[note_num - 1].setHeader(header);
           notes[note_num - 1].setText(text);
       }
   }

   public void showNotebook()
   {
       if (notes_count==0)
       {
           System.out.println("Notebook is empty:(");
       }else {
           for (int i = 0; i < notes_count; i++) {
               System.out.println(i + 1);
               System.out.println(notes[i].showDate());
               System.out.println(notes[i].showHeader());
               System.out.println(notes[i].showText());
               System.out.println();
           }
       }
   }

   private void  expandNotebook()
   {
       //System.out.println("Expanding...");
       Note[] newNotebook= new Note[notebook_size+expand_size];
       for (int i=0; i<notes_count; i++)
       {
           newNotebook[i]=notes[i];
       }
       notes=newNotebook;
       notebook_size+=expand_size;
   }

    private void  reduceNotebook()
    {
        //System.out.println("Reducing..");
        Note[] newNotebook= new Note[notebook_size-expand_size];
        for (int i=0; i<notes_count; i++)
        {
            newNotebook[i]=notes[i];
        }
        notes=newNotebook;
        notebook_size-=expand_size;
    }






}
