package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entities.Formation;
import com.example.repositories.FormationRepository;

@Controller
@RequestMapping("/formationList")
public class FormationController
{
	private FormationRepository formationRepository;
	
	@Autowired
	public FormationController(FormationRepository formationRepository)
	{
		this.formationRepository = formationRepository;
	}
	
	@RequestMapping(value="/{theme}", method=RequestMethod.GET)
	public String listerLesFormations(@PathVariable("theme") String theme, Model model)
	{
		List<Formation> formations = formationRepository.findByTheme(theme);
		
		if (formations != null)
			model.addAttribute("formations", formations);
		
		return "Liste des formations pour le thème " + theme + " : ";
	}
	
	@RequestMapping(value="/{theme}", method=RequestMethod.POST)
	public String addToFormation(@PathVariable("theme") String theme, Formation formation)
	{
		formation.setTheme(theme);
		formationRepository.save(formation);
		return "redirect:/Formation/{theme}";
	}
}
