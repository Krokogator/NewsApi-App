package com.krokogator.newsapp.error_handling;

import org.restlet.resource.ResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Catches bad newsapi.org url or key and translates into server 500 error
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    // Error due to bad request to external API
    @ExceptionHandler(ResourceException.class)
    void handleAsInternalServerError(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
