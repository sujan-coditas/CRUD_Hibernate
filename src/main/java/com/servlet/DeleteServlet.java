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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        try{
            int noteId=Integer.parseInt(req.getParameter("note_id").trim());
            Session s= FactoryProvider.getFactory().openSession();
            Transaction tx=s.beginTransaction();
            ToDo todo=s.get(ToDo.class,noteId);
            s.delete(todo);
           tx.commit();
            s.close();
            resp.sendRedirect("showNotes.jsp");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
