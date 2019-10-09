package Modelos;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;


import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {



    public static void main(String[] args) throws IOException {

        port(8080);

        staticFiles.location("/publico");
        String templatePath = new File("").getAbsolutePath();
        //System.out.println(templatePath);
        final Configuration config = new Configuration(new Version(2, 3, 0));
        config.setDirectoryForTemplateLoading(new File(templatePath +"/src/main/resources/spark/template/freemarker"));
        config.setDefaultEncoding("UTF-8"); //Renderizar con tildes.
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setLogTemplateExceptions(false);

        ArrayList<Estudiante> ListaDeEstudiantes = new ArrayList<Estudiante>();

        get("/", ((request, response) -> {

            int conteo = ListaDeEstudiantes.size();
            Template temp = config.getTemplate("Home.ftl");
            StringWriter LeeTemplate = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("ListaDeEstudiantes", ListaDeEstudiantes);
            attributes.put("conteo", conteo );

             temp.process(attributes, LeeTemplate );
            return LeeTemplate;

        }));

        get("/NuevoEstudiante", (request, response) -> {


            return null;
        });







    }



}
