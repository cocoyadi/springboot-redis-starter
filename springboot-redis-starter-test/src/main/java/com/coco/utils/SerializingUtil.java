package com.coco.utils;

import java.io.*;

/**
 * @Description: 序列化工具
 * @author zhangxiaoxun
 * @date 2019/8/20 14:35
 * @Version: V1.0
 *
 **/
public class SerializingUtil {

    /**
     * 对象转字节数组
     * @param cacheKey
     * @return
     * @throws IOException
     */
    public static byte[] serialize(Object cacheKey) throws IOException {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(cacheKey);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 字节数组转对象
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }
}
