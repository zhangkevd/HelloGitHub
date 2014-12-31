package mynio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ZHANG on 2014-12-31.
 */
public class MyReadAndShow {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("readsomebytes.txt");
            FileChannel channel = fileInputStream.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(2048);
            channel.read(allocate);
            allocate.flip();

            int i = 0;
            while (allocate.hasRemaining()){
                System.out.println( "Character "+i+": "+((byte) allocate.get()) );
                i++;
            }
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
