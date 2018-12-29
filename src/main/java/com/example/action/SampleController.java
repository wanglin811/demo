package com.example.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/ctr")
@ConfigurationProperties(prefix="mymap")
public class SampleController
{
    @RequestMapping("/getStr")
    @ResponseBody
    String home(){
        return "Hello World"+width;
    }
    private String width;
    public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	@RequestMapping("/info")
    @ResponseBody
    public Map<String,String> getInfo(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "jack");
        return map;
    }
    
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
    public static void main(String[] args)
    {
    	System.out.println("123");
        SpringApplication.run(SampleController.class,args);
    }
}