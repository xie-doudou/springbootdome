package com.xiedou.springbootmybatis;

import com.xiedou.springbootmybatis.utils.ReadUrlUtil;
import org.json.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiedou.springbootmybatis.mapper")//指定扫描接口与映射配置文件
public class SpringbootmybatisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootmybatisApplication.class, args);

        /**
         * 这里调用百度的ip定位api服务
         * 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
         */

        String ip = "113.57.244.100";
        String url = "http://api.map.baidu.com/location/ip?ak=32f38c9491f2da9eb61106aaab1e9739&ip="+ip+"&coor=bd09ll";
        JSONObject json = ReadUrlUtil.readJsonFromUrl(url);
        System.out.println(json.toString());
        System.out.println("经度："+((JSONObject) json.get("content")).getJSONObject("point").get("x"));
        System.out.println("维度："+((JSONObject) json.get("content")).getJSONObject("point").get("y"));
        String city =(String) ((JSONObject) json.get("content")).getJSONObject("address_detail").get("city");
        city = city.replace("市","");
        System.out.println(city);
    }

}
