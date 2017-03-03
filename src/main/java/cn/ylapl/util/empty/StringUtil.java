package cn.ylapl.util.empty;

/**
 * String工具类
 * Created by Angle on 2017/3/3.
 */
public class StringUtil {

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    private StringUtil() {
        throw new AssertionError("StringUtil无法被实例化");
    }
}
