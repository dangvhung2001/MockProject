package com.example.finalproject.service.dto.mapper;

import java.util.List;

public interface EntityMapper <D, E> {
    E toEntity(D dto);

    D toDto(E Entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> EntityList);

}