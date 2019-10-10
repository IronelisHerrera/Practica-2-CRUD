package Modelos;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import sun.font.EAttribute;


import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {
    private Estudiante estu = null;


    public static void main(String[] args) throws IOException {

        port(8080);

        staticFiles.location("/publico");
        String templatePath = new File("").getAbsolutePath();
        System.out.println(templatePath);
        final Configuration config = new Configuration(new Version(2, 3, 0));
        config.setDirectoryForTemplateLoading(new File(templatePath +"/src/main/resources/spark/template/freemarker"));
        config.setDefaultEncoding("UTF-8"); //Renderizar con tildes.
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setLogTemplateExceptions(false);

        ArrayList<Estudiante> ListaDeEstudiantes = new ArrayList<Estudiante>();


        get("/", ((request, response) -> {


            Map<String, Object> attributes = new HashMap<>();

            attributes.put("listadeestudiantes", ListaDeEstudiantes);


            return new FreeMarkerEngine().render(new ModelAndView(attributes, "Home.ftl"));


        }));



        get("/NuevoEstudianteNavegacion", (request, response) -> {

            Template FormAgregarEstudiante = config.getTemplate("NuevoEstudiante.ftl");
            return FormAgregarEstudiante;

        });

        post("/NuevoEstudiante", (request, response) -> {



            String matricula = (request.queryParams("matricula"));
            //System.out.println(matricula);
            String nombre = (request.queryParams("nombre"));
            String apellido = (request.queryParams("apellido"));
            String telefono = (request.queryParams("telefono"));

            ListaDeEstudiantes.add(new Estudiante(matricula, nombre, apellido, telefono));
            response.redirect("/");

            return 1;



        });

        get("/delete/:matricula", (request, response) -> {


            for (Estudiante obj: ListaDeEstudiantes) {

                if(obj.getMatricula().equals(request.params("matricula"))){
                    ListaDeEstudiantes.remove(ListaDeEstudiantes.indexOf(obj));
                    break;


                }

            }


            response.redirect("/");

            return null;
        });
        get("/editar/:matricula", (request, response) -> {


            Map<String,Object> atributos = new HashMap<>();
            for (Estudiante obj: ListaDeEstudiantes) {

                if(obj.getMatricula().equals(request.params("matricula"))){
                    int var = ListaDeEstudiantes.indexOf(obj);
                    atributos.put("estuLista", ListaDeEstudiantes.get(var));
                    return new FreeMarkerEngine().render(new ModelAndView(atributos, "EditarEstudiante.ftl"));


                }

            }

            response.redirect("/");


            return null;
        });
        post("/EditarUsuario", (request, response) -> {

                StringWriter writer = new StringWriter();

                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
                for (Estudiante estuLista: ListaDeEstudiantes)
                {
                    if(estuLista.getMatricula() == estudiante.getMatricula())
                    {
                        estuLista.setNombre(estudiante.getNombre());
                        estuLista.setApellido(estudiante.getApellido());
                        estuLista.setMatricula(estudiante.getMatricula());
                        estuLista.setTelefono(estudiante.getTelefono());
                        break;
                    }
                }
                response.redirect("/");
            return writer;

        });












    }



}
