package com.example.finalproject.Controller;

import com.example.finalproject.domain.Experience;
import com.example.finalproject.domain.Skill;
import com.example.finalproject.repository.SkillRepository;
import com.example.finalproject.service.ExperienceService;
import com.example.finalproject.service.SkillService;
import com.example.finalproject.service.dto.ExperienceDTO;
import com.example.finalproject.service.dto.SkillDTO;
import com.example.finalproject.service.impl.ExperienceImpll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;
import java.util.Optional;

@Controller
@RequestMapping("experience")
public class ExperienceController {
    private final ExperienceImpll experienceImpll;

    public ExperienceController(ExperienceImpll experienceImpll) {
        this.experienceImpll = experienceImpll;
    }

    @GetMapping("/detail")
    public String showDetail(Model model, @RequestParam(required = false) String textSearch, Pageable pageable) {
        Page<ExperienceDTO> experienceDTOS = experienceImpll.findAll(pageable);
        model.addAttribute("experience",experienceDTOS);
        return "experience/index";
    }

    @GetMapping("/create")
    public String showAdd(Model model, Pageable pageable) {
        model.addAttribute("experience", new Experience());
        return "experience/create";
    }

    @PostMapping("/add")
    public ModelAndView doAdd(@ModelAttribute("experience") @Valid ExperienceDTO experienceDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("experience/create");
            return modelAndView;
        }
        experienceImpll.save(experienceDTO);
        ModelAndView modelAndView = new ModelAndView("experience/index");
        modelAndView.addObject("experience", experienceDTO);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model,Pageable pageable){
        Optional<ExperienceDTO> experiences = experienceImpll.findOne(id);
        if (experiences!=null) {
            model.addAttribute("experience", experiences);
            return "experiences/edit";
        } else {
            return "redirect:/experiences/detail";
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Long id, @ModelAttribute("experiences") @Valid ExperienceDTO experienceDTO,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "experiences/edit";
        }
        experienceDTO.setId(id);
        experienceImpll.save(experienceDTO);
        return "redirect:/experience/detail";
    }
}
