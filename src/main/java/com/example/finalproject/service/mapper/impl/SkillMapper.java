package com.example.finalproject.service.mapper.impl;

import com.example.finalproject.domain.Department;
import com.example.finalproject.domain.Employee;
import com.example.finalproject.domain.Skill;
import com.example.finalproject.service.SkillService;
import com.example.finalproject.service.dto.DepartmentDTO;
import com.example.finalproject.service.dto.EmployeeDTO;
import com.example.finalproject.service.dto.SkillDTO;
import com.example.finalproject.service.mapper.EntityMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkillMapper implements EntityMapper<SkillDTO, Skill> {
    @Override
    public Skill toEntity(SkillDTO dto) {
        if (dto == null) {
            return null;
        }
        Skill entity = new Skill();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLevel(dto.getLevel());
        entity.setYearExperience(dto.getYearExperience());
        entity.setMonthExperience(dto.getMonthExperience());
        entity.setDescription(dto.getDescription());
        if (dto.getEmployee() != null) {
            Employee employee = new Employee();
            employee.setId(dto.getEmployee().getId());
            entity.setEmployee(employee);
        }
        return entity;
    }

    @Override
    public SkillDTO toDto(Skill entity) {
        if (entity == null) {
            return null;
        }
        SkillDTO dto = new SkillDTO();
        dto.setId(dto.getId());
        dto.setName(dto.getName());
        dto.setLevel(dto.getLevel());
        dto.setYearExperience(dto.getYearExperience());
        dto.setMonthExperience(dto.getMonthExperience());
        dto.setDescription(dto.getDescription());
        if (entity.getEmployee() != null) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(entity.getEmployee().getId());
            dto.setEmployee(employeeDTO);
        }
        return dto;
    }

    @Override
    public List<Skill> toEntity(List<SkillDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Skill> entityList = new ArrayList<>();
        for (SkillDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    @Override
    public List<SkillDTO> toDto(List<Skill> entityList) {
        if (entityList == null) {
            return null;
        }
        List<SkillDTO> dtoList = new ArrayList<>();
        for (Skill entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
