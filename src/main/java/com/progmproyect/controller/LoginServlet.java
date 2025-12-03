package com.progmproyect.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        
        // Guardamos el usuario en la SESIÓN (Memoria temporal del navegador)
        HttpSession session = request.getSession();
        session.setAttribute("usuarioLogueado", usuario);
        
        // Redirigimos al menú principal
        response.sendRedirect("menu.jsp");
    }
}
