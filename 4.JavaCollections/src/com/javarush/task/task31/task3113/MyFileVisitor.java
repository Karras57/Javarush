package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    int filesCount;
    int directoryCount = -1;
    long size;
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()){
            filesCount++;
        }
        size+= attrs.size();
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        directoryCount++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(
                String.format("Всего папок - %d\n",directoryCount)).append(
                String.format("Всего файлов - %d\n",filesCount)).append(
                String.format("Общий размер - %d\n",size)).toString();
    }
}
