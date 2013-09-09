package kwic;
import java.io.BufferedReader;
import java.util.ArrayList;

import Indexoperation.Shiftlines;
public class Mastercontrol {

	

	
		private Input input;
		private Output output;
		private Alphabetizer alphabetize;
		private CircularShift shift;
		private DataStore store;
		
		private ArrayList<String> kwicList = new ArrayList<String>();
		private ArrayList<String> ShiftList = new ArrayList<String>();
		private BufferedReader buffer = null;
		private String inputPath;
		private String outputPath;
		private String inputString;
		private String result;
	//	private ArrayList<Shiftlines> resultindex = new ArrayList<Shiftlines>();

		
		public Mastercontrol(Input input, Output output,Alphabetizer alphabetize,CircularShift shift,DataStore store) {
			this.input = input;
			this.output = output;
			this.alphabetize = alphabetize;
			this.shift = shift;
			this.store = store;
			
		}
		
		public void input(String inputx) {
			//Set the file path
			buffer =input.Stringin(inputx);
		//	inputPath = input.setPath("Import");
		//	outputPath = input.setPath("Export");
			
			//Open the file
		//	buffer = input.fileopen(inputPath);

		}
		
		public String output(){
			//Write the file
			result =output.exportString(ShiftList);
			
	//		System.out.println(result);
			return result;
		}
		
	
		
		
		public void alphabetize(){
			alphabetize.SortKwic(ShiftList);
		}
		public void Store(){
			store.Store(kwicList, buffer);
			
		}
		public ArrayList<String> shift() {
			shift.shift(kwicList,ShiftList);
			return ShiftList;
		}
	}