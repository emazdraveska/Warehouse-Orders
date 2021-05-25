package mk.ukim.finki.bazi.model.exceptions;

public class QuantityException extends RuntimeException{
    public QuantityException() {
        super(String.format("There aren't enough products in the warehouse for your order"));
    }

}
