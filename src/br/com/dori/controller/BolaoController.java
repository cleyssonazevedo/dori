package br.com.dori.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.dori.dao.bolao.IBolaoDAO;
import br.com.dori.entities.Bolao;

@Controller
@RequestMapping("/bolao")
public class BolaoController {
	
	@Autowired
	private IBolaoDAO bolaoDAO;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Bolao> Buscar(@RequestHeader("Authorization") String authorization, HttpServletRequest request) throws Exception {
		Bolao bolao = bolaoDAO.Active();
		if(bolao != null){
			request.getSession().setAttribute("bolao", bolao);
			return ResponseEntity.ok(bolao);
		} else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Bolao> Buscar(@PathVariable long id, @RequestHeader("Authorization") String authorization, HttpServletRequest request) throws Exception {
		Bolao bolao = bolaoDAO.Find(id);
		
		if(bolao != null) {
			request.getSession().setAttribute("bolao", bolao);
			return ResponseEntity.ok(bolao);
		} else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Bolao Inserir(@RequestHeader("Authorization") String authorization, HttpServletRequest request) throws Exception {
		Bolao bolao = bolaoDAO.Insert();
		request.getSession().setAttribute("bolao", bolao);
		return bolao;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	private void ExceptionError(Exception e, HttpServletResponse response) throws IOException {
		response.sendError(500, e.getMessage());
	}
}
