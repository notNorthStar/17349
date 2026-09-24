package mx.uv.fei.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludarControlador{

    String nombre;

    @GetMapping("/getSaludo")
    public String saludar(){
        return "Hola Mundo, Soy " + nombre;
    }

    @GetMapping("/getDespedida")
    public String adios(){
        return "Adios Amor, Me Voy, Me Fui, Esta Vez Para Siempre";
    }

    @PostMapping("/postNombre")
    public void nombre(){
        nombre = "Sasa";
    }
}