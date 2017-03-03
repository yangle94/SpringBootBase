package cn.ylapl.util.empty;

import java.util.Collection;

/**
 * 列表等判空
 * Created by Angle on 2017/3/3.
 */
public class CollectionUtil {

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.size() > 0;
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return collection != null && collection.size() == 0;
    }
}
