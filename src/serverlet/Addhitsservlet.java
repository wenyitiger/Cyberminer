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
import dto.urlinfo;

/**
 * Servlet implementation class Addhitsservlet
 */
@WebServlet(urlPatterns={"/Addhitsservlet"})
public class Addhitsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addhitsservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	
		String  url = request.getParameter("url");
		
         int index1 = url.indexOf("/");
         int index2 = url.lastIndexOf("/");
		 url = url.substring(index1+2,index2);

     

		   Addurl add = new Addurl();
		 String path =  this.getServletContext().getRealPath("/");

         add.urlhitsupdate(url, path);


		
			    response.sendRedirect("center.jsp");
	}

	
	
	
}
