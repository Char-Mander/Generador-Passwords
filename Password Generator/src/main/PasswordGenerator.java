package main;

public class PasswordGenerator {
    private static PasswordGenerator _instance = new PasswordGenerator();
    private final static String NUMBERS="0123456789";
    private final static String UPLETTERS="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private final static String DOWNLETTERS="abcdefghijklmnñopqrstuvwxyz";
    private final static String SPECIAL_CHARATERS="!@#$%&¿?¡!·¬+-";
    private final static int MIN_SIZE = 8;
    private final static int MAX_SIZE = 20;

    private PasswordGenerator(){}

    public static PasswordGenerator getInstance(){ return _instance; }

    public Password generatePassword(){
        int size = (int)((Math.random() * ((MAX_SIZE - MIN_SIZE) + 1)) + MIN_SIZE);
        Password password = new Password();
        String pass="";
        for(int i=0; i<size; i++){
            int random =  (int)((Math.random() * ((3) + 1)) + 0);
            pass+=selectACharacterRandomly(random);
        }
        password.setPassword(pass);
        return password;
    }

    public String getNumbers(){return NUMBERS;}

    public String getUpLetters(){return UPLETTERS;}

    public String getDownLetters(){return DOWNLETTERS;}

    public String getSpecialCharaters(){return SPECIAL_CHARATERS;}

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

    private char getRandomNumber(){
        int pos = (int)((Math.random() * ((NUMBERS.length()) + 1)) + 0);
        System.out.println("character: " + NUMBERS.toCharArray()[pos]);
        return NUMBERS.toCharArray()[pos];
    }

    private char getRandomUpLetter(){
      int pos = (int)((Math.random() * ((UPLETTERS.length()) + 1)) + 0);
      System.out.println("character: " + UPLETTERS.toCharArray()[pos]);
      return UPLETTERS.toCharArray()[pos];
    }

    private char getRandomDownLetter(){
        int pos = (int)((Math.random() * ((DOWNLETTERS.length()) + 1)) + 0);
        System.out.println("character: " + DOWNLETTERS.toCharArray()[pos]);
        return DOWNLETTERS.toCharArray()[pos];
    }

    private char getRandomSpecialCharacter(){
        int pos = (int)((Math.random() * ((SPECIAL_CHARATERS.length()) + 1)) + 0);
        System.out.println("character: " + SPECIAL_CHARATERS.toCharArray()[pos]);
        return SPECIAL_CHARATERS.toCharArray()[pos];
    }

}
