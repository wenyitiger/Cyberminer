package serverlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.urlinfo;
import Indexoperation.Addurl;
import Indexoperation.Dataentry;


@WebServlet(urlPatterns={"/AddindexServlet"})

public class AddindexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddindexServlet() {
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
		 String description;
	
  request.setCharacterEncoding("UTF-8");	
  
  url = request.getParameter("url");
  String path =  this.getServletContext().getRealPath("/");
  System.out.println(path);
  File file = new File(path+"urlinfo.db");
  file.createNewFile();
  File file1 = new File(path+"index.db");
  file1.createNewFile();
  File file2 = new File(path+"hits.db");
  file2.createNewFile();
Dataentry data = new Dataentry();
data.setPath(path);
int temp = data.gethits(url);
System.out.println(temp+ "why");
  if(temp !=-1){
	  String msg = "error";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("add.jsp").forward(request, response);
	    System.out.println("why");
	  
  }else{
  description =request.getParameter("description");
   Addurl add = new Addurl();
 
  add.Add(url, description,path);
  
  ArrayList<urlinfo> result = new ArrayList<urlinfo>();
  
request.getSession().setAttribute("result", result);
	    response.sendRedirect("center.jsp");
	}
	}

}