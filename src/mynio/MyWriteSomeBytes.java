package mynio;// $Id$

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyWriteSomeBytes
{
  static private final byte message[] = { 83, 111, 109, 101, 32,
                                          98, 121, 116, 101, 115, 46 };

  static public void main( String args[] ) throws Exception {
//    FileOutputStream fout = new FileOutputStream( "writesomebytes.txt" );
//
//    FileChannel fc = fout.getChannel();
//
//    ByteBuffer buffer = ByteBuffer.allocate( 1024 );
//
//    for (int i=0; i<message.length; ++i) {
//      buffer.put( message[i] );
//    }
//
//    buffer.flip();
//
//    fc.write( buffer );
//
//    fout.close();

    FileOutputStream fileOutputStream = new FileOutputStream("MywritesomeBytes.txt");
    FileChannel channel = fileOutputStream.getChannel();

    ByteBuffer allocate = ByteBuffer.allocate(1024);

    allocate.clear();
    for(byte msg : message){
      allocate.put(msg);
    }
    allocate.flip();

    channel.write(allocate);
    channel.close();
  }
}
