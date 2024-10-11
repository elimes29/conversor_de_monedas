package com.aluraone.elimes.modelos;

import java.util.Date;

public class Cambio {
    private Date fecha;
    private double monto;
    private double conversion;
    private String monedaBase;
    private String monedaObjetivo;



    public Cambio(Date fecha, double monto, double conversion, String monedaBase, String monedaObjetivo) {
        this.fecha = fecha;
        this.monto = monto;
        this.conversion = conversion;
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
    }

    public Cambio() {

    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getConversion() {
        return conversion;
    }

    public void setConversion(double conversion) {
        this.conversion = conversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    @Override
    public String toString() {
        return fecha + " : " + monto + " " + monedaBase +
                " equivalen a " + conversion + " " + monedaObjetivo;
    }

}
