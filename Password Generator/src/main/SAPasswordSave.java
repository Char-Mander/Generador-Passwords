package main;

import java.io.IOException;

public class SAPasswordSave {
    private static SAPasswordSave _instance = new SAPasswordSave();
    private static DAOPassword dao = DAOPassword.get_instance();

    private SAPasswordSave(){

    }

    public static SAPasswordSave getInstance(){return _instance;}

    public void setDaoParameters(String directory, String fileDirectory){
        dao.setValues(directory, fileDirectory);
    }

    public void save(Password password) throws IOException {
        dao.guardarPassword(password);
    }
}
