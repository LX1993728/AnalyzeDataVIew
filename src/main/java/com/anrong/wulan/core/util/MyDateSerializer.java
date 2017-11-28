package com.anrong.wulan.core.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 自定义json序列化格式，将Date格式化为字符串
 * @author Joshua
 *
 */
public class MyDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        String formattedDate = formatter.format(value);  
        jgen.writeString(formattedDate); 		
	}

}
