package com.msb.email.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class CommResponse<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean success=true;

	public CommResponse(String message){
		this.msg= message;
	}
	
	/**
	 * 错误码
	 */
	private int code = 200;
	
	private String msg;
	
	private Object data;

	public static CommResponse success(Object data) {
	CommResponse result = new CommResponse();
		result.setSuccess(true);
		result.setCode(200);
		result.setMsg("成功");
		result.setData(data);
		return result;
}

}
