package com.test.application.controller;

import com.test.application.dto.PersonneDto;
import com.test.application.entity.Personne;
import com.test.application.service.PersonneService;
import com.test.application.util.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application/api")
public class PersonneController {
   PersonneService personneService;
   @Autowired
    PersonneController(PersonneService prsService){
        this.personneService=prsService;
    }

    @GetMapping("getAllPersonnes")
   public AppResponse<List<PersonneDto>> getListPersonnes(){
   return  personneService.getAllPersonnes();
}
@PostMapping("savePersonne")
    public AppResponse<PersonneDto> savePersonne(@RequestBody Personne personne){
       return personneService.savePersonne(personne);
}
@GetMapping("sayhello")
    public  String sayHello(){
       return  "Hello";
}

}
