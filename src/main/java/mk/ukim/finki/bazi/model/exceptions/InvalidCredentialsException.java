package mk.ukim.finki.bazi.model.exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException() {
        super("Invalid user credentials exception");
    }

}
