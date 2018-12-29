package com.example.action;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PageController {
	   @RequestMapping(value="/index",method=RequestMethod.GET)
	    public String getIndex(){
		   boolean a=true;
	        return "index";
	    }
	   
	   public static void main(String[] args)
	    {
	        SpringApplication.run(PageController.class,args);
	    }
}
