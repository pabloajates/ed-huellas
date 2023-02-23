package com.iesam.huellas.domain.usecases;

import com.iesam.huellas.domain.GatoRepository;
import com.iesam.huellas.domain.models.Gato;

public class AddGatoUseCase {

    private GatoRepository gatoRepository;

    public AddGatoUseCase(GatoRepository gatoRepository){
        this.gatoRepository= gatoRepository;
    }

    public void execute(Gato gato){
        gatoRepository.save(gato);
    }
}
