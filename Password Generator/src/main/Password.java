package main;

public class Password {
    private String name;
    private String password;

    public Password(String _name, String _password){
        name = _name;
        password = _password;
    }

    public String getPassword(){return password;}

    public void setPassword(String _password){ password = _password;}

    public String getName() { return name; }

    public void setName(String _name){ name = _name;}


}
