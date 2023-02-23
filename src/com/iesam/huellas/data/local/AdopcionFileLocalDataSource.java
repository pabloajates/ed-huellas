package com.iesam.huellas.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.huellas.domain.models.Adopcion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdopcionFileLocalDataSource implements AdopcionLocalDataSource{

    private static AdopcionFileLocalDataSource instance = null;

    private String nameFile = "adopcion.txt";

    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Adopcion>>() {
    }.getType();

    private AdopcionFileLocalDataSource() {
    }

    public void save(Adopcion adopcion) {
        List<Adopcion> adopcions = findAll();
        adopcions.add(adopcion);
        saveToFile(adopcions);
    }

    @Override
    public Adopcion findById(Integer adopcionId) {
        List<Adopcion> adopcions = findAll();
        for(Adopcion adopcion : adopcions){
            if(Objects.equals(adopcion.getId(), adopcionId)) {
                return adopcion;
            }
        }
        return null;
    }


    public void saveList(List<Adopcion> adopcions) {
        saveToFile(adopcions);
    }

    private void saveToFile(List<Adopcion> adopcions) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(adopcions));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }



    public List<Adopcion> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAlumnList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Adopcion>();
    }



    public static AdopcionFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new AdopcionFileLocalDataSource();
        }
        return instance;
    }
}
