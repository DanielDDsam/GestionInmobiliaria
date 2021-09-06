package com.mycompany.proyectoinmobiliaria;

import java.util.*;


public class Administrador {
    
    private ArrayList<Edificio> listaEdificio; // lista de edificios
    private HashMap<String,Edificio>edificiosId; // Mapa EdificiosId que facilita el buscado de edificio por su clave id   
    private int idEdificio;
    private int idDepartamento;

    public Administrador() {
        listaEdificio = new ArrayList();
        edificiosId = new HashMap();
        idEdificio = 0;
        idDepartamento = 0;
    }
    //metodo privado que agregarEdificios,verifica si ya existe el edificio. si no existe los agrega al mapa edficiosId y listaEdificios
    private void agregarEdificios(Edificio edificio){
        if(edificiosId.containsKey(edificio.getId())){
            System.out.println("Edificio " + edificio.getNombre() + "existe");
            return;
        }
        listaEdificio.add(edificio);
        edificiosId.put(edificio.getId(), edificio);
        System.out.println("El id del edificio  "+edificio.getNombre() + " es: "+edificio.getId());
    }
    
    //metodo2 que recive la instancia de un edificio nuevo y lo envia por parametro al agregarEdicios metodo 1;
    public void agregarEdificios(String nombre, String direccion, String localidad, String arquitecto){
        this.idEdificio = this.idEdificio + 1;
        Edificio nuevoEdificio = new Edificio(String.valueOf(idEdificio),nombre,direccion,localidad,arquitecto);
        this.agregarEdificios(nuevoEdificio);
    }
   
    public void modificarNombreEdificio(String nombre, String idEdificio){
        for (int i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).getId().equals(idEdificio)){
                listaEdificio.get(i).setNombre(nombre);
                edificiosId.get(idEdificio).setNombre(nombre);
            }
        }
    }
    
    public boolean existeDepartamento(String idDepartamento){
        int i;
        for ( i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).existeDepartamento(idDepartamento));
            return true;
        }
        return false;        
    }    

    public void BuscarDepartamento(String idDepartamento){
        if(vacio()){
            System.out.println("No existen departamentos");
        }
        else{
            int i;
            for(i = 0; i<listaEdificio.size();i++){
                listaEdificio.get(i).BuscarDepartamento(idDepartamento);
            }
        }
    }
    
    public void agregarDepartamentoAedificio(String idEdificio,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBaños, int cantidadDormitorios, double metrosCuadrados){
        if(edificiosId.containsKey(idEdificio)){         
            this.idDepartamento = this.idDepartamento + 1;
            Departamento nuevoDepartamento = new Departamento(String.valueOf(idDepartamento),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBaños,cantidadDormitorios,metrosCuadrados);                
            edificiosId.get(idEdificio).agregarDepartamento(String.valueOf(idDepartamento),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBaños,cantidadDormitorios,metrosCuadrados);
            System.out.println("El codigo del departamento "+nuevoDepartamento.getNumeroDpto()+" es: " +idDepartamento);
            return;           
        }
    }
    
    public boolean vacio(){return listaEdificio.isEmpty();}
    
    public boolean existeEdifcio(String idEdificio){return edificiosId.containsKey(idEdificio);}
    
    public void mostrarNombreEdifcios(){
        if(edificiosId.isEmpty()){
            System.out.println("No existen Edificios");
            return;
        }
        int i;
        System.out.println("codigo:     nombre edifciio        direccion          localidad         arquitecto");
        for(i=0; i<listaEdificio.size(); i++){
            System.out.println("   "+listaEdificio.get(i).getId()+":-"+listaEdificio.get(i).getNombre()+"           "+listaEdificio.get(i).getDireccion()+"          "+listaEdificio.get(i).getLocalidad()+"       "+listaEdificio.get(i).getArquitecto()+"    ");
        }
    }
    
    public Edificio  eliminarEdificio(String idEdificio){
        if(!edificiosId.containsKey(idEdificio)){
            System.out.println("No existe un Edificio con el codigo ingresado");
            return null;

        }
        if(listaEdificio.size()<2){
            System.out.println("no existe otro edificio, por lo que todos los datos seran eliminados");
            Edificio edificioEliminado = edificiosId.remove(idEdificio);
            int i;
            for (i = 0; i < listaEdificio.size(); i++) {
                if(listaEdificio.get(i).getId().equals(idEdificio)){
                    listaEdificio.remove(i);
                    break;
                }
            }
                listaEdificio.get(i).eliminarDepartamentos();
                this.idEdificio = 0;
                this.idDepartamento = 0;
                return edificioEliminado;
            
        }
        Edificio edificioEliminado = edificiosId.remove(idEdificio);
        int i;
        for ( i = 0; i < listaEdificio.size(); i++) {
            //se busca edificio en la lista para luego eliminarlo
            if (listaEdificio.get(i).getId().equals(idEdificio)) {
                listaEdificio.remove(i);//lista
                break;
            }
        }
        return edificioEliminado;
    }
 
    public void mostrarTodosLosDepartamentos(){
        if(listaEdificio.isEmpty() ){
            System.out.println("No existen departamentos");
        }
        else{
            for (int i = 0; i < listaEdificio.size(); i++) {
                if(listaEdificio.get(i).getDepartamentos().isEmpty()){
                    System.out.println("La lista de Departamentos está vacía");
                    return;
                }
                    listaEdificio.get(i).mostrarDepartamento();
            }
        }
    }
    
    public ArrayList<Edificio> getListaEdificio() {return listaEdificio;}
    public int getIdEdificio() {return idEdificio;}
    public int getIdDepartamento() {return idDepartamento;}

    public void setIdEdificio(int idEdificio) {this.idEdificio = idEdificio;}
    public void setIdDepartamento(int idDepartamento) {this.idDepartamento = idDepartamento;}
    

}
