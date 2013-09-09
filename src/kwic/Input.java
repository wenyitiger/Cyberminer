package kwic;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;


public class Input{
	
	
	protected int urlID;
	protected String setPath(String type) {
		System.out.println("Please specify the " + type + " Path: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	protected BufferedReader Stringin(String in)
	{
              BufferedReader input = null;
		
		
			input = new BufferedReader(new StringReader(in));
		
		return input;
	}
		
}