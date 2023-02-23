package com.iesam.huellas.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.huellas.domain.models.Gato;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GatoFileLocalDataSource implements GatoLocalDataSource{

    private static GatoFileLocalDataSource instance = null;

    private String nameFile = "cats.txt";

    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Gato>>() {
    }.getType();

    private GatoFileLocalDataSource() {
    }

    public void save(Gato cat) {
        List<Gato> cats = findAll();
        cats.add(cat);
        saveToFile(cats);
    }

    public void saveList(List<Gato> cats) {
        saveToFile(cats);
    }

    private void saveToFile(List<Gato> cats) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(cats));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la informaciÃ³n.");
            e.printStackTrace();
        }
    }


    public Gato findById(Integer catId) {
        List<Gato> cats = findAll();
        for (Gato cat : cats) {
            if (Objects.equals(cat.getId(), catId)) {
                return cat;
            }
        }
        return null;
    }

    public List<Gato> findAll() {
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
        return new ArrayList<Gato>();
    }

    @Override
    public void delete(Integer catId) {

    }

    public static GatoFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new GatoFileLocalDataSource();
        }
        return instance;
    }
}
