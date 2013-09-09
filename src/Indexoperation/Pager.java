package Indexoperation;

import java.util.ArrayList;
import java.util.List;

import dto.urlinfo;

public class Pager {  
    
    private int currentPage;  
    
    private int totalPage;  
     
    private int totalRows;  
    
    private int avgRows = 5;  
   
    private ArrayList<urlinfo> list;  
  
    public Pager() {  
        super();  
    }  
      
    public Pager(int currentPage, int avgRows, ArrayList<urlinfo> list) {  
        super();  
        this.currentPage = currentPage;  
        this.avgRows = avgRows;  
        this.list = list;  
        this.totalRows = list.size();  
        this.totalPage = (this.totalRows - 1) / this.avgRows + 1;  
    }  
  
    public ArrayList<urlinfo> getPagerList() {  
    	ArrayList<urlinfo> newList = new ArrayList<urlinfo>();  
        for(int i = (currentPage - 1) * avgRows; i < totalRows && i < currentPage * avgRows; i++) {  
            newList.add(list.get(i));  
        }  
        return newList;  
    }  
      
    public int getCurrentPage() {  
        return currentPage;  
    }  
    public void setCurrentPage(int currentPage) {  
        this.currentPage = currentPage;  
    }  
    public int getTotalPage() {  
        return totalPage;  
    }  
    public void setTotalPage(int totalPage) {  
        this.totalPage = totalPage;  
    }  
    public int getAvgRows() {  
        return avgRows;  
    }  
    public void setAvgRows(int avgRows) {  
        this.avgRows = avgRows;  
    }  
  
    public int getTotalRows() {  
        return totalRows;  
    }  
  
    public void setTotalRows(int totalRows) {  
        this.totalRows = totalRows;  
    }  
  
    public ArrayList<urlinfo> getList() {  
        return list;  
    }  
  
    public void setList(ArrayList<urlinfo> list) {  
        this.list = list;  
    }  
  
}  
