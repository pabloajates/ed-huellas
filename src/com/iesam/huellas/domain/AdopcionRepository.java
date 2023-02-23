package com.iesam.huellas.domain;

import com.iesam.huellas.domain.models.Adopcion;
import com.iesam.huellas.domain.models.Gato;

import java.util.List;

public interface AdopcionRepository {

    public void save(Adopcion adopcion);

    public List<Adopcion> getAll();
}
