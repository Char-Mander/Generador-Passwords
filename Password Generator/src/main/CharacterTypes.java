package main;

public enum CharacterTypes {
    DOWNLETTERS("abcdefghijklmnñopqrstuvwxyz"),
    NUMBERS("0123456789"),
    SPECIAL_CHARATERS("!@#$%&¿?¡!·¬+-"),
    UPLETTERS("ABCDEFGHIJKLMNÑOPQRSTUVWXYZ");
    
    private String characterType;

    CharacterTypes(String _characterType) { this.characterType = _characterType; }
        
    public String getValue() { return this.characterType; }
    
}
