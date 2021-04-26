package com.ch1.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //得到Session
        HttpSession session = req.getSession();

        //给Session存数据
        session.setAttribute("name",new Person("ch1",21));

        //获取session的ID
        String sessionId = session.getId();

        //判断session是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("session创建成功,sessionId为："+sessionId);
        }else {
            resp.getWriter().write("session已经在服务器中存在了，sessionId为："+sessionId);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
