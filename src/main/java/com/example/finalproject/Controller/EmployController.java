package com.example.finalproject.Controller;

import com.example.finalproject.domain.Role;
import com.example.finalproject.repository.RoleRepository;
import com.example.finalproject.service.DepartmentService;
import com.example.finalproject.service.EmployeeService;
import com.example.finalproject.service.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/employees")
public class EmployController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final RoleRepository roleRepository;

    public EmployController(EmployeeService employeeService, DepartmentService departmentService, RoleRepository roleRepository) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("homePage")
    public String homePage() {
        return "doc/index";
    }

    @GetMapping("/index")
    public String index(@RequestParam(required = false) String textSearch, Pageable pageable, Model model) {
        Page<EmployeeDTO> employees = employeeService.findAll(textSearch, pageable);
        model.addAttribute("employees", employees);
        return "employee/index";
    }


    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        List<Role> roles = roleRepository.findAll();
//        List<DepartmentDTO> departments = departmentService.findAll();
        model.addAttribute("roles", roles);
//        model.addAttribute("departments", departments);
        return "employee/create";
    }

    @PostMapping("/add")
    public String doAdd(@ModelAttribute("employee") @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        employeeService.save(employeeDTO);
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model
    ) {
        Optional<EmployeeDTO> employee = employeeService.findOne(id);
        if (employee.isPresent()) {
            EmployeeDTO employeeDTO = employee.get();
//            List<DepartmentDTO> departments = departmentService.getAll();
            List<Role> roles = roleRepository.findAll();
            model.addAttribute("roles", roles);
            model.addAttribute("employee", employeeDTO);
//            model.addAttribute("departments", departments);
            return "employee/edit";
        } else {
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Long id, @ModelAttribute("employee") @Valid EmployeeDTO employeeDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }
        employeeDTO.setId(id);
        employeeService.save(employeeDTO);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employee/";
    }
}
