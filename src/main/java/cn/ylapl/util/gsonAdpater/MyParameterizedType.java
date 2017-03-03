/**
 * Company
 * Copyright (C) 2004-2016 All Rights Reserved.
 */
package cn.ylapl.util.gsonAdpater;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author yangle
 * @version $Id MyParameterizedType.java, v 0.1 2016-11-07 下午5:21 yangle Exp $$
 */
public interface MyParameterizedType extends ParameterizedType {
    // 返回Map<String,User>里的String和User，所以这里返回[String.class,User.clas]
    Type[] getActualTypeArguments();
    // Map<String,User>里的Map,所以返回值是Map.class
    Type getRawType();
    // 用于这个泛型上中包含了内部类的情况,一般返回null
    Type getOwnerType();
}