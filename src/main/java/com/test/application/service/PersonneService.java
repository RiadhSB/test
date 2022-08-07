package com.test.application.service;

import com.test.application.dto.PersonneDto;
import com.test.application.entity.Personne;
import com.test.application.util.AppResponse;

import java.util.List;

public interface PersonneService {
 AppResponse<List<PersonneDto>> getAllPersonnes();
AppResponse<PersonneDto> savePersonne(Personne personne);
}
