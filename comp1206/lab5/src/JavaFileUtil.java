import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.ConcatenateJavaFiles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFileUtil implements ConcatenateJavaFiles {
    @Override
    public void concatenateJavaFiles(String dirName, String fileName) throws IOException {
        /*
        File directory = new File(dirName);
        FileReader inputStream;
        FileWriter outputStream;
        try {
            outputStream = new FileWriter(fileName);
        } catch (Exception e) {
            throw new IllegalArgumentException("Directory does not exist");
        }
        File d = new File(dirName);
        String[] allFileList = d.list();
        ArrayList<String> javaFileArrayList = new ArrayList<String>();
        for (String file : allFileList) {
            if (file.endsWith(".java")) {
                javaFileArrayList.add(file);
            }
        }
        try {
            for (String file : javaFileArrayList) {
                inputStream = new FileReader(file);
                int character;
                while ((character = inputStream.read()) != -1) {
                    outputStream.write(character);
                }
                inputStream.close();
            }
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Other error.");
        }
         */

        File directory = new File(dirName);
        FileReader inputStream;
        FileWriter outputStream;
        try {
            outputStream = new FileWriter(directory + "/" + fileName);
            File d = new File(dirName);
            String[] fileList = d.list();
            for (String file : fileList) {
                if (file.endsWith(".java")) {
                    inputStream = new FileReader(directory + "/" + file);
                    int character = 0;
                    while ((character = inputStream.read()) != -1) {
                        outputStream.write(character);
                    }
                    inputStream.close();
                }
            }
            outputStream.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("Directory does not exist");
        }
    }
}
