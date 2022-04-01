package com.parking.serialization;

public class Plaza {
    private int piso;
    private String zona;
    private int posicion;

    private Coche coche;

    /**
     * @return devuelve el piso
     */
    private int getPiso() { return piso;}

    /**
    * @return devuelve la zona (A, B, C...)
     */
    private String getZona() { return zona;}

    /**
     * @return la posición exacta de la plaza, dentro de la zona y el piso
     */
    private int getPosicion() { return piso;}

    /**
     * @return el coche que tiene reservada la plaza
     */
    protected Coche getCoche() { return coche;}

    /**
     *
     * @param coche el nuevo coche que tiene reservada la plaza
     */
    private void setCoche(Coche coche) { this.coche = coche;}
}
