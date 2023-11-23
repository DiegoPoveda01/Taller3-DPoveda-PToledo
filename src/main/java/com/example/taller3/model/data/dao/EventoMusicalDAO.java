package com.example.taller3.model.data.dao;

import com.example.taller3.model.Artista;
import com.example.taller3.model.EventoMusical;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.Record;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class EventoMusicalDAO {
    public static void agregarEventoMusical(DSLContext query, EventoMusical eventoMusical) {
            Table tablaEvento= table(name("Evento"));
            Field[] columnas = tablaEvento.fields("nombre","fecha","lugar","nombre_artistas");
            query.insertInto(tablaEvento, columnas[0], columnas[1],columnas[2],columnas[3])
                    .values(eventoMusical.getNombre(),eventoMusical.getFecha(),eventoMusical.getLugar(),eventoMusical.getArtistas())
                    .execute();
    }
    public static boolean eliminarEventoMusical(DSLContext query, EventoMusical eventoMusical) {
        String nombreEvento=eventoMusical.getNombre();
        int result=0;
        try{
            result=query.deleteFrom(
                            DSL.table("Libros"))
                    .where(DSL.field("nombre").eq(nombreEvento))
                    .execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return result==1;
    }
    public static List obtenerEvento(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Evento")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaEventos(resultados);
    }
    private static List<EventoMusical> obtenerListaEventos(Result<Record> resultados) {
        List<EventoMusical> eventos = new ArrayList<>();

        for (Record record : resultados) {
            String nombre = record.getValue(DSL.field("nombre", String.class));
            String fecha = record.getValue(DSL.field("fecha", String.class));
            String lugar = record.getValue(DSL.field("lugar", String.class));
            String artistas = record.getValue(DSL.field("nombre_artistas", String.class));


            eventos.add(new EventoMusical(nombre, fecha, lugar, artistas));
        }

        return eventos;
    }
}
