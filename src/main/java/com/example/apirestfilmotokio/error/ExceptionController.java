package com.example.apirestfilmotokio.error;

import com.example.apirestfilmotokio.error.dto.ErrorMessage;
import com.example.apirestfilmotokio.error.exception.DuplicateRecordException;
import com.example.apirestfilmotokio.error.exception.DontFoundRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ErrorMessage> duplicateRecordException(DuplicateRecordException e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT, e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DontFoundRecord.class)
    public ResponseEntity<ErrorMessage> userDontExistExcepction(DontFoundRecord e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
