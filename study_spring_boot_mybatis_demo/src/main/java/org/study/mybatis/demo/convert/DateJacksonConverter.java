package org.study.mybatis.demo.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateJacksonConverter
 * @Description: 日期处理
 * @Author: lin
 * @Date: 2019/6/19 22:43
 * History:
 * @<version> 1.0
 */
public class DateJacksonConverter extends JsonSerializer<Date> {

    public  static  final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param value       Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
         if(null!=value){
             gen.writeString(FORMAT.format(value));
         }
    }
}
