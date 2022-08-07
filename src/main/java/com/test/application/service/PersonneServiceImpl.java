package com.test.application.service;

import com.test.application.config.ObjectMapperUtils;
import com.test.application.dto.PersonneDto;
import com.test.application.entity.Personne;
import com.test.application.repository.PersonneRepository;
import com.test.application.util.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@Service
public class PersonneServiceImpl implements PersonneService{

    private PersonneRepository personneRepository;
@Autowired
    PersonneServiceImpl(PersonneRepository prsRepository){
        this.personneRepository=prsRepository;
    }
    @Override
    public AppResponse<List<PersonneDto>> getAllPersonnes() {
    List<PersonneDto> listPersonnesDto= ObjectMapperUtils.mapAll(personneRepository.findAllByOrderByPrenomAsc(),PersonneDto.class);

        listPersonnesDto.stream().map(personne->{
            personne.setAge(getPersonneAge(personne.getDatDeNaissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
       return personne;
        });
      return new AppResponse(HttpStatus.OK.value()  ,"Liste de personnes", listPersonnesDto);
    }

    @Override
    public AppResponse<PersonneDto> savePersonne(Personne personne) {
        if(getPersonneAge(personne.getDatDeNaissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())<150){
          Personne newPerson=personneRepository.save(personne);
          return new AppResponse(HttpStatus.OK.value(),"La personne est sauvegardé avec succés",ObjectMapperUtils.map(newPerson,PersonneDto.class));
        }else{
            return new AppResponse(HttpStatus.BAD_REQUEST.value(), "Age doit etre inférieur à 150",personne);
        }
    }

    private int getPersonneAge(LocalDate dateDeNaissance){
        LocalDate curDate = LocalDate.now();

        if ((dateDeNaissance != null) && (curDate != null))
        {
            return Period.between(dateDeNaissance, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }
}
