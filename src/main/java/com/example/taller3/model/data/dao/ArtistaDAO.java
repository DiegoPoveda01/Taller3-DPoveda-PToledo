package com.example.taller3.model.data.dao;

import com.example.taller3.model.Artista;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ArtistaDAO {
    public void agregarArtista(DSLContext query, Artista artista) {
            Table tablaArtista= table(name("Artista"));
            Field[] columnas = tablaArtista.fields("nombre","genero");
            query.insertInto(tablaArtista, columnas[0], columnas[1])
                    .values(artista.getNombre(),artista.getGenero())
                    .execute();
    }
}
