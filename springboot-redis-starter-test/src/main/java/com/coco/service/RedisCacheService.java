package com.coco.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description: redis service
 * @author zhangxiaoxun
 * @date 2019/8/20 14:30
 * @Version: V1.0
 *
 **/
public interface RedisCacheService {


    /**
     * 根据缓存key获取值
     */
    Object getCache(Serializable cacheKey);


    /**
     * 设置缓存数据的key-value，并设置失效时间，单位为秒
     * @param cacheKey
     * @param objValue
     * @param expiration
     * @return
     */
    boolean putCache(Serializable cacheKey, Object objValue, int expiration);

    /**
     * 清除缓存
     * @param cacheKey
     */
    void removeCache(Serializable cacheKey);


    /**
     * 向指定list集合中添加对象，在list尾部添加对象
     * @param cacheKey
     * @param objValue
     * @return
     */
    boolean putListCache(Serializable cacheKey, Object objValue);


    /**
     * 向指定list集合中添加对象，并指定位置坐标
     * @param cacheKey
     * @param objValue
     * @param index
     * @return
     */
    boolean putListCache(Serializable cacheKey, Object objValue,
                         int index);

    /**
     * 根据坐标，返回一段集合
     *
     * @param cacheKey
     * @param start
     *            起始坐标 头部为0
     * @param end
     *            结束坐标 尾部为-1
     * @return
     */
    public List<Object> getListCache(Serializable cacheKey, int start, int end);


    /**
     * 返回结合
     * @param cacheKey
     * @return
     */
    List<Object> getListCache(Serializable cacheKey);

    /**
     * 裁剪list集合
     *
     * @param cacheKey
     * @param start
     *            起始坐标
     * @param end
     *            结束坐标
     * @return
     */
    boolean trimListCache(Serializable cacheKey, int start, int end);


    /**
     * 添加map集合
     * @param cacheKey
     * @param map
     * @return
     */
    boolean putMapCache(Serializable cacheKey, Map<Object, Object> map);

    /**
     * map中的键值
     * @param cacheKey
     * @param mapKey
     * @return
     */
    boolean deleteMapCache(Serializable cacheKey, Serializable mapKey);


    /**
     * 获取map中的值
     * @param cacheKey
     * @param mapKey
     * @return
     */
    Object getMapValueCache(Serializable cacheKey, Serializable mapKey);


    /**
     * 缓存key是否存在
     * @param cacheKey
     * @return
     */
    boolean exists(Serializable cacheKey);

    /**
     * 设置过期时间
     * @param cacheKey
     * @param expiration
     * @return
     */
    boolean setKeyExpire(String cacheKey, int expiration);

}
