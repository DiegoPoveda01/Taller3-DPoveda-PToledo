package com.example.taller3.controller;

import com.example.taller3.model.EventoMusical;
import com.example.taller3.model.data.DBGenerator;
import com.example.taller3.model.data.dao.EventoMusicalDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "eliminarEventoServlet", value = "/CancelarEventoServlet")
public class EliminarEventoServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GBMEventsDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/cancelarEventoMusical.jsp");
        //envía la respuesta
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/cancelacionEventoNoValida.jsp");

        String nombreParameter = req.getParameter("nombre");
        String fechaParameter = req.getParameter("fecha");
        String lugarParameter = req.getParameter("lugar");
        String artistasParameter = req.getParameter("nombre_artistas");

        if (nombreParameter != null && fechaParameter != null && lugarParameter != null && artistasParameter != null) {

            String nombre = nombreParameter;
            String fecha = fechaParameter;
            String lugar = lugarParameter;
            String artistasInput = artistasParameter;

            EventoMusical evento = new EventoMusical(nombre, fecha, lugar, artistasInput);

            try {
                if (eliminarEvento(evento)) {
                    req.setAttribute("evento", evento);
                    respuesta = req.getRequestDispatcher("/cancelarEventoValido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
     respuesta.forward(req, resp);
    }





    private boolean eliminarEvento(EventoMusical evento) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("GBMEventsDB");
        return EventoMusicalDAO.eliminarEventoMusical(query, evento);
    }


}