package com.clinic.upmanyu.service;

import com.clinic.upmanyu.dto.CheckUpDto;

import java.util.List;

public interface CheckUpService {
    CheckUpDto createCheckUp(CheckUpDto checkUpDto);

    CheckUpDto getCheckUpById(Long checkUpId);

    List<CheckUpDto> getAllCheckUps();

    CheckUpDto updateCheckUp(Long checkUpId, CheckUpDto updatedCheckUp);

    void deleteCheckUp(Long checkUpId);
}
