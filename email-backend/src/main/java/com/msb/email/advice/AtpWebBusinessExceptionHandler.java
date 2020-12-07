package com.msb.email.advice;

import com.msb.email.exception.BusinessException;
import com.msb.email.vo.CommResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AtpWebBusinessExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(AtpWebBusinessExceptionHandler.class);
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public CommResponse<Object> handler(HttpServletRequest request, BusinessException e) throws Exception {
		LOGGER.error("业务接口调用异常：code{},message{}", e.getErrorCode(), e.getMessage());
		CommResponse<Object> result = new CommResponse<>();
		result.setCode(e.getErrorCode());
		result.setMsg(e.getMessage());
		return result;
	}

}
