package com.example.finalproject.Controller;

import com.example.finalproject.domain.Role;
import com.example.finalproject.repository.RoleRepository;
import com.example.finalproject.service.DepartmentService;
import com.example.finalproject.service.EmployeeService;
import com.example.finalproject.service.dto.DepartmentDTO;
import com.example.finalproject.service.dto.EmployeeDTO;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
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
        return "index";
    }

    @GetMapping("/show")
    public String index(@RequestParam(required = false) String textSearch, Pageable pageable, Model model) {
        Page<EmployeeDTO> employees = employeeService.findAll(textSearch, pageable);
        model.addAttribute("employees", employees);
        return "employee/index";
    }

    @GetMapping("/index")
    public String index(Pageable pageable, Model model, Authentication authentication) {
        String username = authentication.getName();
        Page<EmployeeDTO> employees = employeeService.findAllEmployee(pageable);
        model.addAttribute("employees", employees);
        model.addAttribute("username", username);
        return "employee/index";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        List<Role> roles = roleRepository.findAll();
        List<DepartmentDTO> departments = departmentService.getAll();
        model.addAttribute("roles", roles);
        model.addAttribute("departments", departments);
        return "employee/add";
    }

    @PostMapping("/add")
    public String doAdd(@ModelAttribute("employee") @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "employee/add";
        }
        employeeService.save(employeeDTO);
        return "redirect:/employees/index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model
    ) {
        Optional<EmployeeDTO> employee = employeeService.findOne(id);
        if (employee.isPresent()) {
            EmployeeDTO employeeDTO = employee.get();
            List<DepartmentDTO> departments = departmentService.getAll();
            List<Role> roles = roleRepository.findAll();
            model.addAttribute("roles", roles);
            model.addAttribute("employee", employeeDTO);
            model.addAttribute("departments", departments);
            return "employee/edit";
        } else {
            return "redirect:/employees/index";
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
        return "redirect:/employees/index";
    }

    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employees/";
    }
}
