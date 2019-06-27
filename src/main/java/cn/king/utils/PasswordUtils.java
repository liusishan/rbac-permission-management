package cn.king.utils;

import java.security.MessageDigest;
import java.util.UUID;

/**
 *  这是密码工具类
 *
 * @author zsm@shuyuntu.com
 */
public class PasswordUtils {

    /**
     * 获取加密盐
     *
     * @return 20位的随机字符串
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().
                replaceAll("-", "").substring(0, 20);
    }

    /**
     * @author: wcj@king.cn
     * @createTime: 2019/6/24 21:00
     * @param: [password]
     * @return: java.lang.String
     * @description: MD5加密循环两次
     */
    public static String passwordEncode(String password) {
        return MD5Encode(MD5Encode(password));
    }

    public static String MD5Encode(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
