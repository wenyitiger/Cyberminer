<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%> 
<%@page import="java.util.List"%> 
<%@page import="Indexoperation.Searchhistory"%> 
<%  
Searchhistory db = new Searchhistory();  

    String query = request.getParameter("keyword");  
    System.out.println(query+"????");
    List<String> countries = db.getData(query);  

    Iterator<String> iterator = countries.iterator();  
    while(iterator.hasNext()) {  
        String country = (String)iterator.next();  
        out.println(country);  
    }  
%> 
