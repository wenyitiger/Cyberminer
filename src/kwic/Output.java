package kwic;


import java.util.ArrayList;

public class Output {
      protected String exportString(ArrayList<String> List)
      
      {
    	 
    	  String out ="";
    	  for (int count = 0; count < List.size(); count++) {
	//		  System.out.println(List.get(count));
			  out+=(List.get(count)+"\r\n");
			
		}
   // 	  System.out.println("Processed ok?"+"\n"+out);
		return out;
	
	//	System.out.println("Processed Finished");
    	  
      }  	  
		  protected ArrayList<String> exportList(ArrayList<String> List)
		  
		  {
			return List;
			  
			  
			  
		  }
		  
    	  
      
}