package next.u01final.include;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Random;



@SuppressWarnings("unused")
public class FabricaDeEntidades {
	
	private static Map<String, String> entidades;
	private static int contador_entidades, contador_actividades, contador_personas,
				       contador_organizaciones, contador_negocios;
	private static ArrayList<String> indice_actividades, indice_negocios, 
								     indice_organizaciones, indice_personas;
	
	public FabricaDeEntidades() {
		super();
		entidades= new TreeMap<String, String>();
		contador_entidades=0;
		contador_actividades=0;
		contador_personas=0;
		contador_organizaciones=0;
		contador_negocios=0;
		indice_actividades=new ArrayList<String>();
		indice_negocios=new ArrayList<String>();
		indice_organizaciones=new ArrayList<String>();
		indice_personas=new ArrayList<String>();
	}
	
	
	private static String[] buscar(String[] criterios){
		String[] resultado=new String[]{"xxxx"};
		
		return resultado;
		
	}
	
	private static String crear_llave(String tipo){
		String nueva_llave="";
		nueva_llave= nueva_llave+tipo;
			if(tipo.equalsIgnoreCase("Actividad")){					
					int contador= contador_actividades+1;
						if (contador<10) {
								nueva_llave=nueva_llave+"0"+contador;
							}
						else{
								nueva_llave=nueva_llave+contador;
							}
				}
			else if(tipo.equalsIgnoreCase("Persona")){
					int contador= contador_personas+1;
						if (contador<10) {
								nueva_llave=nueva_llave+"0"+contador;
							}
						else{
								nueva_llave=nueva_llave+contador;
							}
				}
			else if(tipo.equalsIgnoreCase("Negocio")){
					int contador= contador_negocios+1;
						if (contador<10) {
								nueva_llave=nueva_llave+"0"+contador;
							}
						else{
								nueva_llave=nueva_llave+contador;
							}
				}
			else if(tipo.equalsIgnoreCase("Organizacion")){
					int contador= contador_organizaciones+1;
						if (contador<10) {
								nueva_llave=nueva_llave+"0"+contador;
							}
						else{
								nueva_llave=nueva_llave+contador;
							}
				}
			else{
					System.out.println("El valor proporcionado no es válido se retornará referencia a un Entidad vacia");
					Random rand=new Random();
					nueva_llave="Entidad"+rand.nextInt(100);
				}
		return nueva_llave;
		}
	
	public static String registrar(Entidad entidad){
		String indice_registrado="";
		if(entidad!=null){
							String nuevo_registro= entidad.toString();
							String nueva_llave= crear_llave(entidad.getTipo());
							indice_registrado=nueva_llave+" "+nuevo_registro;
							entidades.put(nueva_llave, nuevo_registro);
							}
		else{								
				indice_registrado="Error: El objeto Entidad proporcionado no es válido, no se ha creado un registro";
								}
		return indice_registrado;
	}	
	
	//private static Set<String> (Entidad entidad){}
		
	public static void registrar(){}
	
	public static Map<String, String> buscar_entidades(ArrayList<String> criterios_de_busqueda){
		Map<String, String> resultados_de_busqueda= new TreeMap<String, String>();
		Set<String> llaves_entidades= entidades.keySet();
		for (String llave : llaves_entidades) {
				String entidad= entidades.get(llave);
				for (String criterio : criterios_de_busqueda) {
					if(entidad.contains(criterio)){
						//agrega la llave de la entidad  a la respuesta
							if(!resultados_de_busqueda.containsKey(llave)){
								resultados_de_busqueda.put(llave, entidad);
							}							
					}			
				}
			}
		/*Iterator<String> iterator= entidades.keySet().iterator();
		while (iterator.hasNext()) {
			String entidad = (String) iterator.next();
			for (String criterio : criterios_de_busqueda) {
				if(entidad.contains(criterio)){
					//agrega la llave de la entidad  a la respuesta
				}			}
		}*/
		return resultados_de_busqueda;
	}
		
	public static void borrar(){}
	
	public static void alterar(){}
	
	public static String recuperar(){
		String entidad_solicitada=null;
		entidad_solicitada= entidades.get(entidad_solicitada);
		return entidad_solicitada;
	}
	
	public static String FabricaEntidad(String tipo){
		String indice_registrado="";
		Entidad nueva_entidad;
		if (tipo.equalsIgnoreCase("Persona")) { 
				nueva_entidad=new Persona();				
			} 
		else if(tipo.equalsIgnoreCase("Organizacion")){
				nueva_entidad=new Organizacion();				
			}
		else if (tipo.equalsIgnoreCase("Negocio")) {
				nueva_entidad=new Negocio();
			}
		else if(tipo.equalsIgnoreCase("Actividad")){
				nueva_entidad=new Actividad();
			}	
		else{nueva_entidad=new Entidad();}
		indice_registrado=registrar(nueva_entidad);
		return  indice_registrado;
	}
	
