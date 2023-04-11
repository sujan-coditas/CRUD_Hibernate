package com.servlet;

import com.entities.ToDo;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        try{
            String title=request.getParameter("title");
            String content=request.getParameter("content");
            int noteId=Integer.parseInt(request.getParameter("noteId").trim());

            Session s=FactoryProvider.getFactory().openSession();
            Transaction tx=s.beginTransaction();

            ToDo note=s.get(ToDo.class, noteId);

            note.setTitle(title);
            note.setContent(content);
            note.setAddedDate(new Date());

            tx.commit();
            s.close();

            resp.sendRedirect("showNotes.jsp");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
