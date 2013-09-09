package Indexoperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import dto.urlinfo;

import kwic.Mastercontrol;
import kwic.Alphabetizer;
import kwic.CircularShift;
import kwic.DataStore;
import kwic.Input;
import kwic.Output;

public class operation {

	
	
	 public    ArrayList<Integer>  removeDuplicate(ArrayList<Integer> list)  {
	        HashSet<Integer>  h  =   new  HashSet<Integer> (list);
	        list.clear();
	        list.addAll(h);
	        return list;
	     } 	
	
	 public    ArrayList<urlinfo>  removeDuplicateurl(ArrayList<urlinfo> list)  {
	        HashSet<urlinfo>  h  =   new  HashSet<urlinfo> (list);
	        list.clear();
	        list.addAll(h);
	        return list;
	     } 	
	
	
	public void removehits(int id,String location)
	
	{
		
	}
	
public ArrayList <Shiftlines> resort(ArrayList<Shiftlines> olddata,ArrayList<Shiftlines> newdata)
	
	{
		ArrayList <Shiftlines> c= new ArrayList <Shiftlines> ();
	   c.addAll(olddata);
		c.addAll(newdata);
		
		Comparator<Shiftlines> comp = new sortindex();
		Collections.sort(c,comp); 
		
		
		
		
		
		return c;

		
		
		
		
		
		
	}
	
	public 	ArrayList<Shiftlines> calindex(String description, int urlid){
	Input inputor = new Input();
	Output outputor = new Output();
	Alphabetizer alphabetizer = new Alphabetizer();
	CircularShift shiftor = new CircularShift();
	DataStore data = new DataStore();
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<Shiftlines> result = new ArrayList<Shiftlines>();

	Mastercontrol myKwic = new Mastercontrol(inputor,outputor,alphabetizer,shiftor, data);
	
	myKwic.input(description);
	myKwic.Store();
	list =myKwic.shift();
	myKwic.alphabetize();
	for(int j =0;j<list.size();j++){
		Shiftlines shif = new Shiftlines();
		shif.setUrlId(urlid);
		shif.setLine(list.get(j));
		result.add(shif);
		
	}
	return result;
	
	
	
	
	
	}
}
