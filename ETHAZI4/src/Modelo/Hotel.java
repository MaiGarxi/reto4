
package Modelo;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Hotel {

    protected int cod_hotel,estrellas,num_habitaciones,num_camas,cp;
    protected String nombre,localidad;



    public Hotel() {
    }

    public Hotel(int cod_hotel, int estrellas, int num_habitaciones, int num_camas, int cp, String nombre, String localidad) {
        this.cod_hotel = cod_hotel;
        this.estrellas = estrellas;
        this.num_habitaciones = num_habitaciones;
        this.num_camas = num_camas;
        this.cp = cp;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public int getCod_hotel() {
        return cod_hotel;
    }

    public void setCod_hotel(int cod_hotel) {
        this.cod_hotel = cod_hotel;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getNum_habitaciones() {
        return num_habitaciones;
    }

    public void setNum_habitaciones(int num_habitaciones) {
        this.num_habitaciones = num_habitaciones;
    }

    public int getNum_camas() {
        return num_camas;
    }

    public void setNum_camas(int num_camas) {
        this.num_camas = num_camas;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public ArrayList <Hotel>  buscar_hoteles(String salida,String destino,String entrada)
    {
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
    return hoteles;
    }
    
       public ArrayList <Hotel>  ordenar_hoteles(ArrayList<Hotel> hoteles)
    {
        
    return hoteles;
    } 
       
       public void obtener_destinos(JComboBox<String> destino)
       {
      /*  conectar con =new conectar();
        Connection reg=con.conexion();
*/       ArrayList<String> Destinos= new ArrayList<String>();
       Destinos.add("Barcelona");
       
                  for(int x=0;Destinos.size()>x;x++)
        {
      destino.addItem(Destinos.get(x));
        
        }
       
       }
    
}
