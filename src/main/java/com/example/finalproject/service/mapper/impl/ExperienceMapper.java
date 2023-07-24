package com.example.finalproject.service.mapper.impl;

import com.example.finalproject.domain.Employee;
import com.example.finalproject.domain.Experience;
import com.example.finalproject.domain.Skill;
import com.example.finalproject.service.dto.ExperienceDTO;
import com.example.finalproject.service.dto.SkillDTO;
import com.example.finalproject.service.mapper.EntityMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ExperienceMapper implements EntityMapper<ExperienceDTO, Experience> {
    @Override
    public Experience toEntity(ExperienceDTO dto) {
        if (dto == null) {
            return null;
        }
        Experience entity = new Experience();
        entity.setId(dto.getId());
        entity.setName_experience(dto.getName_experience());
        entity.setTimeStart(dto.getTimeStart());
        entity.setTimeEnd(dto.getTimeEnd());
        entity.setLanguage(dto.getLanguage());
        entity.setLink(dto.getLink());
        entity.setWorkplace(dto.getWorkplace());
        entity.setPosition(dto.getPosition());
        entity.setTeamSize(dto.getTeamSize());
        entity.setDescription(dto.getDescription());
        entity.setOs(dto.getOs());
        entity.setFramework(dto.getFramework());
        if (dto.getEmployee() != null) {
            Employee employee = new Employee();
            employee.setId(dto.getEmployee().getId());
            entity.setEmployee(employee);
        }
        return entity;
    }

    @Override
    public ExperienceDTO toDto(Experience entity) {
        if (entity == null) {
            return null;
        }
        ExperienceDTO dto = new ExperienceDTO();
        dto.setId(entity.getId());
        dto.setName_experience(entity.getName_experience());
        dto.setTimeStart(entity.getTimeStart());
        dto.setTimeEnd(entity.getTimeEnd());
        dto.setLanguage(entity.getLanguage());
        dto.setLink(entity.getLink());
        dto.setWorkplace(entity.getWorkplace());
        dto.setPosition(entity.getPosition());
        dto.setTeamSize(entity.getTeamSize());
        dto.setDescription(entity.getDescription());
        dto.setOs(entity.getOs());
        dto.setFramework(entity.getFramework());
        if (entity.getEmployee() != null) {
            ExperienceDTO experienceDTO = new ExperienceDTO();
            experienceDTO.setId(entity.getEmployee().getId());
            dto.setEmployee(experienceDTO.getEmployee());
        }
        return dto;
    }

    @Override
    public List<Experience> toEntity(List<ExperienceDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Experience> entityList = new ArrayList<>();
        for (ExperienceDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    @Override
    public List<ExperienceDTO> toDto(List<Experience> entityList) {
        if (entityList == null) {
            return null;
        }
        List<ExperienceDTO> dtoList = new ArrayList<>();
        for (Experience entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }


}
