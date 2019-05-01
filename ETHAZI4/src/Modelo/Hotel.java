
package Modelo;

import static ethazi4.ETHAZI4.consul;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class Hotel {

    protected int cod_hotel,estrellas;
    protected String nombre;   

    public Hotel() {
    }

    public Hotel(int cod_hotel, int estrellas, String nombre) {
        this.cod_hotel = cod_hotel;
        this.estrellas = estrellas;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public ArrayList <Hotel>  buscar_hoteles(String salida,String destino,String entrada)
    {
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
        return hoteles;
    }
    
    public ArrayList <String>  ordenar_destinos(ArrayList <String> Destinos,String localidad)
    {                 
        String auxe;              
        for(int f=0;f<Destinos.size();f++)
        {                 
            if(Destinos.get(f).equals(localidad))
            {
                auxe=Destinos.get(f);
                Destinos.set(f,Destinos.get(0));
                Destinos.set(0,auxe);                    
            }
        }
        return Destinos;       
    } 
       
    public void obtener_destinos(JComboBox<String> destino,String locali)
    {              
        try {
           
            Hotel ex=new Hotel();
            ArrayList<String> Destinos = new ArrayList<String>();
            ResultSet resultado=consul.ConsultaDestino();
              while (resultado.next())
              {                 
                Destinos.add(resultado.getString("Localidad"));
               }
            for (int x=0;Destinos.size()>x;x++)
            {
                destino.addItem(ex.ordenar_destinos(Destinos,locali).get(x));      
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
     public void obtener_destinos(JComboBox<String> destino)
    {
        try {
            destino.removeAllItems();
            
            ResultSet resultado=consul.ConsultaDestino();
            
            while (resultado.next())
            {
                destino.addItem(resultado.getString("Localidad"));
            }      
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void obtener_hoteles(JList<String> hotel,String localidad) 
    {           
        try {
            DefaultListModel listModel;
            listModel = new DefaultListModel();
            hotel.setModel(listModel);
           
            ResultSet resultado=consul.ConsultaHoteles_Nombre(localidad);                
            while (resultado.next()){
                listModel.addElement(resultado.getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No existe ningún Hotel");
        }
    }
    
    public ArrayList<reserva> Crear_array(JList<String> hotel,String fecha1, String fecha2)
    {
        try {
            ArrayList<reserva> hoteles_reserva = new ArrayList<reserva>();
            String Des = (String) hotel.getSelectedValue();            
            ResultSet resultado = consul.hotel_para_reservar(Des);
            for(int x=0;resultado.next();x++)
            {
                reserva reser= new reserva( Integer.parseInt(resultado.getString("Cod_reserva")),Integer.parseInt(resultado.getString("Cod_hotel")),(x+1),100.0,fecha1,fecha2,resultado.getString(Des));
                hoteles_reserva.add(reser);
            } 
            return hoteles_reserva;
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
