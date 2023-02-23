package com.iesam.huellas.domain;

import com.iesam.huellas.domain.models.Gato;

import java.util.List;

public interface GatoRepository {

    public void save(Gato gato);
    public List<Gato> getAll();
    public void delete(Integer catId);
}

