//allows access to other files
/*
code in this file is to aid in long term storage of user-taken notes
needs the ability to store notes taken in files and retrieve them
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class data_management {
  public void storeInFiles(ArrayList<Notes> notes) {
    //this function should go through each notes in the notes arraylist and put them into a different
    // file in the storedNotes folder
    //suggestion: name the files note1.txt, note2.txt... so that when we are retrieving existing
    // notes we just have to iterate the number to get to the next one
    //suggestion: put the title of the note in the first line of the file and then append the rest of note after that
    //function should override files currently in storedNotes
    //for reference this funciton will be run at the end of each session
    return;
  }

  public ArrayList<Notes> retrieveNotes() {
    //function should go through files in storedNotes directory and turn each text file into a note,
    // should be able to pull out the title of the note and differentiate it from the rest of the content
    //function also needs to be able to tell when it has taken all the notes and there are no more
    //this funciton will be ran whenever an instance of sticky notes is started
    return null;
  }
}