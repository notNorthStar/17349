package mx.uv.fei.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller 
public class PlantillaControlador {

    @GetMapping ("/plantilla")
    public String plantilla(Model modelo){
        modelo.addAttribute("Mensaje", "Hola Mundo");
        return "pagina";
    };
}
