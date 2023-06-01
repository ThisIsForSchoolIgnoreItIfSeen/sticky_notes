//allows other files to access class
package sticky_notes;

//this file will contain the class and methods for storing the notes at runtime
import java.util.ArrayList;

/* Removing functionality of multiple types of notes to fit project in time schedule
enum Type {
    BASIC,
    LIST,
    EVENT
}*/

public class Notes {
    //this is the main class that will be used for runtime storage of notes, feel free to add methods that you think would be useful
    String title;
    String content;

    Notes() {
        title = "Type Something";
        content  = "type something";
    }
}