	public static String FabricaEntidad(String tipo, Map<String, String> valores){
		String indice_registrado="";
		Entidad nueva_entidad;
		if (tipo.equalsIgnoreCase("Persona")) { 
				nueva_entidad=new Persona();
				nueva_entidad.setDetalles(valores);
			} 
		else if(tipo.equalsIgnoreCase("Organizacion")){
				nueva_entidad=new Organizacion();
				nueva_entidad.setDetalles(valores);
			}
		else if (tipo.equalsIgnoreCase("Negocio")) {
				nueva_entidad=new Negocio();
				nueva_entidad.setDetalles(valores);
			}
		else if(tipo.equalsIgnoreCase("Actividad")){
				nueva_entidad=new Actividad();
				nueva_entidad.setDetalles(valores);
			}	
		else{nueva_entidad=new Entidad();}
		indice_registrado=registrar(nueva_entidad);
		return indice_registrado;
	}
	
	private static  Entidad Fabrica_Entidad(String tipo, Map<String, String> valores){
		String indice_registrado="";
		Entidad nueva_entidad;
		if (tipo.equalsIgnoreCase("Persona")) { 
				nueva_entidad=new Persona();
				nueva_entidad.setDetalles(valores);
			} 
		else if(tipo.equalsIgnoreCase("Organizacion")){
				nueva_entidad=new Organizacion();
				nueva_entidad.setDetalles(valores);
			}
		else if (tipo.equalsIgnoreCase("Negocio")) {
				nueva_entidad=new Negocio();
				nueva_entidad.setDetalles(valores);
			}
		else if(tipo.equalsIgnoreCase("Actividad")){
				nueva_entidad=new Actividad();
				nueva_entidad.setDetalles(valores);
			}	
		else{nueva_entidad=new Entidad();}
		indice_registrado=registrar(nueva_entidad);
		return nueva_entidad;
	}
	
	public static Entidad FabricaEntidad(String[] entidad){
		Entidad e=null;
		if (entidad.length > 3) {
				String tipo_de_entidad= entidad[1];
				Map<String, String> detalles_entidad=new TreeMap<String, String>();
				for (int i = 2; i < entidad.length; i++) {
						String[] llave_valor= entidad[i].split(" ");
						detalles_entidad.put(llave_valor[0], llave_valor[1]);
					}
				e= Fabrica_Entidad(tipo_de_entidad, detalles_entidad);
			}
		else{System.out.println("El paquete prorporcionado no corresponde con una Entidad reconocible");}
		return e;
	}


	public static Map<String, String> getEntidades() {
		return entidades;
	}
	
	public static Set<String> recupera_detalles_entidad(String nombre_entidad){
			Set<String> detalles_entidad=null;
			Entidad e= recupera_entidad(nombre_entidad);
			detalles_entidad= e.getDetalles().keySet();
			return detalles_entidad;
	}
	
	public static Entidad recupera_entidad(String nombre_entidad){
		Entidad entidad_solicitada=null;
		String entidad= entidades.get(nombre_entidad);
		String[] detalles_entidad=entidad.split("_");
		entidad_solicitada= FabricaEntidad(detalles_entidad);
		return entidad_solicitada;
	}


	public static void setEntidades(Map<String, String> entidades) {
		FabricaDeEntidades.entidades = entidades;
	}


	public static int getContador_entidades() {
		return contador_entidades;
	}


	public static void setContador_entidades(int contador_entidades) {
		FabricaDeEntidades.contador_entidades = contador_entidades;
	}


	public static int getContador_actividades() {
		return contador_actividades;
	}


	public static void setContador_actividades(int contador_actividades) {
		FabricaDeEntidades.contador_actividades = contador_actividades;
	}


	public static int getContador_personas() {
		return contador_personas;
	}


	public static void setContador_personas(int contador_personas) {
		FabricaDeEntidades.contador_personas = contador_personas;
	}


	public static int getContador_organizaciones() {
		return contador_organizaciones;
	}


	public static void setContador_organizaciones(int contador_organizaciones) {
		FabricaDeEntidades.contador_organizaciones = contador_organizaciones;
	}


	public static int getContador_negocios() {
		return contador_negocios;
	}


	public static void setContador_negocios(int contador_negocios) {
		FabricaDeEntidades.contador_negocios = contador_negocios;
	}


	public static ArrayList<String> getIndice_actividades() {
		return indice_actividades;
	}


	public static void setIndice_actividades(ArrayList<String> indice_actividades) {
		FabricaDeEntidades.indice_actividades = indice_actividades;
	}


	public static ArrayList<String> getIndice_negocios() {
		return indice_negocios;
	}


	public static void setIndice_negocios(ArrayList<String> indice_negocios) {
		FabricaDeEntidades.indice_negocios = indice_negocios;
	}


	public static ArrayList<String> getIndice_organizaciones() {
		return indice_organizaciones;
	}


	public static void setIndice_organizaciones(ArrayList<String> indice_organizaciones) {
		FabricaDeEntidades.indice_organizaciones = indice_organizaciones;
	}


	public static ArrayList<String> getIndice_personas() {
		return indice_personas;
	}


	public static void setIndice_personas(ArrayList<String> indice_personas) {
		FabricaDeEntidades.indice_personas = indice_personas;
	}

}
