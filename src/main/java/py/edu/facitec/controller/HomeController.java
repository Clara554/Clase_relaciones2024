package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//Anotaciones provee informacion adiccional a una clase
// atributos o metodos

// un elementos que atiende peticiones u envie repuestas
//necesitamois indicar @controller

//Peticiones ---> request lo que viene del cliente
//Respuetas  --->b responde lo que sale del servidor

@Controller

public class HomeController {
	
	//Pueden existir varios metodos 
	//Para atenderf determinadas peticiones/...
	
	// Get ---> se visualiza la escritura en el navegador.
	
	@GetMapping("/home") //request
	public String home() {
		
		System.out.println("Llegue hasta el controlador");
		
		//static   /archivo/  index          .html
		
		//defecto  ap.proper controller    ap.proper
		
		
		return "index";//response
	}

}
