package main;

public enum CharacterTypes {
    DOWNLETTERS("abcdefghijklmn�opqrstuvwxyz"),
    NUMBERS("0123456789"),
    SPECIAL_CHARATERS("!@#$%&�?�!��+-"),
    UPLETTERS("ABCDEFGHIJKLMN�OPQRSTUVWXYZ");
    
    private String characterType;

    CharacterTypes(String _characterType) { this.characterType = _characterType; }
        
    public String getValue() { return this.characterType; }
    
}
