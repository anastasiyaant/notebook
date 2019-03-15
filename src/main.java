import java.util.Date;

public class main {
    public static void main (String args []) {
        Notebook myNotebook = new Notebook();
        myNotebook.showNotebook();
        myNotebook.addNote(new Date(), "Header1", "Hello, my friend!");
        myNotebook.showNotebook();
        myNotebook.deleteNote(1);
        myNotebook.showNotebook();
        myNotebook.addNote(new Date(), "Header1", "Hello, my friend!");
        myNotebook.addNote(new Date(), "Header2", "Ha-ha-ha!");
        myNotebook.addNote(new Date(), "Header3", "Good morning, my diary!");
        myNotebook.addNote(null, "Header4", "GM:)");
        myNotebook.addNote(null, "Header5", "Sunny:)");
        myNotebook.addNote(null, "Header6", "Happy:)");
        myNotebook.showNotebook();
        myNotebook.deleteNote(3);
        //nonexistent note
        myNotebook.deleteNote(131);
        myNotebook.showNotebook();
        for (int notes=0; notes<15; notes++) {
            myNotebook.addNote(null, "Header7", "GM:)");
        }

        for (int notes=0; notes<15; notes++) {
            myNotebook.deleteNote(3);
        }
        myNotebook.editNote(1, "Header", "Open your eyes ^_^ ", null);
        myNotebook.editNote(2, "Header222", "Close your eyes ^_^ ");
        myNotebook.editNote(3, "Headerrrrrrrr");
        //nonexistent notes
        myNotebook.editNote(100, "Header", "Open your eyes ^_^ ", null);
        myNotebook.editNote(200, "Header222", "Close your eyes ^_^ ");
        myNotebook.editNote(300, "Headerrrrrrrr");
        myNotebook.showNotebook();
    }
}
