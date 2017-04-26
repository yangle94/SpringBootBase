package cn.ylapl.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * jackson工具类
 * Created by Angle on 2017/4/15.
 */
public class JacksonUtils {

    private static final class ObjectMapperBuild {

        private static final ObjectMapper mapper = new ObjectMapper();

        static {
            mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);//设置可用单引号
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);//设置字段可以不用双引号包括
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));//设置时间格式
        }
        public static ObjectMapper getInstance() {
            return mapper;
        }
    }

    /**
     * 实体对象转换成Json字符串
     * @param t 实体对象T
     * @return T
     */
    public  static <T> String objectToJson(T t){
        try {
            return ObjectMapperBuild.getInstance().writeValueAsString(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Json字符串转换成实体对象
     * @param json
     * @param clazz 实体对象所属类Class
     * @return
     */
    public  static <T> T jsonToObject(String json, Class<T> clazz){
        try {
            return ObjectMapperBuild.getInstance().readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Json字符串转换成List
     * @param json
     * @param clazz 实体对象所属类Class
     * @return
     */
    public  static <T> T jsonToList(String json, Class<T> clazz){
        try {
            JavaType javaType = ObjectMapperBuild.getInstance().getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return ObjectMapperBuild.getInstance().readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Json字符串转换成List
     * @param json
     * @param typeReference TypeReference<T>
     * <p>
     *  <pre>new TypeReference<List<User>>() {}</pre>
     * </p>
     * @return
     */
    public static <T> T jsonToList(String json, TypeReference<T> typeReference){
        try {
            return ObjectMapperBuild.getInstance().readValue(json, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  美化输出
     * @param t
     * @return
     */
    public  static <T> String console(T t){
        String json = "";
        try {
            json = ObjectMapperBuild.getInstance().writerWithDefaultPrettyPrinter().writeValueAsString(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
