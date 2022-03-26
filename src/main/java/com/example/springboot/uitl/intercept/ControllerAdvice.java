//package com.example.springboot.uitl.intercept;
//
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.NoHandlerFoundException;
//import org.yaml.snakeyaml.constructor.DuplicateKeyException;
//
//import javax.xml.bind.ValidationException;
//import javax.xml.ws.Response;
//
//@RestControllerAdvice
//public class ControllerAdvice {
//
//    /**
//     * 处理自定义异常
//     */
//    @ExceptionHandler(FrameException.class)
//    public Response handleFrameException(FrameException e) {
//        log.error(e.getMessage(), e);
//        return ResultUtil.exceptionResult(e);
//    }
//
//    /**
//     * 方法参数校验
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error(e.getMessage());
//        return ResultUtil.exceptionResult(new FrameException(ExceptionEnum.PARAMS_ERROR), e.getBindingResult().getFieldError().getDefaultMessage());
//    }
//
//    /**
//     * ValidationException
//     */
//    @ExceptionHandler(ValidationException.class)
//    public Response handleValidationException(ValidationException e) {
//        log.error(e.getMessage(), e);
//        return ResultUtil.exceptionResult(new FrameException(ExceptionEnum.PARAMS_ERROR), e.getCause().getMessage());
//    }
//
//    /**
//     * ConstraintViolationException
//     */
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Response handleConstraintViolationException(ConstraintViolationException e) {
//        log.error(e.getMessage(), e);
//        return ResultUtil.exceptionResult(new FrameException(ExceptionEnum.PARAMS_ERROR), e.getMessage());
//    }
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public Response handlerNoFoundException(Exception e) {
//        log.error(e.getMessage(), e);
//        return ResultUtil.exceptionResult(new FrameException(ExceptionEnum.URLNOTFUOND), "路径不存在，请检查路径是否正确");
//    }
//
//    @ExceptionHandler(DuplicateKeyException.class)
//    public Response handleDuplicateKeyException(DuplicateKeyException e) {
//        log.error(e.getMessage(), e);
//        return ResultUtil.exceptionResult(new FrameException(ExceptionEnum.DUPLICATE_KEY_CODE), "数据重复，请检查后提交");
//    }
//
//
//    @ExceptionHandler(Exception.class)
//    public Response handleException(Exception e) {
//        log.error(e.getMessage(), e);
//        return ResultUtil.exceptionResult(new FrameException(ExceptionEnum.SYSTEM_EXCEPTION), "系统繁忙,请稍后再试");
//    }
//}
