import Modelos.Estudiante;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Esta clase contiene las rutas de los métodos http: GET y POST
 * necesarios para la implementación de nuestro CRUD (Create, Read, Update y Delete).
 * @author Ironelis Herrera
 */

public class Main {
    private static Estudiante estu;

    public static void main(String[] args) throws IOException {

        /**
         * Configuración de puerto para Heroku. Corre en el 8080 por defecto.
         * Comentar esta fracción de código para probar en el puerto por defecto de Spark: 4567.
         * De lo contrario correr en el localhost:8080
         */

        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            port(Integer.parseInt(processBuilder.environment().get("PORT")));
        }else{
            port(8080);
        }

        /*Fin de bloque a comentar*/

        staticFiles.location("/publico");
        final Configuration config = new Configuration(new Version(2, 3, 0));
        config.setClassForTemplateLoading(Main.class, "/spark/template/freemarker");


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

            String matricula = (request.queryParams("matricula"));
            String nombre = (request.queryParams("nombre"));
            String apellido = (request.queryParams("apellido"));
            String telefono = (request.queryParams("telefono"));
            Estudiante estuLista = new Estudiante(matricula, nombre, apellido, telefono);

            for (Estudiante edit : ListaDeEstudiantes) {

                int var = ListaDeEstudiantes.indexOf(edit);

                if(edit.getMatricula().equals(estuLista.getMatricula())){
                    ListaDeEstudiantes.set(var,estuLista);
                    break;
                }
            }
            response.redirect("/");

            return " ";
        });

    }

}
