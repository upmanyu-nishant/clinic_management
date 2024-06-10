package com.clinic.upmanyu.mapper;

import com.clinic.upmanyu.dto.CheckUpDto;
import com.clinic.upmanyu.entity.CheckUp;

public class CheckUpMapper {
    public static CheckUpDto mapToCheckUpDto(CheckUp checkUp) {
        CheckUpDto checkUpDto = new CheckUpDto();
        checkUpDto.setCheckUpId(checkUp.getCheckUpId());
        checkUpDto.setSymptoms(checkUp.getSymptoms());
        checkUpDto.setInvestigation(checkUp.getInvestigation());
        checkUpDto.setDiagnosis(checkUp.getDiagnosis());
        checkUpDto.setTreatment(checkUp.getTreatment());
        checkUpDto.setInvestigationResults(checkUp.getInvestigationResults());
        checkUpDto.setMedicine(checkUp.getMedicine());


        return checkUpDto;
    }

    public static CheckUp mapToCheckUp(CheckUpDto checkUpDto) {
        CheckUp checkUp = new CheckUp();
        checkUp.setCheckUpId(checkUpDto.getCheckUpId());
        checkUp.setSymptoms(checkUpDto.getSymptoms());
        checkUp.setInvestigation(checkUpDto.getInvestigation());
        checkUp.setDiagnosis(checkUpDto.getDiagnosis());
        checkUp.setTreatment(checkUpDto.getTreatment());
        checkUp.setInvestigationResults(checkUpDto.getInvestigationResults());
        checkUp.setMedicine(checkUpDto.getMedicine());
        // It's recommended to set the patient separately in the service to avoid circular dependencies
        return checkUp;
    }
}
