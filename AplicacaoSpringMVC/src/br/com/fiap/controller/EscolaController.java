package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.entity.Escola;

@Controller
public class EscolaController {
	
	@RequestMapping("/escola/cadastro")
	public String incluir() {
		return "cadastros/incluirCurso";
	}
	
	public String incluir(Escola escola, ModelMap map) {
		return "index";
	}
}
