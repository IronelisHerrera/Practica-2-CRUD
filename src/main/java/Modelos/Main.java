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

           // StringWriter writerLabel = new StringWriter();


            String matricula = (request.queryParams("matricula"));
            //System.out.println(matricula);
            String nombre = (request.queryParams("nombre"));
            String apellido = (request.queryParams("apellido"));
            String telefono = (request.queryParams("telefono"));

            ListaDeEstudiantes.add(new Estudiante(matricula, nombre, apellido, telefono));
            response.redirect("/");

            return 1;



        });







    }



}
