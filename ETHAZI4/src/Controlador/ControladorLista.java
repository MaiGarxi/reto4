package Controlador;

import Modelo.Alojamiento;
import Modelo.Cama;
import Modelo.Hotel;
import Modelo.Ubicacion;
import Modelo.Usuario;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ControladorLista {
    public double preci=0.0;
    public ControladorLista(JButton reservar, JButton anterior, JComboBox<String>Destinos,String localidad, String Alojamiento, JLabel precio,JList<String> jList1,JLabel error,ArrayList<Usuario> Users,JLabel name,JButton exit,String entradas, String salidas,JTable jTable1,ArrayList<ArrayList> patron,int dias) {
          
        /*Apenas de inicia el controlador*/
      
        String[] columnas = {"Tipo de Habitación/es", "Niños","Capacidad"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        jTable1.setModel(modelo);
        error.setVisible(false);
        name.setText(Users.get(0).nombre);
        Alojamiento aux = new Alojamiento();
        aux.obtener_alojamiento(jList1,localidad,Alojamiento);
        Ubicacion ubi = new Ubicacion();
        ubi.obtener_destinos(Destinos);
        Hotel hot = new Hotel(); //hay que modificar esto
        
       
        
        /*TAMAÑO DE LAS COLUMNAS*/
          jTable1.getTableHeader().setOpaque(false);
                 jTable1.getTableHeader().setBackground(new Color(32,136,203));
                          jTable1.getTableHeader().setForeground(new Color(255,255,255));
                                  TableColumnModel columnModel= jTable1.getColumnModel();
                                  columnModel.getColumn(0).setPreferredWidth(300);
                                  columnModel.getColumn(1).setPreferredWidth(50);
                                  columnModel.getColumn(2).setPreferredWidth(70);
        /*TAMAÑO DE LAS COLUMNAS*/
        
            /*Apenas de inicia el controlador*/    
            
            
           /*Seleccionar Hotel*/
        jList1.addListSelectionListener((ListSelectionEvent evt) -> {           
            error.setVisible(false);
            modelo.setRowCount(0);
            Cama cama = new Cama();
            cama.grande_agregar(patron,modelo);
            precio.setText(String.valueOf(" "));
        });
            /*Seleccionar Hotel*/
            
            
           /*Seleccionar Habitaciòn*/
           
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            double preciox=0.0;
            Cama cama = new Cama();
            preciox= (cama.obtener_precio_reserva(patron.get(jTable1.getSelectedRow())));
            preci= preciox*dias;
            precio.setText(String.valueOf(preci+" € Por "+dias+" Noches"));
        }});
           
           
            /*Seleccionar Habitación*/
                        
                /*Reservar*/
        reservar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {            
            
            if(jList1.isSelectionEmpty())
            {
                error.setText(" Debes Escoger un Alojamiento");
                
                error.setVisible(true);                
            }
            else if(jTable1.getSelectedRow()==-1)
            {
                error.setText("Debes Escoger Una Reserva");
                error.setVisible(true);  
            
            }
            else if(jTable1.getSelectedRow()>-1){
                PasarPagina pasar= new PasarPagina(); 
                pasar.ListaaPago(hot.Crear_array(jList1,entradas, salidas,preci),Users,preci);   
            }            
            }
            });  
        
                /*Reservar*/  
                
            /*Cambiar Destinos*/
             
        Destinos.addActionListener ((ActionEvent e) -> {
            String localidad1 = (String) Destinos.getSelectedItem();
            Destinos.removeAllItems();
            aux.obtener_alojamiento(jList1, localidad1, Alojamiento);
            ubi.obtener_destinos(Destinos,localidad1);
            modelo.setRowCount(0); 
            precio.setText(String.valueOf(" "));
        });
            /*Cambiar Destinos*/
       
           /*Eventos 
        */           
        anterior.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { 
                PasarPagina pasar= new PasarPagina(); 
                pasar.ListaaDestino();
            }
            });  
        
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {          
                PasarPagina pasar= new PasarPagina(); 
                pasar.ListaaBienvenida();
            }
        }); 
    }
}