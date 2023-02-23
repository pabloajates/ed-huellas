package com.iesam.huellas.domain.usecases;

import com.iesam.huellas.domain.GatoRepository;

public class DeleteGatoUseCase {

    private GatoRepository gatoRepository;

    public DeleteGatoUseCase(GatoRepository gatoRepository){
        this.gatoRepository=gatoRepository;
    }

    public void execute(Integer gatoId){
        gatoRepository.delete(gatoId);
    }
}
