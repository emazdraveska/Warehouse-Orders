package mk.ukim.finki.bazi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String id) {
        super(String.format("Product with id: %s was not found", id));
    }
    public ProductNotFoundException(Integer id) {
        super(String.format("Product with id: %d was not found", id));
    }
}
