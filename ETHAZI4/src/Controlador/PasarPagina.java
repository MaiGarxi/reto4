
package Controlador;

import Modelo.reserva;
import Vista.Actualizar;
import Vista.Bienvenida;
import Vista.Despedida;
import Vista.Destino;
import Vista.Lista;
import Vista.Login;
import Vista.NoRegistrado;
import Vista.Pago;
import java.sql.SQLException;
import java.util.ArrayList;


public class PasarPagina{
    
    public static Bienvenida obj1;
    public static Login obj2; 
    public static Destino obj3;
    public static Actualizar obj4; 
    public static NoRegistrado obj5; 
    public static Lista obj6; 
    public static Pago obj7;
    public static Despedida obj8;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A BIENVENIDA
    public void Bienvenida(){
        //SE CREA EL OBJ DE LA CLASE BIENVENIDA
        obj1= new Bienvenida();
        obj1.setVisible(true); 
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A LOGIN
    public void Login(){
        //SE CREA EL OBJ DE LA CLASE LOGIN   
        obj2= new Login();
        obj2.setVisible(true); 
    } 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A Destino
    public void LoginaDestino(){
        //SE CREA EL OBJ DE LA CLASE DESTINO   
        obj3= new Destino();
        obj3.setVisible(true); 
        obj2.setVisible(false);
    } 
    public void DestinoaLogin(){
        obj2.setVisible(true); 
        obj3.setVisible(false);
    } 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A ACTUALIZAR
    public void LoginaActualizar(){
        //SE CREA EL OBJ DE LA CLASE ACTUALIZAR
        obj4= new Actualizar();
        obj4.setVisible(true);
        obj2.setVisible(false);
    } 
    public void ActualizaraLogin(){
        obj2.setVisible(true);
        obj4.setVisible(false);
    } 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A NUEVO USUARIO
    public void LoginaNew(){
        //SE CREA EL OBJ DE LA CLASE NUEVO USUARIO
        obj5= new NoRegistrado();
        obj5.setVisible(true);
        obj2.setVisible(false);
    } 
    public void NewaLogin(){
        //SE CREA EL OBJ DE LA CLASE NUEVO USUARIO
        obj2.setVisible(true);
        obj5.setVisible(false);
    } 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A LISTA
    public void DestinoaLista(String localidad) throws SQLException {
        //SE CREA EL OBJ DE LA CLASE LISTA
        obj6= new Lista(localidad);
        obj6.setVisible(true);
        obj3.setVisible(false);
    }  
    public void ListaaDestino() {
        obj3.setVisible(true);
        obj6.setVisible(false);
    }  
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A PAGO
    public void ListaaPago(ArrayList<reserva>reservas){
        //SE CREA EL OBJ DE LA CLASE PAGO
        obj7= new Pago(reservas);
        obj7.setVisible(true); 
        obj6.setVisible(false);
    }  
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FUNCION PARA PASAR A DESPEDIDA
    public void classPagoaDespedida(){
        //SE CREA EL OBJ DE LA CLASE DESPEDIDA
        obj8= new Despedida();
        obj8.setVisible(true); 
    }   
}
