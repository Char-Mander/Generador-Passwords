package main;

public class SAPasswordGenerator {
    private static SAPasswordGenerator _instance = new SAPasswordGenerator();
    private final static int MIN_SIZE = 8;
    private final static int MAX_SIZE = 20;

    private SAPasswordGenerator(){

    }

    public static SAPasswordGenerator getInstance(){  return _instance; }

    public Password generatePassword(String nombre){
        int size = (int)((Math.random() * ((MAX_SIZE - MIN_SIZE) + 1)) + MIN_SIZE);
        //Password password = new Password();
        String pass="";
        for(int i=0; i<size; i++){
            int random =  (int)((Math.random() * ((3) + 1)) + 0);
            pass+=selectACharacterRandomly(random);
        }
        Password password = new Password(nombre, pass);
        password.setPassword(pass);
        return password;
    }

    private String selectACharacterRandomly(int random){
        String character;
        switch(random){
            case 0: character = Character.toString(getRandomNumber()); break;
            case 1: character = Character.toString(getRandomUpLetter()); break;
            case 2: character = Character.toString(getRandomDownLetter()); break;
            case 3: character = Character.toString(getRandomSpecialCharacter()); break;
            default: character = null; break;
        }
        return character;
    }

    private char getRandomDownLetter(){
        int pos = (int)((Math.random() * ((CharacterTypes.DOWNLETTERS.getValue().length()))) + 0);
        System.out.println("character: " + CharacterTypes.DOWNLETTERS.getValue().toCharArray()[pos]);
        return CharacterTypes.DOWNLETTERS.getValue().toCharArray()[pos];
    }

    private char getRandomNumber(){
        int pos = (int)((Math.random() * ((CharacterTypes.NUMBERS.getValue().length()))) + 0);
        System.out.println("character: " + CharacterTypes.NUMBERS.getValue().toCharArray()[pos]);
        return CharacterTypes.NUMBERS.getValue().toCharArray()[pos];
    }

    private char getRandomSpecialCharacter(){
        int pos = (int)((Math.random() * ((CharacterTypes.SPECIAL_CHARATERS.getValue().length()))) + 0);
        System.out.println("character: " + CharacterTypes.SPECIAL_CHARATERS.getValue().toCharArray()[pos]);
        return CharacterTypes.SPECIAL_CHARATERS.getValue().toCharArray()[pos];
    }

    private char getRandomUpLetter(){
        int pos = (int)((Math.random() * ((CharacterTypes.UPLETTERS.getValue().length()))) + 0);
        System.out.println("character: " + CharacterTypes.UPLETTERS.getValue().toCharArray()[pos]);
        return CharacterTypes.UPLETTERS.getValue().toCharArray()[pos];
    }
}
