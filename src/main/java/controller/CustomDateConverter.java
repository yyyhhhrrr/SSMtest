package controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-01-21 13:32
 * @Description: ${Description}
 */
public class CustomDateConverter implements Converter<String, Date> {
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(s);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
