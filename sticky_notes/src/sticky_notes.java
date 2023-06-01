import java.util.ArrayList;
//aaaaaaaaaaaaaaaaaaahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
class sticky_notes {
    public static void main(String args) {
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahhhhhhhhhhhhhhhhhhhhhhhh
        //call retrieve notes from data management
        ArrayList<Notes> priorSessionNotes = retrieveNotes();
        //instantiate a master notes panel
        StickyNotes root = StickyNotes();
        //instansiate a note window for each of the notes that was retrieved
        if (priorSessionNotes != null) {
            for (Notes i : priorSessionNotes) {
                root.instantiateNote(i);
            }
        }
    }
}