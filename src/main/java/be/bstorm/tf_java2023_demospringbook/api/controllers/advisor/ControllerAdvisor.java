package be.bstorm.tf_java2023_demospringbook.api.controllers.advisor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleRuntimeException(Exception exception){

        return ResponseEntity.status(400).body(exception.getMessage());
    }
}
