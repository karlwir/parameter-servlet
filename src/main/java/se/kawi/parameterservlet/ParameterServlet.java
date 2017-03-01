package se.kawi.parameterservlet;

import java.io.IOException;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print")
public class ParameterServlet extends HttpServlet {

	private static final long serialVersionUID = -4277506945814671878L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameters = request.getParameterMap();

		if (!parameters.isEmpty()) {
			request.getQueryString();
			StringBuilder builder = new StringBuilder();

			parameters.forEach((k, v) -> {
				builder.append("Key: " + k + "; Value: " + v[0] + ";\n");
			});
			
			response.setContentType("text;charset=utf-8");
			response.getWriter().print(builder.toString());
		} else {
			response.getWriter().print("Needs parameters...");
			response.setStatus(SC_BAD_REQUEST);
		}

	}

}
