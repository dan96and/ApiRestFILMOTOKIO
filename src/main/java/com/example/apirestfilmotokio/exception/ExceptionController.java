package com.example.apirestfilmotokio.exception;


import com.example.apirestfilmotokio.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseUtil> hola(MethodArgumentNotValidException manve) {
        ResponseUtil responseUtil = ResponseUtil.builder().message(manve.getMessage()).errorCode(ResponseUtil.BAD_REQUEST).build();
        return new ResponseEntity<>(responseUtil, HttpStatus.BAD_REQUEST);
    }
}
