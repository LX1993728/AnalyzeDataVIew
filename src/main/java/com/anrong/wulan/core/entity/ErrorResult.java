package com.anrong.wulan.core.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装响应错误的请求对象
 * @author Joshua
 *
 */
public class ErrorResult extends Result {

	private static final long serialVersionUID = 3397562351269525980L;
	
	 /**
     * 封装多个 错误信息
     */
    private Map<String, Object> errors = new HashMap<String, Object>();

    public Map<String, Object> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }

    public ErrorResult() {

    }

}
