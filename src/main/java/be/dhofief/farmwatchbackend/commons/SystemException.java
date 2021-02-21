package be.dhofief.farmwatchbackend.commons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemException extends Exception {

    public SystemException(String message, Throwable cause){
        super(message, cause);
    }

}
