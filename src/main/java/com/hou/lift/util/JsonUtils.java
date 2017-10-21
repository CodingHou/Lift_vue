package com.hou.lift.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sigon
 * Date: 14-12-3
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtils {
    public static String toJson(Object o){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        return gson.toJson(o);
    }
    public static <T> T fromJson(String json, Class<T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
    public static Object fromJson(String json, Type type){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        return gson.fromJson(json, type);
    }
	public static Map<String,Object> toMap(String json){
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String,Object>>(){}.getType();
		Map<String,Object> map = gson.fromJson(json,type);
		return map;
	}

    public static HashMap<String, Object> toHashMap(Object object)
    {
        HashMap<String, Object> data = new HashMap<String, Object>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator it = jsonObject.keys();
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext())
        {
            String key = String.valueOf(it.next());
            Object value = jsonObject.get(key);
            data.put(key, value);
        }
        return data;
    }
}
