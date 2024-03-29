package main;

public class PasswordController {
    //private static Logger log = LogManager.getLogger(Controller.class);
    SAPasswordGenerator passwordGenerator = SAPasswordGenerator.getInstance();
    SAPasswordSave passwordSave = SAPasswordSave.getInstance();

    public String generateAndSavePassword(String path, String file, String name){
        Password password = generatePassword(name);
        savePassword(path, file, password);
        return password.getPassword();
    }

    private Password generatePassword(String name){
        Password pass = passwordGenerator.generatePassword(name);
        CheckPasswordSecurity security = new CheckPasswordSecurity();
        if(!security.check(pass.getPassword())){
            pass = passwordGenerator.generatePassword(name);
            while(!security.check(pass.getPassword())){
                pass = passwordGenerator.generatePassword(name);
            }
        }
        return pass;
    }

    private void savePassword(String path, String file, Password password){
        passwordSave.setDaoParameters(path, file);
        try {
            passwordSave.save(password);
        }
        catch(Exception e){
            System.out.println("Exception");
        }
    }

}
