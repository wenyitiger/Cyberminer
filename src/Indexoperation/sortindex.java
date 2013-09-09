package Indexoperation;

import java.util.Comparator;

public class sortindex implements Comparator{
    
    public int compare(Object o1, Object o2)
    {
    	Shiftlines s1 = (Shiftlines)o1;
    	Shiftlines s2 = (Shiftlines)o2;
        
       
        if(s1.getLine().compareTo(s2.getLine())>0)
        {
            return 1;
        }
        else if(s1.getLine().compareTo(s2.getLine())==0)
        {
            return 0;
        }else{
        	return -1;
        	
        	
        }
        
    }
    
    
    
}
