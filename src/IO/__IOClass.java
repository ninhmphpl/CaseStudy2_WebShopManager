package IO;

import java.io.*;

public class __IOClass {


    public static void checkFile(File file){
        if (!file.exists()){
            try {
//                Files.createDirectories(Path.of(file.getParent()));
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void writeFile(Object object, File file, boolean append){
        checkFile(file);

        try(FileOutputStream fileOutputStream = new FileOutputStream(file,append);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(object);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage() + ": File is not exist!");
        } catch (IOException e) {
            System.err.println(e.getMessage() + ": Write file error!");
        }
    }


    public static Object readFile(File file){
        checkFile(file);
        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            if (fileInputStream.available()>0){
                objectInputStream = new ObjectInputStream(fileInputStream);
                return objectInputStream.readObject();
            }else return null;

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage() + "File is not exist!");
            return null;
        } catch (IOException e) {
            System.err.println(e.getMessage() + ": Read file error!");
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }






}
