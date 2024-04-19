package org.example.GBrains;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Task1 {
    private Path destinationDirectoryPath;
    public void copyFilesToNewFolder() {
        String backupFolderName;
        String folderForCopyUserInputPath;
        Scanner sc = new Scanner(System.in);
        System.out.println("Давайте, скопируем файлы в папке в другую папку!");
        System.out.println("Введите путь папки с файлами для копирования (например: C:/Users/Vadim/Desktop/task1/folderWithFiles");
        folderForCopyUserInputPath = sc.nextLine();
        System.out.println("Введите имя новой папки, где будут копии файлов (например: backup");
        backupFolderName = sc.nextLine();
        try {
            createFolder(folderForCopyUserInputPath, backupFolderName);
            copyDirectory(folderForCopyUserInputPath, destinationDirectoryPath);
            System.out.println("Готово!");
        } catch (Exception e) {
            System.out.println("Не вышло =(");
            e.printStackTrace();
        }
        sc.close();
    }
    private void copyDirectory (String sourceDirName, Path destinationDirPath) {
        File folderICopyFrom = new File(sourceDirName);
        File [] folderFiles = folderICopyFrom.listFiles();
        if (folderFiles != null) {
            for (File file : folderFiles) {
                try {
                    Files.copy(file.toPath(), destinationDirPath.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void createFolder(String sourceDirectoryToBeCopied, String folderNameForOurCopy) {
        Path destinationDirectoryPath = Paths.get(sourceDirectoryToBeCopied);
        Path destinationDirectoryForNewFolder = destinationDirectoryPath.getParent();
        Path destDirForNewFolderWithName = destinationDirectoryForNewFolder.resolve(folderNameForOurCopy);
        this.destinationDirectoryPath = destDirForNewFolderWithName;
        if (Files.notExists(destDirForNewFolderWithName)) {
            try {
                Files.createDirectories(destDirForNewFolderWithName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
