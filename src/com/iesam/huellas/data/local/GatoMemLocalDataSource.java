package com.iesam.huellas.data.local;

import com.iesam.huellas.domain.models.Gato;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

    public class GatoMemLocalDataSource implements GatoLocalDataSource{

        private static GatoMemLocalDataSource instance = null;

        private Map<Integer, Gato> storage = new TreeMap<Integer, Gato>();

        private GatoMemLocalDataSource(){

        }
        @Override
        public void save(Gato gato) {
            storage.put(gato.getId(), gato);
        }


        @Override
        public Gato findById(Integer gatoId) {
            return storage.get(gatoId);
        }

        @Override
        public List<Gato> findAll() {
            return new ArrayList<>(storage.values());
        }

        @Override
        public void delete(Integer gatoId) {
            storage.remove(gatoId);

        }

        public static GatoMemLocalDataSource getInstance(){
            if (instance == null){
                instance = new GatoMemLocalDataSource();
            }
            return instance;
        }
}
