package serverlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Indexoperation.Addurl;
import Indexoperation.Dataentry;
import Indexoperation.Deleteurl;
import dto.urlinfo;

/**
 * Servlet implementation class DeleteurlServlet
 */
@WebServlet(urlPatterns={"/DeleteurlServlet"})
public class DeleteurlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteurlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String url;
	
	
  request.setCharacterEncoding("UTF-8");	
  url = request.getParameter("url");

  url = request.getParameter("url");
  String path =  this.getServletContext().getRealPath("/");
  File file = new File(path+"urlinfo.db");
  file.createNewFile();
  File file1 = new File(path+"index.db");
  file1.createNewFile();
Dataentry data = new Dataentry();
data.setPath(path);
int temp = data.gethits(url);
System.out.println(temp+ "why");
  if(temp ==-1){
	  String msg = "error";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	   
	  
  }else{

  
  Deleteurl dele = new Deleteurl();
	//	dele.deleteurl(url, path);

	dele.deleteurl(url, path);
	    
  ArrayList<urlinfo> result = new ArrayList<urlinfo>();
	 
request.getSession().setAttribute("result", result);
	    response.sendRedirect("center.jsp");
	}
	}
}
