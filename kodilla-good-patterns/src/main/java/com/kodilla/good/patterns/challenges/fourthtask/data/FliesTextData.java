package com.kodilla.good.patterns.challenges.fourthtask.data;

import com.kodilla.good.patterns.challenges.fourthtask.exeption.LoadFileException;
import com.kodilla.good.patterns.challenges.fourthtask.filehandler.FileHandler;
import com.kodilla.good.patterns.challenges.fourthtask.fly.Fly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class FliesTextData implements DataBase {

    private FileHandler fileHandler;

    public FliesTextData(String fileName) {
        this.fileHandler = new FileHandler(fileName);
    }

    public Collection<Fly> getFliesCollection() {
        try {
            Collection<Fly> flies = (Collection<Fly>) fileHandler.loadFile();
            if (Objects.isNull(flies)) {
                flies = new ArrayList<>();
            }
            return flies;
        } catch (LoadFileException s) {
            return new ArrayList<>();
        }
    }

    public void saveCollection(Collection<Fly> collection) {
        fileHandler.saveFile(collection);
    }

}
