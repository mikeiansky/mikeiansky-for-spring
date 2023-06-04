package com.winson.spring.overview.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.Date;

public class Other {

    public static void testJson(){
        String json = "{\"name\":\"winson\",\"age\":18}";
        Object result = JSONPath.read(json, "$.name");
        System.out.println(result);
//        String hello = JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss");
//        System.out.println(hello);
//        SerializeConfig sc = null;
    }

    public static void main(String[] args) {
        testJson();
    }

}
