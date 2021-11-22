package com.sample.factory.exception;

import com.sample.factory.VO.ResponseVO;
import com.sample.factory.constant.MessageStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundError.class)
    public final ResponseEntity<ResponseVO> handleException(ResourceNotFoundError ex, WebRequest request) throws Exception {
        final ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(HttpServletResponse.SC_NOT_FOUND);
        responseVO.setStatus(MessageStore.ERROR);
        responseVO.setMessage(ex.getMessage());
        responseVO.setExecutionTime();
        return ResponseEntity.ok(responseVO);
    }

    @ExceptionHandler(ValidationError.class)
    public final ResponseEntity<ResponseVO> handleException(ValidationError ex, WebRequest request) throws Exception {
        final ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(HttpServletResponse.SC_EXPECTATION_FAILED);
        responseVO.setStatus(MessageStore.ERROR);
        responseVO.setMessage(ex.getMessage());
        responseVO.setExecutionTime();
        return ResponseEntity.ok(responseVO);
    }

    @ExceptionHandler(ApplicationError.class)
    public final ResponseEntity<ResponseVO> handleException(ApplicationError ex, WebRequest request) throws Exception {
        final ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseVO.setStatus(MessageStore.ERROR);
        responseVO.setMessage(MessageStore.GENERIC_ERROR);
        responseVO.setExecutionTime();
        return ResponseEntity.ok(responseVO);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseVO> handleException(Exception ex, WebRequest request) throws Exception {
        final ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseVO.setStatus(MessageStore.ERROR);
        responseVO.setMessage(MessageStore.UNKNOWN_ERROR);
        responseVO.setExecutionTime();
        return ResponseEntity.ok(responseVO);
    }

}
