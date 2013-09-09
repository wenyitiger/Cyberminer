<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="DeleteurlServlet"  onSubmit="return check()">
   <table width="743" height="35" border="0">
     <tr>       
       <td width="602" height="20"><label>URL</label><br>
         <input type="text" name="url" id = "url" /></br>
          <label>
     <input type="submit" name="Submit" value="Delete" />
     </label>
       </td>
     </tr>    
   <br>
     
     <c:if test="${msg == 'error'}">
			<tr align="center">
				<td colspan="2"><label style="color:red;">The URL does not exist</label></td>
			</tr>
     </c:if>
   </table>

  
  
   <p>
    
     
   </p>
</form>
<script>
function check(){
	
	var reg =  /[0-9a-zA-z]+.(com|cn|net|com.cn|org|edu|ca|us)$/;
	var isurl = reg.test(document.getElementById("url").value); 
	
	
	if(isurl==false){
		
		alert("This is not a valid URL");
	}
	
    return isurl;
  
    
}
</script>
</body>
</html>