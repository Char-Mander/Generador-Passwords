package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPasswordSecurity {
    SAPasswordGenerator passwordGenerator = SAPasswordGenerator.getInstance();

    public boolean check(String password){
        return hasAtLeastOneDownLetter(password) && hasAtLeastOneNumber(password) && hasAtLeastOneSpecialCharacter(password) && hasAtLeastOneUpLetter(password);
    }

    private boolean hasAtLeastOneDownLetter(String password){
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean hasAtLeastOneNumber(String password){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean hasAtLeastOneSpecialCharacter(String password){
        Pattern pattern = Pattern.compile("[!@#$%&¿?¡!·¬+-]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean hasAtLeastOneUpLetter(String password){
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
