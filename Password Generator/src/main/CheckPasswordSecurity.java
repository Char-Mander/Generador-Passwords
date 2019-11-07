package main;

public class CheckPasswordSecurity {
    PasswordGenerator  passwordGenerator = PasswordGenerator.getInstance();

    public boolean check(String password){
        boolean ok = hasAtLeastOneNumber(password);
        if(ok){
            ok=hasAtLeastOneUpLetter(password);
            if(ok){
                ok = hasAtLeastOneDownLetter(password);
                if(ok){
                    ok = hasAtLeastOneSpecialCharacter(password);
                }
            }
        }
        return ok;
    }


    private boolean hasAtLeastOneDownLetter(String password){
        boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.DOWNLETTERS.getValue().length()){
            if(password.contains(CharacterTypes.DOWNLETTERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }

    private boolean hasAtLeastOneNumber(String password){
        boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.NUMBERS.getValue().length()){
            if(password.contains(CharacterTypes.NUMBERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }


    private boolean hasAtLeastOneSpecialCharacter(String password){
        boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.SPECIAL_CHARATERS.getValue().length()){
            if(password.contains(CharacterTypes.SPECIAL_CHARATERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }



    private boolean hasAtLeastOneUpLetter(String password){
        boolean found = false;
        int index = 0;
        while(!found && index < CharacterTypes.UPLETTERS.getValue().length()){
            if(password.contains(CharacterTypes.UPLETTERS.getValue().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }
}
