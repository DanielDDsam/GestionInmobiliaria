/*
Autores:
    Daniel Duran;
    José Eduardo Olivar;
    Paula Vargas
*/

package com.mycompany.proyectoinmobiliaria;

import java.io.*;


public class GestionInmobiliaria {
    static Administrador administrador = new Administrador();//Contiene informacion de todos los edificios se hizo como variable global
    
    public static void main(String[] args) throws IOException{
        BufferedReader lectura = new BufferedReader(new InputStreamReader( System.in ));
        boolean mostrarMenu = true;
        
        System.out.println("Bienvenido, ingrese la opcion que desee utilizar");
        
        while(mostrarMenu){
            System.out.println("(1) Agregar Edificio");
            System.out.println("(2) Agregar Departamento");
            System.out.println("(3) Agregar Edifcios predeterminados");
            System.out.println("(4) Agregar Departamentos predeterminados");
            System.out.println("(5) Mostrar listado de Edificios");
            System.out.println("(6) Mostrar todos los departamentos");
            System.out.println("(7) Eliminar Edificio");
            System.out.println("(8) Buscar Departamento");
            System.out.println("(9) Modificar nombre de Edificio");
            
            System.out.println("presione x para salir");
            
            String eleccion = lectura.readLine();
            
            switch(eleccion){
                case "1":
                    agregarEdifcio();
                    break;
                case "2":
                    agregarDepartamento();
                    break;
                case "3":
                    llenadoDeEdifcios();
                    break;
                case "4":
                    llenadoDeDepartamentos();
                    break;
                case "5":
                    mostrarListadoDeEdifcios();
                    break;
                case "6":
                    mostrarTodosLosDepartamentos();   
                    break;
                case "7":
                    eliminarEdificio();
                    break;
                case "8":
                    buscarDepartamento();
                    break;
                case "9":
                    modificarNombreEdificio();
                    break;                    
                case "x":
                    System.out.println("Nos vemos!");
                    mostrarMenu = false;
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");
                    break;
            }
        }
        
    }
    /*metodo para agregar edificios por consola*/
    public static void agregarEdifcio()throws IOException{
        BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
        
        System.out.println("Ingrese nombre del edificio");
        String nombreEdificio = lectura.readLine();
        System.out.println("Ingrese direccion del edificio");
        String direccionEdificio = lectura.readLine();   
        System.out.println("Ingrese localidad del edificio");
        String localidadEdificio = lectura.readLine();
        System.out.println("Ingrese arquitecto del edificio");
        String arquitectoEdificio = lectura.readLine();         
        
        administrador.agregarEdificios(nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio);
    }
    
    /* agrega departamentos a edificios*/
    public static void agregarDepartamento() throws IOException{
        /*comprueba si es que hay o no edificios*/
        if(administrador.vacio()){
            System.out.println("No existen edificios, no se agregaran departamentos");
            return;
        }
        
        BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
        /*Por id se le asignan los departamentos al edificio*/
        System.out.println("Ingrese el id del edificio al que pertenece el departamento");
        String idEdificio = lectura.readLine();
        /*Se comprueba que exista el edificio y se le agrega departamento al edificio buscado por id*/
        if(administrador.existeEdifcio(idEdificio)){
            System.out.println("Ingrese numero de piso en el que se encuentra el departamento");
            String numeroPiso = lectura.readLine();        
            System.out.println("Ingrese numero de departamento");
            String numeroDpto = lectura.readLine();     
            System.out.println("Ingrese valor en uf del departamento");
            String valorDpto = lectura.readLine();
            System.out.println("Ingrese orientacion del departamento");
            String orientacion = lectura.readLine();
            System.out.println("Ingrese cantidad de banos del departamento");
            int cantidadBaños = Integer.parseInt(lectura.readLine());
            System.out.println("Ingrese cantidad de dormitorios del departamento");
            int cantidadDormitorios = Integer.parseInt(lectura.readLine());
            System.out.println("Ingrese los metros cuadrados del departamento");
            int metrosCuadrados = Integer.parseInt(lectura.readLine());
            
            administrador.agregarDepartamentoAedificio(idEdificio, numeroPiso, numeroDpto, valorDpto, orientacion, cantidadBaños, cantidadDormitorios, metrosCuadrados);
            return;
        }
        System.out.println("El edifcio ingresado no existe");
    }
    
