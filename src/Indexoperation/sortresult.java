package Indexoperation;

import java.util.ArrayList;
import java.util.Comparator;

import dto.urlinfo;

public class sortresult { 
	ArrayList<urlinfo> list;
	 public ArrayList<urlinfo> getList() {
		return list;
	}

	public void setList(ArrayList<urlinfo> list) {
		this.list = list;
	}

	String path;
	 
    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<urlinfo> sortArrayList()
    {
		Dataentry data = new Dataentry();
        data.setPath(path);

	        for(int i=0;i<list.size()-1;i++) {   
	            int minIndex = i;   
	            for(int j=i+1;j<list.size();j++) {   
	            	 String url1 = list.get(j).getUrl();
	                 String url2 = list.get(minIndex).getUrl();
	                 
	                 int x = data.gethits(url1);
	                 int y = data.gethits(url2);
	            
	                if(x >= y)   
	                    minIndex = j;   
	            }   
	            swap(minIndex, i);   
	        }
			return list;   

        
    }
	  

	 private void swap(int i1, int i2) {   
		 urlinfo temp = list.get(i1);   
	        list.set(i1, list.get(i2));   
	        list.set(i2, temp);   
	    }   
	
}
