package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DAOPassword {
    private static String directorio = System.getProperty("java.io.tmpdir");
    private static String NAMEFILE = "Contraseñas.txt";

    public DAOPassword(){}

    public DAOPassword(String _dir){
        directorio = _dir;
    }

    public void guardarPassword(String password) throws IOException {

        File dir = new File(directorio);
        if(!dir.exists()){
            Path dirPath = Paths.get(directorio);
            Files.createDirectories(dirPath);
        }

        String fileInfo = buscarArchivo();
        directorio+=NAMEFILE;
        if(fileInfo != null){
            fileInfo+=password;
            escribirEnArchivo(fileInfo);
        }
        else{
            escribirEnArchivo(password);
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
}
