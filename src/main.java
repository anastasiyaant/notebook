import java.util.Date;

public class main {
    public static void main (String args []) {

        //System.out.println ("Start");
        Notebook myNotebook = new Notebook();
        myNotebook.showNotebook();
        myNotebook.addNote(new Date(), "Header1", "Hello, my friend!");
        myNotebook.addNote(new Date(), "Header2", "Ha-ha-ha!");
        myNotebook.addNote(new Date(), "Header3", "Good morning, my diary!");
        myNotebook.addNote(null, "Header4", "GM:)");
        myNotebook.addNote(null, "Header5", "Sunny:)");
        myNotebook.addNote(null, "Header6", "Happy:)");
        myNotebook.showNotebook();
        myNotebook.delNote(3);
        myNotebook.showNotebook();
        int notes=15;
        while (notes>0)
        {
            myNotebook.addNote(null, "Header7", "GM:)");
            notes--;
        }
        notes=10;
        while (notes>0)
        {
            myNotebook.delNote(3);
            notes--;
        }
        myNotebook.editNote(1, "Header", "Open your eyes ^_^ ", null);
        myNotebook.showNotebook();

    }
}
