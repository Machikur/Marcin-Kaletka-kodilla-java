package com.kodilla.good.patterns.challenges.fourthtask.filehandler;

import com.kodilla.good.patterns.challenges.fourthtask.exeption.LoadFileException;

import java.io.*;

public class FileHandler {

    private final File file;

    public FileHandler(String filename) {
        this.file = getFile(filename);
    }

    public Object loadFile() throws LoadFileException {
        if (file.length() != 0) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                return objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException s) {
                s.printStackTrace();
            }
        }
        throw new LoadFileException();
    }

    public void saveFile(Object o) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(o);
        } catch (IOException s) {
            s.printStackTrace();
        }
    }

    private File getFile(String fileName) {
        String directoryName = "data";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        return new File(directoryName + "/" + fileName);
    }
}
