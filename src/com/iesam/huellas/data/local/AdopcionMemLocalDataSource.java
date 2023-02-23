package com.iesam.huellas.data.local;

import com.iesam.huellas.domain.models.Adopcion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdopcionMemLocalDataSource implements AdopcionLocalDataSource{

    private static AdopcionMemLocalDataSource instance = null;

    private Map<String, Adopcion> storage = new TreeMap<>();

    private AdopcionMemLocalDataSource(){

    }

    @Override
    public void save(Adopcion adopcion) {
        storage.put(adopcion.getId(), adopcion);
    }

    @Override
    public Adopcion findById(Integer adopcionId) {
        return storage.get(adopcionId);
    }

    @Override
    public List<Adopcion> findAll() {
        return new ArrayList<>(storage.values());
    }

    public static AdopcionMemLocalDataSource getInstance(){
        if (instance == null){
            instance = new AdopcionMemLocalDataSource();
        }
        return instance;
    }
}
