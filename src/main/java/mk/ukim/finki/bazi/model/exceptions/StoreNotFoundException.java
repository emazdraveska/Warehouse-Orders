package mk.ukim.finki.bazi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(Integer id){
        super(String.format("Store with id: %d was not found", id));
    }
}
