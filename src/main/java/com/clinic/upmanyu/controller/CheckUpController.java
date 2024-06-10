package com.clinic.upmanyu.controller;

import com.clinic.upmanyu.dto.CheckUpDto;
import com.clinic.upmanyu.service.CheckUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkups")
public class CheckUpController {

    private final CheckUpService checkUpService;

    @Autowired
    public CheckUpController(CheckUpService checkUpService) {
        this.checkUpService = checkUpService;
    }

    @PostMapping
    public ResponseEntity<CheckUpDto> createCheckUp(@RequestBody CheckUpDto checkUpDto) {
        CheckUpDto savedCheckUp = checkUpService.createCheckUp(checkUpDto);
        return new ResponseEntity<>(savedCheckUp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckUpDto> getCheckUpById(@PathVariable("id") Long checkUpId) {
        CheckUpDto checkUpDto = checkUpService.getCheckUpById(checkUpId);
        return ResponseEntity.ok(checkUpDto);
    }

    @GetMapping
    public ResponseEntity<List<CheckUpDto>> getAllCheckUps() {
        List<CheckUpDto> checkUps = checkUpService.getAllCheckUps();
        return ResponseEntity.ok(checkUps);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckUpDto> updateCheckUp(@PathVariable("id") Long checkUpId, @RequestBody CheckUpDto updatedCheckUp) {
        CheckUpDto checkUpDto = checkUpService.updateCheckUp(checkUpId, updatedCheckUp);
        return ResponseEntity.ok(checkUpDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCheckUp(@PathVariable("id") Long checkUpId) {
        checkUpService.deleteCheckUp(checkUpId);
        return ResponseEntity.ok("Check-Up Deleted successfully!");
    }
}
