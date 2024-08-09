package com.josh.humansApp.controllers;

import com.josh.humansApp.dtos.HumanDto;
import com.josh.humansApp.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/humans")
public class HumanController {

    @Autowired
    HumanService humanService;

    @GetMapping("/{page}/{per}")  // index
    public ResponseEntity<Page<HumanDto>> getAllHumans(@PathVariable int page, @PathVariable int per){
        return new ResponseEntity<>(this.humanService.getAllHumans(page, per), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<HumanDto> createHuman(@RequestBody HumanDto humanDto){
        return new ResponseEntity<>(this.humanService.createHuman(humanDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HumanDto> updateHuman(@PathVariable long id, @RequestBody HumanDto humanDto){
        return new ResponseEntity<>(this.humanService.updateHuman(id, humanDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HumanDto> getHumanById(@PathVariable long id){
        return new ResponseEntity<>(this.humanService.getHuman(id), HttpStatus.FOUND);
    }


}
