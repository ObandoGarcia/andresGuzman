package com.obandowebApp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print(" <head>");
        out.print("     <meta charset=\"UTF-8\">");
        out.print("     <title>Hola mundo Servlet!</title>");
        out.print(" </head>");
        out.print("<body>");
        out.print("     <h1>Hola mundo desde un servlet Java!</h1>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
