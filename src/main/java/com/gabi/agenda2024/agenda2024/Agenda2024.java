/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gabi.agenda2024.agenda2024;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author alu15d
 */
public class Agenda2024 {
    
    ArrayList<Contacto> contactos;
    
    public Agenda2024(){
        contactos = new ArrayList();
    }

    
    public static void main(String[] args) { 
        
        Agenda2024 agenda = new Agenda2024();
        agenda.cargaDatos();
        agenda.mainMenu();
    }
    
    
    /**
     * Se crea este método a modo de menú principal.
     */
    public void mainMenu(){
        
        Scanner sc=new Scanner (System.in);
        LocalDate hoy = LocalDate.now();
        
        System.out.println("Hola! Bienvenido al ejercicio de POO.\n"
            + "Para practicar, hemos creado una agenda de contactos.\n\n");
        
        int option;
        do {
            System.out.println("""
                        __________________________________________________________________________________________________________

                                                                       Menu Principal
                        __________________________________________________________________________________________________________
                        
                        Por favor, pulsa alguna de las siguientes opciones:
                               
                                - 1 Para agregar un nuevo contacto.
                                - 2 Para consultar la agenda.
                                - 3 Para modificar un contacto.
                                - 4 Para eliminar un contacto.
                                - 5 Para consultar los cumples cercanos.

                                - 0 Para cerrar la aplicacion.
                                                                                                                                    """);
            option = sc.nextInt();
            switch (option){

                case 1:{
                    añadirContacto();
                    break;
                }
                case 2:{
                    listaContactos();
                    break;
                }
                case 3:{
                    modificarContacto();
                    break;
                }
                case 4:{
                    borrarContacto();
                    break;
                }
                case 5:{
                    listaCumple();
                    break;
                }
                case 0:{
                    System.out.println("\n\n                            Gracias por probar mi aplicacion!                                    \n"
                        + "_________________________________________________________________________________________________\n"
                        + "_________________________________________________________________________________________________\n\n"
                        + "               #   #   #   ##### #####   #       #     #   # #####  ####  ###   #                \n"
                        + "               #   #  # #  #       #    # #      #     #   # #     #     #   #  #                \n"
                        + "               ##### #   # #####   #   #   #     #     #   # ####  #  ## #   #  #                \n"
                        + "               #   # #####     #   #   #####     #     #   # #     #   # #   #                   \n"
                        + "               #   # #   # #####   #   #   #     #####  ###  #####  ###   ###   #                \n"
                        + "_________________________________________________________________________________________________\n"
                        + "_________________________________________________________________________________________________\n\n");
                    break;
                }
                default :{
                    System.out.println("Por favor, introduzca una opcion valida");   
                }
            }
        } while (option != 0);
        sc.close();
    }

    
    /**
     * Se crea este método para inicializar los datos predeterminados de la agenda.
     */
    public void cargaDatos(){
        contactos.add(new Contacto("Ana","666666000","ana@hotmail.com ",LocalDate.parse("2000-01-01")));
        contactos.add(new Contacto("Pepe","666666111","pepe@hotmail.com",LocalDate.parse("2001-01-01")));
        contactos.add(new Contacto("Eva","666666222","eva@hotmail.com ", LocalDate.parse("2002-03-01")));
        contactos.add(new Contacto("Julia","666666333","julia@hotmail.com", LocalDate.parse("2003-03-02")));
        contactos.add(new Contacto("Luis","666666444","luis@hotmail.com", LocalDate.parse("2004-04-04")));
        contactos.add(new Contacto("Bea","666666555","bea@hotmail.com ", LocalDate.parse("2005-05-05")));
        contactos.add(new Contacto("Lucas","666666666","lucas@hotmail.com", LocalDate.parse("2006-06-06")));
        contactos.add(new Contacto("Olivia","666666777","olivia@hotmail.com", LocalDate.parse("2007-02-27")));
        contactos.add(new Contacto("Tomas","666666888","tomas@hotmail.com", LocalDate.parse("2008-03-08")));
        contactos.add(new Contacto("Marta","666666999","marta@hotmail.com", LocalDate.parse("2009-03-09")));
    }
 
    
    /**
     * Se crea este método para añadir contactos nuevos a la agenda.
     */
    public void añadirContacto(){
        String nombre, telefono, email, fechaNac;
        Scanner sc=new Scanner (System.in);

        System.out.println("""
                           __________________________________________________________________________________________________________
                           
                                                                         Nuevo Contacto
                           __________________________________________________________________________________________________________""");
                
        System.out.println("Nombre: ");
        nombre=sc.nextLine();
        
        System.out.println("Telefono:");
        telefono=sc.nextLine();
             
        System.out.println("Email:");
        email=sc.nextLine();
        
        System.out.println("Fecha de nacimiento: (YYYY-MM-DD)");
        fechaNac=sc.nextLine();
        
        Contacto nuevoContacto = new Contacto(nombre, telefono,email, LocalDate.parse(fechaNac));
        contactos.add(nuevoContacto);
        
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
            + "El Contacto " + nuevoContacto.getNombre()+ " se ha agregado correctamente.\n"
            + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
    }

    
    /**
     * Se crea este método para mostrar los contactos guardados.
     */
    public void listaContactos() {
        
        System.out.println("""
                           __________________________________________________________________________________________________________
                           
                                                                         Lista de Contactos
                           __________________________________________________________________________________________________________""");
        
        Collections.sort(contactos);
        //Para cada ""Contacto"" ""contacto"(o "i", "c", o "x". Es como el "int i" del otro bucle for.) en el arraylist ""contactos""...
        for (Contacto contacto : contactos) {
            System.out.println("_______________________________________________________________________________\n" 
                + "Nombre: " + contacto.getNombre()+ " \n" 
                + "Telefono: " + contacto.getTelefono() + " \n" 
                + "Email: " + contacto.getEmail() + " \n" 
                + "Fecha de nacimiento: " + contacto.getFechaNac() + "\n"
                + "_______________________________________________________________________________");
        }
    }

    
    /**
     * Se crea este método para modificar un contacto existente.
     */
    public void modificarContacto() {
        
        System.out.println("""
                           __________________________________________________________________________________________________________
                           
                                                                         Editar Contacto
                           __________________________________________________________________________________________________________""");
        
        Scanner sc=new Scanner (System.in);
        String contact;
        int contactPos = -1;
        boolean contactExist = false;
        do {
            System.out.println("Escribe el contacto a editar.\nEsta es su agenda:");

            for (Contacto contacto : contactos){
                System.out.println("    - " + contacto.getNombre());
            }
            contact = new String(sc.nextLine());
            contactPos = buscaContacto(contact);
            //System.out.println(contactPos);
            
            if(contactPos==-1){
                System.out.println("Por favor, introduzca un nombre de su agenda.");
            }
            if (contactPos!=-1){
                contactExist = true;
            }
        } while (contactExist = false);

        
        System.out.println("""
                           Por favor, indicque el valor a modificar.
                                - 1. Nombre.
                                - 2. Telefono.
                                - 3. Correo Electronico.""");
        int option;
        option = sc.nextInt();
        sc.nextLine();
        switch(option){
            case 1 :{
                System.out.println("Introduzca el nuevo nombre:");
                String nuevoNombre = new String(sc.nextLine());
                contactos.get(contactPos).setNombre(nuevoNombre);
                break;
            }
            case 2 :{
                System.out.println("Introduzca el nuevo telefono:");
                String nuevoNumero = new String(sc.nextLine());
                contactos.get(contactPos).setTelefono(nuevoNumero);
                break;
            }
            case 3 :{
                System.out.println("Introduzca el nuevo correo electronico:");
                String nuevoCorreo = new String(sc.nextLine());
                contactos.get(contactPos).setEmail(nuevoCorreo);
                break;
            }
            default:{
                System.out.println("Introduzca una opcion valida.");
            }
        } 
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
            + "                 El contacto se ha modificado a " + contactos.get(contactPos).getNombre() +" correctamente.\n"
            + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
    }

    
    /**
     * Se crea este método para eliminar un contacto
     */
    public void borrarContacto() {
        
        System.out.println("""
                           __________________________________________________________________________________________________________
                           
                                                                        Eliminar Contacto
                           __________________________________________________________________________________________________________""");
        
        Scanner sc = new Scanner (System.in);
        System.out.println("Introduzca el contacto que desea eliminar.\nEsta es su agenda:");

            for (Contacto contacto : contactos){
                System.out.println("    - " + contacto.getNombre());
            }
        String nombre = sc.nextLine();
        
        int contactPos = buscaContacto(nombre);
        
        if (contactPos == -1){
            System.out.println("Por favor, introduca un nombre guardado en su agenda:");
        }else{
            String deletedName = contactos.get(contactPos).getNombre();
            contactos.remove(contactPos);
            System.out.println("El contacto " + deletedName + " ha sido eliminado satisfactoriamente.\n");
        }    
    }
    
    
    /**
     * Se crea este método para encontrar en un arrayList un contacto espcífico.
     * @param nombre
     * @return 
     */
    public int buscaContacto (String nombre){
        
        int pos=-1;

        for (int i = 0; i < contactos.size(); i++) {
            if(nombre.equalsIgnoreCase(contactos.get(i).getNombre())){
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    
    /**
     * Se crea este método para listar los cumpleaños entre hoy y el lapso de tiempo que se escoja.
     */
    public void listaCumple(){
        Scanner sc = new Scanner(System.in);
        int dias;
        System.out.println("Hasta cuantos dias quieres consultar cumples?\n");
        dias = sc.nextInt();
        
        //LocalDate hoy = LocalDate.now();
        LocalDate hoy = LocalDate.parse("2024-04-01");
        int diaHoy = hoy.getDayOfYear();

        int diaConsultar = diaHoy + dias;
        
        System.out.println("_______________________________________________________________________________\n"
            + "Entre hoy y el " + hoy.plusDays(dias) + " son los cumples de:");
        
        //System.out.println("\n\nDia hoy no modificado: "+diaHoy);
        //System.out.println("Dia consultar no modificado: " + diaConsultar+"\n");
        
        if(hoy.isLeapYear() && diaConsultar >= 59 && diaConsultar <= 60){
            //diaHoy = diaHoy-1;
            diaConsultar = diaConsultar-1;
            
            //System.out.println("Dia hoy modificado: " + diaHoy);
            //System.out.println("Dia consultar modificado: " + diaConsultar);
        }
        
        for(Contacto contacto:contactos){
            if (contacto.getFechaNac().getDayOfYear() >= diaHoy && contacto.getFechaNac().getDayOfYear() <= diaConsultar) {
                System.out.println("    - "+ contacto.getNombre() + "(" + contacto.getFechaNac() + ").");
                System.out.println("\n\nNumero nacimiento contacto: "+contacto.getFechaNac().getDayOfYear()+"\n"+"diaHoy: "+diaHoy+"\ndiaConsultar: "+diaConsultar);
                System.out.println(hoy.getMonthValue());
            }
        }
        
        System.out.println("_______________________________________________________________________________\n\n"); 
    }
}
