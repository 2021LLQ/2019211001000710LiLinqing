package com.LiLinqing.week2.demo;

import com.sun.net.httpserver.HttpContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

//now its just a java class
//extend HttpServlet
public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
            //when client request method is GET - here - inside doGet()
            //we want to send Hello to client
            //we need to writer Hello in response
            //  get writer - java .io
            PrintWriter writer = response.getWriter();
            writer.println("Hello Client !!!");
        }
        public void doPost(HttpServletRequest request, HttpServletResponse response){
    }


}
