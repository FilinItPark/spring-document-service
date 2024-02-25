package ru.flanker.documentsservice.domain.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            EntityNotFoundException.class
    })
    @ResponseBody
    public ApiError handleNotFoundException(EntityNotFoundException e) {
        log.error("{}", e.getMessage());
        return ApiError.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .type(ApiErrorType.BUSINESS)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            ConstraintViolationException.class,
            DataIntegrityViolationException.class,
            InvalidDataAccessApiUsageException.class,
            CategoryAlreadyExistsException.class
    })
    @ResponseBody
    public ApiError handleBadRequestException(RuntimeException exception) {
        log.error("{}", exception.getMessage());
        return ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .type(ApiErrorType.BUSINESS).build();

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ApiError handleValidationException(MethodArgumentNotValidException exception) {
        log.error("exception caught by advice {} ", exception.getMessage());
        BindingResult bindingResult = exception.getBindingResult();

        final var errors = String.join(" ", bindingResult
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toArray(String[]::new));


        return ApiError.builder()
                .message(errors)
                .status(HttpStatus.BAD_REQUEST)
                .type(ApiErrorType.VALIDATION)
                .build();

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ApiError handleException(Exception exception) {
        log.error("{}", exception.getMessage());
        return ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .type(ApiErrorType.SYSTEM).build();
    }
}
