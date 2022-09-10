package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParticipantController {

	@Autowired 
	private ParticipantRepository partRepository;

	//To get the add-part.html page
	@GetMapping("/part")
	public String home(Participant participant)
	{
		return "add-part";
	}
	
	//add info
	@PostMapping("/add")
    public String add(@Valid Participant participant, BindingResult result, Model model) {
		System.out.println(result);
        if (result.hasErrors()) {
            return "index";
        }
        partRepository.save(participant);
        model.addAttribute("participants", partRepository.findAll());
        return "index";
    }
	
	//Get the edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
	    Participant part = partRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid department number:" + no));

	    model.addAttribute("participant", part);
	    return "update-part";
	}
	//update the existing info
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int no, @Valid Participant participant,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        participant.setPartId(no);
	        return "update-part";
	    }

	    partRepository.save(participant);
	    model.addAttribute("participants", partRepository.findAll());
	    return "index";
	}
	//delete info
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
	    Participant part= partRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid pariticipant Number:" + no));
	    partRepository.delete(part);
	    model.addAttribute("users", partRepository.findAll());
	    return "index";
	}

}

