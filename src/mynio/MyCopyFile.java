package mynio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ZHANG on 2014-12-31.
 */
public class MyCopyFile {
    public static void main(String[] args) throws IOException {
        //if(args == null || args.length < 2) return ;
        args = new String[2];
        args[0]="E:\\DouJia_2014_beta3.zip";
        args[1]="E:\\DouJia_2014_beta4.zip";
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        ByteBuffer fileBuffer = ByteBuffer.allocate(1024);

        while (true){
            fileBuffer.clear();

            int read = fileInputStreamChannel.read(fileBuffer);
            if(read == -1){
                break;
            }
            fileBuffer.flip();
            fileOutputStreamChannel.write(fileBuffer);

        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
