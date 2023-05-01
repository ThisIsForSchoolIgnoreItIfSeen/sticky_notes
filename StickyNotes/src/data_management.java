import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileHelper {
  private File context;

  public FileHelper(File context) {
  this.context = context;
   }

  public void saveToFile(String filename, String fileContents) {
    FileOutputStream outputStream;

    try {
      outputStream = File.openFileOutput(filename, File.MODE_PRIVATE);
      outputStream.write(fileContents.getBytes());
      outputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String readFromFile(String filename) {
    StringBuilder sb = new StringBuilder();

    try {
      FileInputStream inputStream = File.openFileInput(filename);
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line;

      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }

      inputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return sb.toString();
  }
}

class Main {
  public static void main(String[] args) {
     FileHelper fileHelper = new FileHelper(this);
    fileHelper.saveToFile("myfile.txt", "Hello world!");
    String fileContents = fileHelper.readFromFile("myfile.txt");
  }
}