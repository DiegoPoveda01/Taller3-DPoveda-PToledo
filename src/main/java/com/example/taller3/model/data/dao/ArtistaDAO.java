package com.example.taller3.model.data.dao;

import com.example.taller3.model.Artista;
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

public class ArtistaDAO {
    public static void agregarArtista(DSLContext query, Artista artista) {
            Table tablaArtista= table(name("Artista"));
            Field[] columnas = tablaArtista.fields("nombre","genero");
            query.insertInto(tablaArtista, columnas[0], columnas[1])
                    .values(artista.getNombre(),artista.getGenero())
                    .execute();
    }
    private static List<Artista> obtenerListaArtistas(Result<Record> resultados) {
        List<Artista> artistas = new ArrayList<>();

        for (Record record : resultados) {
            String nombre = record.getValue(DSL.field("nombre", String.class));
            String genero = record.getValue(DSL.field("genero", String.class));
            artistas.add(new Artista(nombre, genero));
        }

        return artistas;
    }
    public static List<Artista> obtenerArtistas(DSLContext query) {
        Result<Record> resultados = query.select().from(table("Artista")).fetch();

        return obtenerListaArtistas(resultados);
    }
    public static List obtenerArtista(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(DSL.table("Artista")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaArtistas(resultados);
    }
}
