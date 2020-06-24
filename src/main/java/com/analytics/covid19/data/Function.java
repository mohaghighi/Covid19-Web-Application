
package com.analytics.covid19.data;

/**
 *
 * @author Mo
 */
public class Function {
    
    private int id;
    private String instruction;
    private String restCall;

    public Function(){
        
    }
    
    public Function(int id, String instruction, String restCall) {
        this.id = id;
        this.instruction = instruction;
        this.restCall=restCall;
    }

    public int getId() {
        return id;
    }

    public String getInstruction() {
        return instruction;
    }


    public String getRestCall() {
        return restCall;
    }

    @Override
    public String toString() {
        return "Function{" + "id=" + id + ", instruction=" + instruction + ", restCall=" + restCall + '}';
    }
    
    
    
    
}
