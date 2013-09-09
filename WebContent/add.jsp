<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="AddindexServlet" onSubmit="return check()">
   <table width="743" height="35" border="0">
     <tr>       
       <td width="602" height="20"><label>URL</label><br>
         <input type="text" name="url" id="url" /></br>
       </td>
     </tr>    
      <tr>       
        <td width="602" height="35"><label>Description       
       </label></td>
     </tr>   
   </table>

     <label>    
     <textarea name="description" id="description" cols="40" rows="10"></textarea>
     </label>
  
   <p>
     <label>
     <input type="submit" name="Submit" value="Add" />
     </label>
     <br>
     
     <c:if test="${msg == 'error'}">
			<tr align="center">
				<td colspan="2"><label style="color:red;">The URL already exists</label></td>
			</tr>
     </c:if>
   </p>
</form>
<script>
function check(){
	
	var reg =  /[0-9a-zA-z]+.(com|cn|net|com.cn|org|edu|ca|us)$/;
	var isurl = reg.test(document.getElementById("url").value); 
	var des = document.getElementById("description").value;
	var flag;
	
	if(isurl==false){
		
		alert("This is not a vaild URL");
	}
	if (des==""){
		alert("Provide a description");
		flag =false;
	}
    return isurl&&flag;
  
    
}
</script>
</body>
</html>