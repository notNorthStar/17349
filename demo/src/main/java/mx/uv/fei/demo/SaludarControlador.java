package mx.uv.fei.demo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.node.StringNode;


@RestController
public class SaludarControlador{
    String nombre;
    
    // ruta en sustantivo plural
    @GetMapping("/saludos")
    public String saludar() {
        return "Hola mundo!" + nombre;
    }

    @GetMapping("/despedidas")
    public String adios() {
        return "Adios mundo!";
    }

    @PostMapping("/nombramientos")
    public void nombre() {
        nombre = "Rafael";
    }

    // renombramiento
    @PutMapping("/nombramientos")
    public void net1() {
        nombre = "otro nombre";
    }

    // desnombramiento
    @DeleteMapping("/nombramientos")
    public void net2() {
        nombre = null;
    }


    @GetMapping("/saludar/{nombre}")
    public Saludador met3(@PathVariable String nombre){
        System.out.println(nombre);
        return new Saludador(nombre);
    }

    @GetMapping("/saludar2/{nombreX}")
    public Saludador met4(@PathVariable("nombreX") String nombre){
        System.out.println(nombre);
        saludador = new Saludador(nombre);
        return saludador;
    }

    Saludador saludador;

    @PostMapping("/crearSaludador")
    public String crearSaludador(@RequestBody Saludador nombre){
        saludador = nombre;
        return "Saludador creado" + nombre;
    }

    @GetMapping("/obtenerSaludador")
    public Saludador obtenerSaludador(){
        return saludador;
    }

    // Agregar un método que mapee la raíz
    @RequestMapping ("/")
    public String raiz(){
        String contenido=null;
        contenido = """
                <h1> Menú de Opciones </h1>
                <ul>
                    <li> <a href='/saludos'>/saludos</li>
                    <li> <a href='/despedidas'>/nombramientos</a></li>
                    <li> /nombramientos (Post | Put | Delete)</li>
                    <li> <a href='/saludar/default'>/saludar/{nombre}</a></li>
                    <li> <a href='/saludar2/default2'>/saludar2/{nombre}</a></li>
                    <li> /crearSaludador (Post - json) </li>
                    <li> <a href='/obtenerSaludador'>/obtenerSaludador</a></li>
                    <li> <a href='/query1'>/query1?nombre=valor&paterno=valor2[&materno=valor3</a></li>
                    <li> <a href='/query2'>[?nombre=valor]</a></li>
                </ul>
                """;

        return contenido;
    }

    @GetMapping("/query1")
    public String query1(@RequestParam String nombre){
        System.out.println(nombre);
        return nombre;
    }

    @GetMapping("/query2")
    public String query2(@RequestParam(defaultValue = "default") String nombre){
        System.out.println(nombre);
        return nombre;
    }
}