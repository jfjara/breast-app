package com.breastapp.breastappplacesservice.infraestructure.mock;

import com.breastapp.breastappplacesservice.domain.model.dto.CoordinateDto;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.dto.ServiceDtoEnum;
import com.breastapp.breastappplacesservice.domain.repository.PlacesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FindPlacesMockRepository implements PlacesRepository {

    @Override
    public Optional<PlaceDto> findPlaceById(final String id) {
        return Optional.of(PlaceDto.builder()
                .id(UUID.randomUUID().toString())
                .address("Direccion inventada 1")
                .name("Peluqueria manoli")
                .city("Sevilla")
                .country("España")
                .postalCode("41004")
                .typeService("Estetica")
                .services(List.of(ServiceDtoEnum.BABY_TABLE))
                .coordinate(CoordinateDto.builder()
                        .lat(37.392529)
                        .lon(-5.994072)
                        .build())
                .build());
    }

}
