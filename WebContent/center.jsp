<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dto.urlinfo"%>
    <%@page import="Indexoperation.Pager"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css" type="text/css" rel="stylesheet"/>
<style>
input{font-size:1.3em;}
#log{position: absolute; top: 10px; right: 10px;}
span{color:blue; text-decoration: underline; cursor: pointer;}
</style>


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.6/jquery-ui.min.js" type="text/javascript"></script>

<script src="js/jquery.googleSuggest.js" type="text/javascript"></script>

	<script> 
	
    </script>
    
<title>Search</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="SearchServlet">
   <table width="743" height="105" border="0">
     <tr>
       <td width="743" height="31"><label>
       
         <input  type="text" name="keyword" id="keyword"/>
      
          <label>
   
      

     <input type="submit" name="Submit" value="Search" />
     
     </label>
       </label></td>
     </tr>  
   </table>
  <%  
  ArrayList<urlinfo> list = (ArrayList<urlinfo>)request.getSession().getAttribute("result");  
            int pagesize = 5;
            if(request.getSession().getAttribute("size")!=null){
    pagesize = Integer.parseInt((String)(request.getSession().getAttribute("size")));
            }    
              
            int liststep = 10;
            int pages = 1; 
            if (request.getParameter("pages") != null) {  
                pages = Integer.parseInt(request.getParameter("pages"));
            }  
            int count =0;
            if(list!=null){
            count = list.size();
            }
            
            int pagescount = (int) Math.ceil((double) count / pagesize);
            if (pagescount < pages) {  
                pages = pagescount;  
            }  
            if (pages < 1) {  
                pages = 1;
            }  
            int listbegin = (pages - (int) Math.ceil((double) liststep / 2));
            if (listbegin < 1) { 
                listbegin = 1;  
            }  
            int listend = pages + liststep / 2;
            if (listend > pagescount) {   
                listend = pagescount + 1;  
            }  
        %>  
      
       
          
            <%  
            if(list!=null){
            Pager paget = new Pager(pages,pagesize,list);
            ArrayList<urlinfo> listpages = paget.getPagerList();
              
                
             for(int i=0;i<listpages.size();i++){ 
                    urlinfo b = listpages.get(i);  
                    System.out.println(b.getDescription());
                  
                   
            %>  
           
         <a href="http:\\<%=b.getUrl()%>"   name ="<%b.getUrlid();%>" target="blank"  onclick = "doRequestUsingPost(this)">
          
          <%=b.getUrl()%>  </a>
          <br>
           
           
            <%=b.getDescription()%>
            <br></br>
      
            <%  
                }
                }  
            %>  
           
            <select name="size" id="size"  onchange="select()">  
          
            <option  value="5" >5</option>  
            <option value="10" >10</option>  
            <option value="15">15</option>  
        </select>records per page  
      
        <table align="center">  
            <tr>  
                <%  
                if(list!=null){
                   
                    for (int i = listbegin; i < listend; i++) {  
                        if (i != pages) {
                            out.println("<td><a href=?pages=" + i + ">[" + i  
                                    + "]</a></td>");  
                        } else {  
                            out.println("<td>[" + i + "]</td>");  
                        }  
                    }
                    
                    }
                %>  
            </tr>  
        </table>  
</form>
</body>
<script>


	
	$("#keyword").googleSuggest({
	
	}).focus();
	


function select(){

document.getElementsById("form1").submit();

     
  //      var   form1   =   document.createElement( " <form   method= 'post '   action= 'center.jsp'   target= '_self '> "); 
   //     var   input1   =   document.createElement( " <input   name= "pageSize"   type= 'hidden '   value= '"+a+"'> "); 
   //     form1.appendChild(input1); 
    //    document.appendChild(form1); 
   //     form1.submit(); 
   //     window.returnValue   =   a; 
   //     window.close(); 
window.location.reload();
}

var xmlHttp;  

function createXMLHttpRequest()  
{  
 if(window.ActiveXObject)  
 {  
  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");  
 }  
 else if(window.XMLHttpRequest)  
 {  
  xmlHttp=new XMLHttpRequest();  
 }  
}  

  

function doRequestUsingPost(obj)  
{  
	var  url = obj.href;
	
 createXMLHttpRequest();  
 var url1="./Addhitsservlet?url=" + url;  
   
 xmlHttp.open("POST",url1,true);  
 
 xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");  
 xmlHttp.send(url1);  
}  

</script>
</html>