    /* Lista de departamentos predeterminados*/
    public static void llenadoDeDepartamentos(){
        if(administrador.getListaEdificio().size() >=3){
            
            administrador.agregarDepartamentoAedificio("1", "1","1", "2000UF", "sur", 1, 2, 36);
            administrador.agregarDepartamentoAedificio("1", "1","2", "2000UF", "sur", 1, 2, 36);
            administrador.agregarDepartamentoAedificio("1", "2","3", "2000UF", "norte", 1, 2, 36);
            administrador.agregarDepartamentoAedificio("1", "2","4", "2000UF", "norte", 1, 2, 36);         
            administrador.agregarDepartamentoAedificio("2", "1","1", "3500UF", "sur", 2, 3, 56);
            administrador.agregarDepartamentoAedificio("2", "1","2", "3500UF", "sur", 2, 3, 56);
            administrador.agregarDepartamentoAedificio("2", "2","3", "3500UF", "norte", 2, 3, 56);
            administrador.agregarDepartamentoAedificio("2", "2","4", "3500UF", "norte", 2, 3, 56);
            administrador.agregarDepartamentoAedificio("3", "1","1", "3420UF", "Este", 2, 3, 50);
            administrador.agregarDepartamentoAedificio("3", "1","2", "3420UF", "surOeste", 2, 3, 50);
            administrador.agregarDepartamentoAedificio("3", "2","3", "3420UF", "norEste", 2, 3, 50);
            administrador.agregarDepartamentoAedificio("3", "2","4", "3420UF", "norOeste", 2, 3, 50);
            return;
        }
        System.out.println("Crear primero 3 edificios para acceder a esta opcion");
    }
    
    /*Llenado predeterminado*/
    public static void llenadoDeEdifcios(){
        administrador.agregarEdificios("Viana Miramar","Viana 161","Viña del mar","Roberto Rau");
        administrador.agregarEdificios("LADY","15 norte 242","Viña del mar","Mario Castañeda");
        administrador.agregarEdificios("10 norte","10 norte 655","Viña del mar","Quiroz y Puelma Arquitectos");
    }
    
    /*muestrra la lista de edificios si es que hay*/
    public static void mostrarListadoDeEdifcios() {
        administrador.mostrarNombreEdifcios();
    }
    /*muestra todos los departamentos si es que hay*/
    public static void mostrarTodosLosDepartamentos(){
        administrador.mostrarTodosLosDepartamentos();
    }
    
    
    public static void modificarNombreEdificio()throws IOException{
        if(administrador.vacio()){
            System.out.println("No existen Edificios");
            return;
        }
        BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
        System.out.println("Ingrese id del edificio que quiere modificar su nombre");
        String idEdificio = lectura.readLine();
        System.out.println("Ingrese el nuevo nombre del Edificio");
        String NombreEdificio = lectura.readLine();
        administrador.modificarNombreEdificio(NombreEdificio, idEdificio);
    }
        
    public static void eliminarEdificio()throws IOException{
        if(administrador.vacio()){
            System.out.println("No existen Edificios");
            return;
        }
        BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
        System.out.println("Ingrese id del edificio que quiere eliminar");
        String idEdificio = lectura.readLine();
        administrador.eliminarEdificio(idEdificio);
    }
    
    /*busca el departamento a partir de la id ingresada*/
    public static void buscarDepartamento()throws IOException{
        BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
        System.out.println("Ingrese id del departamento que busca");
        String idDepartamento = lectura.readLine();
        administrador.BuscarDepartamento(idDepartamento);
    }
}    

//prueba 1

    
