
package com.analytics.covid19.source;

import org.springframework.stereotype.Component;

/**
 *
 * @author Mo
 */

public class CSVSource implements DataSource{
    
    String PathtoFile=null;

    public CSVSource(String PathtoFile) {
        this.PathtoFile = PathtoFile;
    }


    @Override
    public String getSource() {
        return PathtoFile;
    }
    
}
