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

    private boolean hasAtLeastOneNumber(String password){
        boolean found = false;
        int index = 0;
        while(!found && index <passwordGenerator.getNumbers().length()){
            if(password.contains(passwordGenerator.getNumbers().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }

    private boolean hasAtLeastOneUpLetter(String password){
        boolean found = false;
        int index = 0;
        while(!found && index <passwordGenerator.getUpLetters().length()){
            if(password.contains(passwordGenerator.getUpLetters().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }

    private boolean hasAtLeastOneDownLetter(String password){
        boolean found = false;
        int index = 0;
        while(!found && index <passwordGenerator.getDownLetters().length()){
            if(password.contains(passwordGenerator.getDownLetters().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }


    private boolean hasAtLeastOneSpecialCharacter(String password){
        boolean found = false;
        int index = 0;
        while(!found && index <passwordGenerator.getSpecialCharaters().length()){
            if(password.contains(passwordGenerator.getSpecialCharaters().substring(index, index))){
                found = true;
            }
            index++;
        }
        return found;
    }
}
