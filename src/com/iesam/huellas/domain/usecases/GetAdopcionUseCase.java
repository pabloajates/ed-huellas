package com.iesam.huellas.domain.usecases;

import com.iesam.huellas.domain.AdopcionRepository;
import com.iesam.huellas.domain.models.Adopcion;


import java.util.List;

public class GetAdopcionUseCase {

    private AdopcionRepository adopcionRepository;

    public GetAdopcionUseCase(AdopcionRepository adopcionRepository){
        this.adopcionRepository=adopcionRepository;
    }

    public List<Adopcion> execute(){
        return adopcionRepository.getAll();
    }
}
