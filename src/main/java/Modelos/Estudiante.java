package Modelos;

public class  Estudiante {

    private int matricula;
    private String nombre;
    private String apellido;
    private int telefono;

    public Estudiante(){

    }
    @Override
    public String toString() {
        return String.format("matricula: %d, Nombre: %s, Apellido: %s, Telefono: %d", matricula, nombre, apellido, telefono);
    }

    public Estudiante(int matricula, String nombre, String apellido, int telefono ){

        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido=apellido;
        this.telefono=telefono;

    }

    public int getMatricula(){
        return matricula;
    }

    public int setMatricula(int matricula){
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
    public int getTelefono(){
        return telefono;

    }

    public int getTelefono(int telefono){
        return this.telefono=telefono;

    }



}
