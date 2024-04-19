package org.example.GBrains;

public class Main {
    public static void main(String[] args) {
        String exampleFolderPath1 = "src/main/java/org/example/GBrains/folderForCopy";
        String exampleFolderPath2 = "C:/Users/Vadim/Desktop/task1/folderWithFiles";

        Task1 task1 = new Task1();
        task1.copyFilesToNewFolder();

        Task2 task2 = new Task2();
        task2.createFileAndWriteNotMoreThan3Byte();

    }
}