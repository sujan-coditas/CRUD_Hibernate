package com.servlet;
import com.entities.ToDo;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/SaveNoteServ")
public class SaveNoteServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        // content fetch
        String title=req.getParameter("title");
        String content=req.getParameter("content");

        ToDo todo=new ToDo(title,content,new Date());
        Session session= FactoryProvider.getFactory().openSession();
        Transaction tx= session.beginTransaction();
        session.save(todo);
        tx.commit();
        session.close();

        out.println("<h3 style='color: green;'>Data Added Successfully</h3>");
        RequestDispatcher  rd= req.getRequestDispatcher("add_note.jsp");
        rd.include(req,resp);


    }
}
