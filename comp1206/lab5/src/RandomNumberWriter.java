import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.RandomIO;

import java.io.*;
import java.util.Random;


public class RandomNumberWriter implements RandomIO {
    Random random;

    public RandomNumberWriter(long seed){
        random = new Random(seed);
    }

    @Override
    public void writeRandomChars(String s) throws IOException {
        try {
            FileWriter charStream = new FileWriter(s);
            for (int i = 0; i < 10000; i++) {
                charStream.write(String.valueOf(random.nextInt(100000)) + "\n");
            }
            charStream.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    @Override
    public void writeRandomByte(String s) throws IOException {
        try {
            FileOutputStream byteStream = new FileOutputStream(s);
            DataOutputStream dataStream = new DataOutputStream((byteStream));
            for (int i = 0; i < 10000; i++) {
                dataStream.writeInt(random.nextInt(100000));
            }
            byteStream.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}
