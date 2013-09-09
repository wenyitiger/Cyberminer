package serverlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Indexoperation.Search;
import Indexoperation.Shiftlines;
import Indexoperation.sortresult;
import dto.urlinfo;


@WebServlet(urlPatterns={"/SearchServlet"})
public class SearchServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    /**
	     * Default constructor. 
	     */
	    public SearchServlet() {
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
			 String keyword;
			
	  
	  keyword = request.getParameter("keyword");
	  
	  
	  Pattern p = Pattern.compile("[.,\"\\[\\]?!:'~@#$%^*()`_+-={};/><|\\\\]");  
      Matcher m = p.matcher(keyword);  
        
      keyword = m.replaceAll(" ");   
	  Search search = new Search();
		ArrayList<urlinfo> result = new ArrayList<urlinfo>();
		 String path =  this.getServletContext().getRealPath("/");
		 File file1 = new File(path+"index.db");
		  file1.createNewFile();
		result = search.Search(keyword,path);
		sortresult sort= new sortresult();
		sort.setPath(path);
		sort.setList(result);
		result =sort.sortArrayList();
	  request.getSession().setAttribute("result", result);
	 
	  
	  
	  request.getSession().setAttribute("size",request.getParameter("size"));
	 
		    response.sendRedirect("center.jsp");
		  
		
		    
		}
		
	}

