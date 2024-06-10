package com.clinic.upmanyu.service.impl;

import com.clinic.upmanyu.dto.CheckUpDto;
import com.clinic.upmanyu.entity.CheckUp;
import com.clinic.upmanyu.exceptions.ResourceNotFoundException;
import com.clinic.upmanyu.mapper.CheckUpMapper;
import com.clinic.upmanyu.repository.CheckUpRepository;
import com.clinic.upmanyu.service.CheckUpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CheckUpServiceImpl implements CheckUpService {
    private final CheckUpRepository checkUpRepository;

    @Override
    public CheckUpDto createCheckUp(CheckUpDto checkUpDto) {
        CheckUp checkUp = CheckUpMapper.mapToCheckUp(checkUpDto);
        CheckUp savedCheckUp = checkUpRepository.save(checkUp);
        return CheckUpMapper.mapToCheckUpDto(savedCheckUp);
    }

    @Override
    public CheckUpDto getCheckUpById(Long checkUpId) {
        CheckUp checkUp = checkUpRepository.findById(checkUpId)
                .orElseThrow(() -> new ResourceNotFoundException("Check-up not found with id: " + checkUpId));
        return CheckUpMapper.mapToCheckUpDto(checkUp);
    }

    @Override
    public List<CheckUpDto> getAllCheckUps() {
        List<CheckUp> checkUps = checkUpRepository.findAll();
        return checkUps.stream()
                .map(CheckUpMapper::mapToCheckUpDto)
                .collect(Collectors.toList());
    }

    @Override
    public CheckUpDto updateCheckUp(Long checkUpId, CheckUpDto updatedCheckUp) {
        CheckUp checkUp = checkUpRepository.findById(checkUpId)
                .orElseThrow(() -> new ResourceNotFoundException("Check-up not found with id: " + checkUpId));

        checkUp.setSymptoms(updatedCheckUp.getSymptoms());
        checkUp.setInvestigation(updatedCheckUp.getInvestigation());
        checkUp.setDiagnosis(updatedCheckUp.getDiagnosis());
        checkUp.setTreatment(updatedCheckUp.getTreatment());
        checkUp.setInvestigationResults(updatedCheckUp.getInvestigationResults());
        checkUp.setMedicine(updatedCheckUp.getMedicine());

        CheckUp updatedCheckUpObj = checkUpRepository.save(checkUp);

        return CheckUpMapper.mapToCheckUpDto(updatedCheckUpObj);
    }

    @Override
    public void deleteCheckUp(Long checkUpId) {
        if (!checkUpRepository.existsById(checkUpId)) {
            throw new ResourceNotFoundException("Check-up not found with id: " + checkUpId);
        }
        checkUpRepository.deleteById(checkUpId);
    }
}
