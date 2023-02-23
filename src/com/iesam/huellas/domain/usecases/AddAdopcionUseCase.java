package com.iesam.huellas.domain.usecases;

import com.iesam.huellas.domain.AdopcionRepository;
import com.iesam.huellas.domain.GatoRepository;
import com.iesam.huellas.domain.models.Adopcion;
import com.iesam.huellas.domain.models.Gato;

public class AddAdopcionUseCase {

    private AdopcionRepository adopcionRepository;

    public AddAdopcionUseCase(AdopcionRepository adopcionRepository){
        this.adopcionRepository= adopcionRepository;
    }

    public void execute(Adopcion adopcion){
        adopcionRepository.save(adopcion);
    }
}
