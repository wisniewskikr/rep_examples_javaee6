package pl.kwi.rests;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import pl.kwi.services.NameService;


/**
 * Class of Servlet handles requests from "Input" jsp page. 
 * 
 * @author Krzysztof Wisniewski
 *
 */
@Path("input")
public class InputRest {

	
	@Inject
	private NameService nameService;
	
//	@Inject
//	private InputValidator inputValidator;

	
	/**
	 * Method displays page *.jsp with input.
	 * 
	 * @param response object <code>HttpServletResponse</code> with response to browser
	 * @throws IOException
	 * @throws ServletException 
	 */
	@GET
	@Path("/")
	@Consumes
	@Produces(MediaType.TEXT_HTML)
	public void displayPage(@Context HttpServletResponse response, @Context HttpServletRequest request) throws IOException, ServletException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../pages/inputJsp.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	/**
	 * Method handles pressing button "Ok" on "Input" jsp page.
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
	public void handleOkButton(@FormParam("name") String name, @Context HttpServletResponse response) throws IOException {
					
//		Map<String, String> errorMessages = inputValidator.getErrorMessages(request);
//		if(!errorMessages.isEmpty()) {			
//			displayPage(request, response);
//			return;
//		}
//		
//		String name = request.getParameter("name");	
		
		nameService.save(name);
		response.sendRedirect("output");
		
	}
	
	
	// ************************************************************************************** //
	// ****************************** GETTERS AND SETTERS *********************************** //
	// ************************************************************************************** //
	
	
	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}

//	public void setInputValidator(InputValidator inputValidator) {
//		this.inputValidator = inputValidator;
//	}
	

}
