package com.sc_detail.controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


@WebListener
public class ShoppingCartListener implements HttpSessionBindingListener {

    ServletContext context;
    public ShoppingCartListener() {
    }
    
    public ShoppingCartListener(ServletContext context) {
        this.context = context;
    }

	
    public void valueBound(HttpSessionBindingEvent event)  { 
         System.out.println("123");
         context.log("123");
    }

	
    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	System.out.println("123");
    	context.log("123");
    }
	
}
