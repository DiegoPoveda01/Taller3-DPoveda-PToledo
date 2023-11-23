package com.example.taller3.model.data.dao;
import com.example.taller3.model.Entrada;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class EntradaDAO {
    public void agregarEntrada(DSLContext query, Entrada entrada) {
            Table tablaEntrada= table(name("Entrada"));
            Field[] columnas = tablaEntrada.fields("tipo","precio","disponible");
            query.insertInto(tablaEntrada, columnas[0], columnas[1],columnas[2])
                    .values(entrada.getTipo(),entrada.getPrecio(),entrada.isDisponible())
                    .execute();
    }
}
