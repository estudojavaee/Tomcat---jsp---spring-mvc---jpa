package br.com.mrcsfelipe.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mrcsfelipe.spring.dao.JpaTarefaDao;
import br.com.mrcsfelipe.spring.entity.Tarefa;

@Transactional
@Controller
public class HelloWorldController {

	@Autowired private JpaTarefaDao dao;
	
	
	@RequestMapping("/hello")
    public String hello(
            @RequestParam(value="name", required=false, defaultValue="World") 
            String name, 
            Model model) {
		
        model.addAttribute("name", name);
        return "helloworld";
    }
	
	@RequestMapping("/")
    public String index(
            @RequestParam(value="name", required=false, defaultValue="World") 
            String name, 
            Model model) {
		
        model.addAttribute("name", name);
        return "helloworld";
    }
	
	
	@RequestMapping(value = "/addTarefa", method = RequestMethod.POST)
	@Transactional
	public String addPerson(Model model,  String name) {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(name);
		dao.adiciona(tarefa);
		
		model.addAttribute("Cadastrado com sucesso", name);
		return "redirect:/hello?name=cadastrado";
	}
}
