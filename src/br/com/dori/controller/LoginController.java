package br.com.dori.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import br.com.dori.dao.bolao.IBolaoDAO;
import br.com.dori.dao.login.ILoginDAO;
import br.com.dori.entities.Login;
import br.com.dori.exceptions.UnauthorizedException;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ILoginDAO loginDAO;

	@Autowired
	private IBolaoDAO bolaoDAO;

	@RequestMapping(method = RequestMethod.POST)
	public void Logon(@ModelAttribute Login login, WebRequest web ,HttpServletRequest request, HttpServletResponse response)
			throws UnauthorizedException, Exception {
		login = loginDAO.Logar(login);
		String authorization = "value:value";
		
		request.getSession().setAttribute("login", login);
		request.getSession().setAttribute("bolao", bolaoDAO.Active());
		request.getSession().setAttribute("Authorization", authorization);
		
		response.sendRedirect("bolao.jsp");	
	}

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	private void UnauthorizedExceptionError(UnauthorizedException e, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("error", e.getMessage());
		response.sendRedirect("/dori");
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	private void ExceptionError(Exception e, HttpServletResponse response) {
		System.err.println("Exception: ");
		e.printStackTrace();

		try {
			response.sendError(500, e.getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("IOException: ");
			e1.printStackTrace();
		}
	}
}
