package com.youtochi.qtienditas;

/**
 * Created by 813743 on 27/11/2017.
 */



import java.io.Serializable;


public class DataDescriptorHistorial implements Serializable {
    private String id;

    private String internalId;
    private String name;
    private String tipo;
    private String negocio;
    private String posLon;
    private String posLat;
    private String precioOriginal;
    private String puntosUtilizados;
    private String montoPagado;
    private String ano;
    private String mes;
    private String dia;
    private String hora;
    private String minuto;
    private String segundo;
    private String imagenDesplegar;
    private String videoDesplegar;

    public DataDescriptorHistorial(String id, String internalId, String name, String tipo, String negocio, String posLon, String posLat, String precioOriginal, String puntosUtilizados, String montoPagado, String ano, String mes, String dia, String hora, String minuto, String segundo, String imagenDesplegar, String videoDesplegar) {
        this.id = id;
        this.internalId = internalId;
        this.name = name;
        this.tipo = tipo;
        this.negocio = negocio;
        this.posLon = posLon;
        this.posLat = posLat;
        this.precioOriginal = precioOriginal;
        this.puntosUtilizados = puntosUtilizados;
        this.montoPagado = montoPagado;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.imagenDesplegar = imagenDesplegar;
        this.videoDesplegar = videoDesplegar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getPosLon() {
        return posLon;
    }

    public void setPosLon(String posLon) {
        this.posLon = posLon;
    }

    public String getPosLat() {
        return posLat;
    }

    public void setPosLat(String posLat) {
        this.posLat = posLat;
    }

    public String getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(String precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public String getPuntosUtilizados() {
        return puntosUtilizados;
    }

    public void setPuntosUtilizados(String puntosUtilizados) {
        this.puntosUtilizados = puntosUtilizados;
    }

    public String getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(String montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getImagenDesplegar() {
        return imagenDesplegar;
    }

    public void setImagenDesplegar(String imagenDesplegar) {
        this.imagenDesplegar = imagenDesplegar;
    }

    public String getVideoDesplegar() {
        return videoDesplegar;
    }

    public void setVideoDesplegar(String videoDesplegar) {
        this.videoDesplegar = videoDesplegar;
    }
}