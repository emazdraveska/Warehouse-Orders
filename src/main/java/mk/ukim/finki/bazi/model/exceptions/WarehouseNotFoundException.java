package mk.ukim.finki.bazi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WarehouseNotFoundException extends RuntimeException {
    public WarehouseNotFoundException(Integer warehouse) {
        super(String.format("Warehouse with id: %d  was not found", warehouse));
    }
}
