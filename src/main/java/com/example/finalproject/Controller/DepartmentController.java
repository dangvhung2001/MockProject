package com.example.finalproject.Controller;

import com.example.finalproject.domain.Department;
import com.example.finalproject.repository.DepartmentRepository;
import com.example.finalproject.service.DepartmentService;
import com.example.finalproject.service.dto.DepartmentDTO;
import com.example.finalproject.service.impl.DepartmentServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;
    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping("/detail")
    public String showDetail(Model model, @RequestParam(required = false) String textSearch,Pageable pageable) {
        Page<DepartmentDTO> departments = departmentServiceImpl.findAll(pageable);
        model.addAttribute("department", departments);
        return "department/index";
    }

    @GetMapping("/create")
    public String showAdd(Model model, Pageable pageable) {
        model.addAttribute("department", new Department());
        return "department/create";
    }

    @PostMapping("/add")
    public ModelAndView doAdd(@ModelAttribute("department") @Valid DepartmentDTO departmentDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("department/create");
            return modelAndView;
        }
        departmentServiceImpl.save(departmentDTO);
        ModelAndView modelAndView = new ModelAndView("department/index");
        modelAndView.addObject("department", departmentDTO);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model,Pageable pageable){
        Optional<DepartmentDTO> department = departmentServiceImpl.findOne(id);
        if (department!=null) {
            model.addAttribute("department", department);
            return "department/edit";
        } else {
            return "redirect:/department/detail";
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Long id, @ModelAttribute("department") @Valid DepartmentDTO departmentDTO,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department/edit";
        }
        departmentDTO.setId(id);
        departmentServiceImpl.save(departmentDTO);
        return "redirect:/department/detail";
    }
}
