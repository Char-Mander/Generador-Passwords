package main;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPasswordSecurity {
    PasswordGenerator  passwordGenerator = PasswordGenerator.getInstance();

    public boolean check(String password){
        return hasAtLeastOneDownLetter(password) && hasAtLeastOneNumber(password) && hasAtLeastOneSpecialCharacter(password) && hasAtLeastOneUpLetter(password);
    }


    private boolean hasAtLeastOneDownLetter(String password){
       /* boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.DOWNLETTERS.getValue().length()){
            if(password.contains(CharacterTypes.DOWNLETTERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }*/
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
        //return found;
    }

    private boolean hasAtLeastOneNumber(String password){
        /*boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.NUMBERS.getValue().length()){
            if(password.contains(CharacterTypes.NUMBERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }*/
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
       // return found;
    }


    private boolean hasAtLeastOneSpecialCharacter(String password){
        /*boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.SPECIAL_CHARATERS.getValue().length()){
            if(password.contains(CharacterTypes.SPECIAL_CHARATERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }*/
        Pattern pattern = Pattern.compile("[!@#$%&¿?¡!·¬+-]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
        //return found;
    }



    private boolean hasAtLeastOneUpLetter(String password){
        /*boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.UPLETTERS.getValue().length()){
            if(password.contains(CharacterTypes.UPLETTERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }*/
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
        //return found;
    }
}
