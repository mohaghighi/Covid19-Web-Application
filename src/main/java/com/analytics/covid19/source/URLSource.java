
package com.analytics.covid19.source;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mo
 */

public class URLSource implements DataSource{

    private String PathtoURL=null;
    
    
    public URLSource(String PathtoURL){
        this.PathtoURL=PathtoURL;
    }
    
    @Override
    public String getSource() {
        return fetchFile();
    }
    
    private String fetchFile(){
        
        String toFile = "./global.csv";
        File file=new File(toFile);

        try {
            URL Address = new URL(PathtoURL);
            ReadableByteChannel byteChannel = Channels.newChannel(Address.openStream());
            FileOutputStream fileOutStream = new FileOutputStream(file,false);
            fileOutStream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            fileOutStream.flush();
            byteChannel.close();
            fileOutStream.close();
            return toFile;
            
        } catch (IOException e) {
            System.out.println("++++++ URL PATH NO VALID +++++");
            e.printStackTrace();
            return null;
        }
    }
    
}
