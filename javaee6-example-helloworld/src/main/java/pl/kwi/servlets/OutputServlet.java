package pl.kwi.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import pl.kwi.services.NameService;


/**
 * Class of Servlet handles requests from "Output" jsp page. 
 * 
 * @author Krzysztof Wisniewski
 *
 */
@Path("output")
public class OutputServlet {

	
//	@Inject
	private NameService nameService;
	
	
	public OutputServlet() {
		nameService = new NameService();
	}
	
	/**
	 * Method displays page *.jsp with output.
	 * 
	 * @param request object <code>HttpServletRequest</code> with request from browser
	 * @param response object <code>HttpServletResponse</code> with response to browser
	 * @throws ServletException
	 * @throws IOException
	 */
	@GET
	@Path("/")
	@Consumes
	@Produces(MediaType.TEXT_HTML)
	public void displayPage(@Context HttpServletRequest request,@Context HttpServletResponse response) throws ServletException, IOException{
			
		request.setAttribute("name", loadName());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../pages/outputJsp.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	/**
	 * Method handles pressing button "Back" on "Output" jsp page.
	 * 
	 * @param request object <code>HttpServletRequest</code> with request from browser
	 * @param response object <code>HttpServletResponse</code> with response to browser
	 * @throws IOException
	 * @throws ServletException
	 */
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces
	public void handleBackButton(@Context HttpServletResponse response) throws ServletException, IOException{
		
		response.sendRedirect("input");
		
	}
	
	/**
	 * Method loads current name of user.
	 * 
	 * @return object <code>String</code> with user`s name
	 */
	protected String loadName(){
		return nameService.load();
	}
	
	
	// ************************************************************************************** //
	// ****************************** GETTERS AND SETTERS *********************************** //
	// ************************************************************************************** //
	
	
	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}
	

}
