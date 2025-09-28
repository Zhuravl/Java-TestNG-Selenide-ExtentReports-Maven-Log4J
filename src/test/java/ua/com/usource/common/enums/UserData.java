package ua.com.usource.common.enums;


public enum UserData {

    VALID("loginer@usource.com.ua", "TY#pUEcGz7nN%b"),
    EMPTY_PASSWORD("loginer@usource.com.ua", ""),
    UNREGISTERED("loginernew@usource.com.ua", "TY#pUEcGz7nN%b"),
    INVALID_EMAIL("loginer.usource.com.ua", "TY#pUEcGz7nN%b"),
    WRONG_PASSWORD("loginer@usource.com.ua", "123@Fgh0lj");

    private final String email;
    private final String password;

    UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
