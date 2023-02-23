package com.iesam.huellas.domain.usecases;

import com.iesam.huellas.domain.GatoRepository;
import com.iesam.huellas.domain.models.Gato;

import java.util.List;

public class GetGatoUseCase {

    private GatoRepository GatoRepository;

    public GetGatoUseCase(GatoRepository gatoRepository){
        this.GatoRepository=GatoRepository;
    }

    public List<Gato> execute(){
        return GatoRepository.getAll();
    }
}
