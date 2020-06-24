
package com.analytics.covid19.parser;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mo
 */

public interface DataParser {
    
    public SortedMap<String,ArrayList<String>> parseKeyVals();
    
}
