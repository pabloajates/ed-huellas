package com.iesam.huellas.data;

import com.iesam.huellas.data.local.GatoLocalDataSource;
import com.iesam.huellas.domain.GatoRepository;
import com.iesam.huellas.domain.models.Gato;

import java.util.List;

public class GatoDataRepository implements GatoRepository {


    private GatoLocalDataSource localDataSource;

    public GatoDataRepository(GatoLocalDataSource localDataSource){
        this.localDataSource=localDataSource;
    }

    @Override
    public void save(Gato gato) {
        localDataSource=localDataSource;
    }

    @Override
    public List<Gato> getAll() {
        return localDataSource.findAll();
    }

    @Override
    public void delete(Integer catId) {

    }
}
