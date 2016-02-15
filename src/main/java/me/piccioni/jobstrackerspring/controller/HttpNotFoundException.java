package me.piccioni.jobstrackerspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public final class HttpNotFoundException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;
  
}
