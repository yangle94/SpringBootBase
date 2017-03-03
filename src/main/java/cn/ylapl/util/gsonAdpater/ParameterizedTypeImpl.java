/**
 * Company
 * Copyright (C) 2004-2016 All Rights Reserved.
 */
package cn.ylapl.util.gsonAdpater;

import java.lang.reflect.Type;

/**
 * @author yangle
 * @version $Id ParameterizedTypeImpl.java, v 0.1 2016-11-07 下午5:22 yangle Exp $$
 */
public class ParameterizedTypeImpl implements MyParameterizedType {
    private final Class raw;
    private final Type[] args;
    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }
    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }
    @Override
    public Type getRawType() {
        return raw;
    }
    @Override
    public Type getOwnerType() {return null;}
}