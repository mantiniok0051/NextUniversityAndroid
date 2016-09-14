package next.u01final.implementacion;

import next.u01final.implementacion.Controlador;

public class Main {
	
	public static void main(String[] args) {
		boolean continua=true;
		String proceso=null;
		String	tipo=null;
		
		while (continua) {
			proceso= Controlador.procesa_menu(Controlador.bienvenida(Controlador.login()));			
			switch (proceso) {
			case "Registrar":
					tipo= Controlador.solicita_tipo_entidad(proceso);
					Controlador.registrar(tipo, Controlador.registrar_nueva_entidad(tipo));
				break;
			case "Alterar":
				tipo= Controlador.solicita_tipo_entidad(proceso);
				Controlador.alterar();			
				break;
			case "Borrar":
				tipo= Controlador.solicita_tipo_entidad(proceso);
				Controlador.borrar(tipo);			
				break;
			case "Consultar":
				tipo= Controlador.solicita_tipo_entidad(proceso);
				Controlador.consultar(tipo);			
				break;
			default: 
				continua=Controlador.continuar();
				System.out.println("Eliminando assets.... Adios!");
				break;
			}
		}
	}

}
