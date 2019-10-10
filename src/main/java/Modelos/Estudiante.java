package Modelos;

public class  Estudiante {

    private String matricula;
    private String nombre;
    private String apellido;
    private String telefono;


    public Estudiante(){

    }

    /*

    @Override
    public String toString() {
        return String.format("matricula: %s, Nombre: %s, Apellido: %s, Telefono: %s", matricula, nombre, apellido, telefono);
    }


     */

    public Estudiante(String matricula, String nombre, String apellido, String telefono ){

        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido=apellido;
        this.telefono=telefono;

    }

    public Estudiante(String matricula) {
    }

    public String getMatricula(){
        return matricula;
    }

    public String setMatricula(String matricula){
        return this.matricula = matricula;
    }

    public String getNombre(){
        return nombre;

    }
    public String setNombre(String nombre){
        return this.nombre=nombre;

    }

    public String getApellido(){
        return apellido;
    }

    public String setApellido(String apellido){
        return this.apellido=apellido;
    }

    public String getTelefono(){
        return telefono;

    }


    public String setTelefono(String telefono){
        return this.telefono=telefono;
    }



}
