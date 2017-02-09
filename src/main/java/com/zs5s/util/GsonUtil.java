/**
 * Company
 * Copyright (C) 2004-2016 All Rights Reserved.
 */
package com.zs5s.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zs5s.util.gsonAdpater.NullStringToEmptyAdapterFactory;
import com.zs5s.util.gsonAdpater.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 已解决Gson:
 *      1.时间格式化问题，
 *      2.String转换时将null转换为"null"字符串问题。转换为了''空字符串
 *
 * @author yangle
 * @version $Id GsonUtil.java, v 0.1 2016-12-01 下午2:43 yangle Exp $$
 */
public class GsonUtil {
    public static Gson gson;

    static {
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));
        gb.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory());
        gb.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        gson = gb.create();
    }

    /**
     * 将json字符串转换为HashMap
     * @param json
     * @return
     */
    public static HashMap<String,String> getMap(String json) {
        HashMap<String,String> map ;
        map = gson.fromJson(json, new TypeToken<HashMap<String,String>>() {}.getType());
        return map;
    }

    /**
     * 将对象转换成json字符串
     * @param t
     * @param <T>
     * @return
     */
    public static <T>String toJson(T t) {
        return gson.toJson(t);
    }

    /**
     * 只能用于Zs5sRpcResult包裹的对象，对象通过json转换(只能用于object为对象时)，
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Zs5sRpcResult<T> getObject(String jsonStr,Class<T> clazz) {

        Type type = new ParameterizedTypeImpl(Zs5sRpcResult.class, new Class[]{clazz});
        return gson.fromJson(jsonStr, type);
    }

    /**
     * 只能用于Zs5sRpcResult包裹的对象，对象通过json转换(只能用于object为数组时)
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Zs5sRpcResult<List<T>> getObjectList(String jsonStr, Class<T> clazz) {

        // 生成List<T> 中的 List<T>seleniumProperties
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        // 根据List<T>生成完整的Result<List<T>>
        Type type = new ParameterizedTypeImpl(Zs5sRpcResult.class, new Type[]{listType});
        return gson.fromJson(jsonStr, type);
    }

    public static JsonObject toJsonObj(String str){
        return new JsonObject().getAsJsonObject(str);
    }

}