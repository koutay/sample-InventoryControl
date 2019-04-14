package servletmain;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductJB;
import model.UpdateLogic;

/**
 * Servlet implementation class UpdateMain
 */
@WebServlet("/log/UpdateMain")
public class UpdateMain extends HttpServlet {

	private final String COUNT = "count";

	private final String UPDATE_LIST = "updateList";

	UpdateLogic uLogic = new UpdateLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMain() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		List<ProductJB> empList = (List<ProductJB>) session.getAttribute(UPDATE_LIST);
		Integer count = uLogic.executeUpdate(empList);
		session.setAttribute(COUNT, count);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/resultjsp/resUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
