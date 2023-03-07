//this file will contain the class and methods for storing the notes
import java.util.ArrayList;

enum Type {
    BASIC,
    LIST,
    EVENT
}

public class note {
    Type note_type;
    String title;
    String desc;
    public String collapse_note() {
        //turns note into a single string for storage in a file
    }
}

public note instantiate_note(String note_text) {
    //turns string from text back into a note for runtime sotrage
}

public ArrayList<note> notes_from_file(String fileName) {

}