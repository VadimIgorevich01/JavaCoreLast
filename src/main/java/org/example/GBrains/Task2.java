package org.example.GBrains;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    private int [] array;


    public Task2() {
        this.array = new int[] {1, 3, 0, 0, 2, 0, 0, 0, 0};
    }

    public Task2(int[] array) {
        this.array = array;
    }

    public void createFileAndWriteNotMoreThan3Byte() {
        createFile();
        try {
            writeToFile(array);
            System.out.println("Записано!");
        } catch (Exception e) {
            System.out.println("Не получилось записать!");
            e.printStackTrace();
        }
        File file = new File("src/main/java/org/example/GBrains/NotMoreThan3Byte.txt");
        System.out.println(getFileSizeBytes(file));
    }

    private String getFileSizeBytes(File file) {
        return file.length() +
                " bytes, размер нашего файла";
    }

    private void createFile() {
        try {
            File file = new File("src/main/java/org/example/GBrains/NotMoreThan3Byte.txt");
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }
    }

    private void writeToFile(int [] arrayCircleCrossGame) {
        try (FileWriter writer = new FileWriter("src/main/java/org/example/GBrains/NotMoreThan3Byte.txt")){
            String record = "";
            for (int i = 0; i < arrayCircleCrossGame.length; i++) {
                record += String.valueOf(arrayCircleCrossGame [i]);
            }
            writer.write(Integer.parseInt(record));
            System.out.println("Записано " + Integer.parseInt(record));
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}
