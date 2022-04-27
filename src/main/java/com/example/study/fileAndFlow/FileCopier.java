package com.example.study.fileAndFlow;

import java.io.*;

public class FileCopier {
    public void readOneFile() throws IOException {
        File sourceFile = new File("D:\\work2022\\sourcePackage\\sourceFile.txt");
        InputStream inputStream = new FileInputStream(sourceFile);
        for (int i=0;i<inputStream.available();i++){
            System.out.println((char)inputStream.read()+" ");
        }
        inputStream.close();
    }

    public void writeOneFile(){
        File targetFile = new File("D:\\work2022\\targetPackage\\targetFile.txt");
        File path = new File("D:\\work2022\\targetPackage");
        try {
            path.mkdirs();
            if (!targetFile.exists()){
                targetFile.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(targetFile);
            byte[] writeBytes = new byte[]{1,2,3};
            outputStream.write(writeBytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyOneFile(){
        File sourceFile = new File("D:\\work2022\\sourcePackage\\sourcePic.jpg");
        File targetFile = new File("D:\\work2022\\targetPackage\\targetPic.jpg");
        try {
            targetFile.createNewFile();
            InputStream inputStream = new FileInputStream(sourceFile);
            OutputStream outputStream = new FileOutputStream(targetFile);
            byte[] content = inputStream.readAllBytes();
            outputStream.write(content);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readChineseFile(){
        File sourceFile = new File("D:\\work2022\\sourcePackage\\sourceFile.txt");
        try {
            InputStream inputStream = new FileInputStream(sourceFile);
            InputStreamReader chinese = new InputStreamReader(inputStream);
            FileReader fileReader = new FileReader(sourceFile);
            char[] content = new char[10];
            chinese.read(content);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
