package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DAOPassword {
    private static DAOPassword _instance = new DAOPassword();
    private static String directorio = null;
    private static String NAMEFILE = null;

    private DAOPassword(){}

    public static DAOPassword get_instance(){return _instance;}

    public void setValues(String dir, String file) {
        setDirectorio(dir);
        setFileDir(file);
    }

    public void guardarPassword(Password password) throws IOException {

        File dir = new File(directorio);
        if(!dir.exists()){
            Path dirPath = Paths.get(directorio);
            Files.createDirectories(dirPath);
        }

        String fileInfo = buscarArchivo();
        directorio+=NAMEFILE;
        String newInfo = "" + password.getName() + ": \t" + password.getPassword();
        if(fileInfo != null){
            fileInfo+=newInfo;
            escribirEnArchivo(fileInfo);
        }
        else{
            escribirEnArchivo(newInfo);
        }
    }

    private String buscarArchivo(){
        File root = new File(directorio);
        String fileInfo = null;
        boolean found = false;
        int index = 0;
        while(!found && index<root.list().length) {

            if(root.list()[index].equals(NAMEFILE)) {
                File fileDirectory = new File(directorio + File.separator + root.list()[index]);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
                    String reader = "";
                    fileInfo="";
                    while ((reader = br.readLine()) != null) {
                       fileInfo +=reader+"\n";
                    }
                    found = true;
                }
                catch(Exception e){
                    System.out.println("Ha habido un error al leer archivo");
                }
            }
            index++;
        }
        return fileInfo;
    }

    private void escribirEnArchivo(String datos) throws IOException {
        File logFile=new File(directorio);
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
        writer.write(datos);
        writer.close();
    }

    private void setDirectorio(String _directorio){
        if (_directorio != null && !_directorio.equals("")) {
            directorio = _directorio;
        } else {
            directorio = System.getProperty("java.io.tmpdir");
        }
    }

    private void setFileDir(String file) {
        if (file != null && !file.equals("")) {
            NAMEFILE = file;
        } else {
            NAMEFILE = "Passwords.txt";
        }
    }
}
