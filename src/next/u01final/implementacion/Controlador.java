package next.u01final.implementacion;

import next.u01final.include.*;
import java.util.*;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Controlador {
	
	private static FabricaDeEntidades fbde=new FabricaDeEntidades();
	private static ArrayList<String> entidades= new ArrayList<String>();	
	private static Persona persona;	
	private static Organizacion org;
	private static Negocio negocio;
	private static Actividad actividad;
	private static StringBuilder desplegar= new StringBuilder();
	private static String usuario;
	private static Scanner scan= new Scanner(System.in);
	
	protected static String bienvenida(String nombre){
		System.out.println("");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::Mi Gestor de Actividades Comerciales:::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("   Bienvenid@ "+nombre+
						   "\n\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"+
						   "::::  Las entidades definidas para este software son:                                                     ::::\n"+
						   "::::					 								  ::::\n"+
						   "::::	 Persona: Es la entidad que representa una persona en particular con la cual                      ::::\n"+
						   "::::	 se podrán hacer actividades y estarán o no asignadas a un negocio.                               ::::\n"+
						   "::::					 								  ::::\n"+
						   "::::	 Organización: Es la entidad que representa una empresa con la cual se podrán                     ::::\n"+
						   "::::	 hacer actividades y estarán o no asignadas a un negocio.                                         ::::\n"+
						   "::::                                                                                                      ::::\n"+
						   "::::	 Negocio: Es la entidad que representa un negocio, puede tener asignado personas                  ::::\n"+
						   "::::	 u organizaciones.						                                  ::::\n"+
						   "::::                                                                                                      ::::\n"+
						   "::::	 Actividad: Es la entidad que representa una actividad que se puede realizar con                  ::::\n"+
						   "::::	 una persona, un negocio, o una organización.						          ::::\n"+
						   "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("                          :::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"+
						   "                          :::::::::Tareas disponibles sobre las entidades::::::::::\n"+
						   "                          ::       1.- Registrar                                 ::\n"+
						   "                          ::       2.- Alterar                                   ::\n"+
						   "                          ::       3.- Borrar                                    ::\n"+
						   "                          ::       4.- Consultar                                 ::\n"+
						   "                          ::       5.- Salir	                                 ::\n"+
						   "                          :::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("Ingresa el número a la izquierda del item deseado:  ");
		String entrada= scan.nextLine();
		return entrada;
	}
	
	protected static void consultar(String tipo){
		if (tipo.equalsIgnoreCase("Actividad")) {
				System.out.println(recupera_lista_actividades());
			} 
		else if(tipo.equalsIgnoreCase("Negocio")) {

			} 
		else if(tipo.equalsIgnoreCase("Organizacion")) {

		} 
		else if(tipo.equalsIgnoreCase("Persona")) {

		}
	} 
	
	protected static String procesa_menu(String entrada){
		String proceso=null;
		switch (entrada) {
		case "1":
				System.out.println(" Procederemos a Registrar una entidad");
				proceso="Registrar";
			break;
		case "2":
				System.out.println(" Procederemos a Alterar una entidad");
				proceso="Alterar";
			break;
		case "3":
				System.out.println(" Procederemos a Borar una entidad");
				proceso="Borrar";
			break;
		case "4":
				System.out.println(" Procederemos a Consultar una entidad");
				proceso="Consultar";
			break;
		case "5":
			System.out.println(" Procederemos a Salir de la aplicación");
			proceso="Salir";
		break;			
		default:
				System.out.println("El valor registrado no es válido, se procederá a la creación / registro de\nuna Entidad");
				proceso="Registrar";
			break;
		}
		 
		
		return proceso;
	}
	
	protected static String login(){
		String nombre;
			System.out.print("Por favor captura tu nombre para una experiencia personalizada:  ");
			nombre= scan.nextLine();
			usuario=nombre;
		return nombre;
	}
	
	protected static ArrayList<String> obtener_criterios_busqueda(){
			ArrayList<String> criterios_de_busqueda=new ArrayList<String>();
			List<String> lista_de_llaves=null; 
			String tipo;
			String _criterios;
			System.out.println(usuario+" Qué tipo de entidad deseas revisar?\nActividad, Negocio, Organización o Persona...");
			tipo=scan.next();
			if (tipo.equalsIgnoreCase("Actividad")) {
				lista_de_llaves=Actividad.getListaDeLlaves();
				System.out.println("Proporciona el o los criterios de búsqueda:(Emplea + para separara cada criterio ej: Criterio1+Criterio2+...+CriterioN)\nLista de criterios válidos para una Organización");
				for (String llave:lista_de_llaves ) {
						System.out.print(llave+", ");						
				}
			}
			else if(tipo.equalsIgnoreCase("Negocio")){
				lista_de_llaves=Negocio.getListaDeLlaves();
				System.out.println("Proporciona el o los criterios de búsqueda:(Emplea + para separara cada criterio ej: Criterio1+Criterio2+...+CriterioN)\nLista de criterios válidos para un Negocio");
				for (String llave:lista_de_llaves ) {
						System.out.print(llave+", ");						
				}
			}
			else if(tipo.equalsIgnoreCase("Organizacion")){
				lista_de_llaves=Organizacion.getListaDeLlaves();
				System.out.println("Proporciona el o los criterios de búsqueda:(Emplea + para separara cada criterio ej: Criterio1+Criterio2+...+CriterioN)\nLista de criterios válidos para una Organización");
				for (String llave:lista_de_llaves ) {
						System.out.print(llave+", ");						
				}
			}
			else if(tipo.equalsIgnoreCase("Persona")){
				lista_de_llaves=Persona.getListaDeLlaves();
				System.out.println("Proporciona el o los criterios de búsqueda:(Emplea + para separara cada criterio ej: Criterio1+Criterio2+...+CriterioN)\nLista de criterios válidos para una Persona");
				for (String llave:lista_de_llaves ) {
						System.out.print(llave+", ");						
				}
			}
			else{
					System.out.println("El Tipo de entidad capturado no corresponde con ninguno de los existentes");
				}
			_criterios=scan.next();
			if (_criterios.contains("+")) {
					String[] criterios=_criterios.split("+");
					for (String criterio : criterios) {
						System.out.println("Proporciona el valor a buscar para "+criterio+":");
						criterio= criterio+":"+scan.next();
						criterios_de_busqueda.add(criterio);
					}
			}
			return criterios_de_busqueda;
			
		}
	
	protected static String solicita_tipo_entidad_a_crear(){
					String clase_entidad=null;
		
					System.out.println("Qué clase de entidad deseas crear "+usuario+"?"+
						 "\nRecuerda, sólo pueden crearse entidades de clase:"+
						 "\n   Actividad, Negocio, Organizacion o Persona    "+
						 "\nUna entrada diferente regresa una Entidad abstracta");
								String entrada= scan.nextLine();
						  if(entrada.equalsIgnoreCase("Actividad")||entrada.equalsIgnoreCase("Negocio")||
							 entrada.equalsIgnoreCase("Organizacion")||entrada.equalsIgnoreCase("Persona")){
							  clase_entidad=entrada;
						  	}
						  else{System.out.println("Error: El tipo de entidad solicitado no es válido");}
			
			return clase_entidad;
		}
	
	protected static Map<String, String> obtener_detalles(String llave_entidad){
			Set<String> llaves_detalles;
			llaves_detalles= FabricaDeEntidades.recupera_detalles_entidad(llave_entidad);
			Map<String, String> nuevos_detalles=new TreeMap<String, String>();
			String nuevo_valor="";
			for (Iterator<String> iterator = llaves_detalles.iterator(); iterator.hasNext();) {
					String llave = (String) iterator.next();
					if(llave.equalsIgnoreCase("VALOR")){
							System.out.println("Porfavor proporciona el "+llave+" de este Negocio");
							nuevo_valor= scan.nextLine();
							nuevos_detalles.put(llave, nuevo_valor);
						}
			}
			return nuevos_detalles;
		}
	
	protected static Map<String, String> obtener_detalles_persona(){
		Map<String, String> detalles_persona=new TreeMap<String, String>();
		String valor;
		
			System.out.println(usuario);
			System.out.println("Proporciona el nombre y apellido de la persona a registrar: ");
			valor= scan.next();
			detalles_persona.put("NOMBRE", valor);
			System.out.println("Proporciona el número de teléfono de la persona a registrar: ");
			valor= scan.next();
			detalles_persona.put("TELEFONO", valor);
			System.out.println("Proporciona el correo electrónico de la persona a registrar: ");
			valor= scan.next();
			detalles_persona.put("CORREO", valor);
		
		return detalles_persona;
	}
	
	protected static Map<String, String> obtener_detalles_organizacion(){
		Map<String, String> detalles_organizacion=new TreeMap<String, String>();
		String valor;
		
			System.out.println(usuario);
			System.out.println("Proporciona el nombrede la organizacion a registrar: ");
			valor= scan.next();
			detalles_organizacion.put("NOMBRE", valor);
			System.out.println("Proporciona el número de teléfono de la organización a registrar: ");
			valor= scan.next();
			detalles_organizacion.put("TELEFONO", valor);
			System.out.println("Proporciona la dirección de la organización a registrar: ");
			valor= scan.next();
			detalles_organizacion.put("DIRECCION", valor);
		
		return detalles_organizacion;
	}
	
	protected static Map<String, String> obtener_detalles_negocio(){
		Map<String, String> detalles_negocio=new TreeMap<String, String>();
		String valor;
		
			System.out.println(usuario);
			System.out.println("Proporciona el título del negocio a registrar: ");
			valor= scan.next();
			detalles_negocio.put("TITULO", valor);
			System.out.println("Proporciona la descripción del negocio a registrar: ");
			valor= scan.next();
			detalles_negocio.put("DESCRIPCION", valor);
			System.out.println("Proporciona la fecha estimada de cierre : ");
			valor= scan.next();
			detalles_negocio.put("CIERRE", valor);
			System.out.println("Proporciona el valor (con decimales) de este negocio : ");
			double _valor= Double.parseDouble(scan.next());
			valor= String.valueOf(_valor);
			detalles_negocio.put("VALOR", valor);
			System.out.println("Proporciona la fecha estimada de cierre : ");
			valor= scan.next();
			detalles_negocio.put("CIERRE", valor);
			System.out.println("Captura el estado del negocio (Abierto, Cerrado o en Revision) ");
			valor= scan.next();
				if(valor.equalsIgnoreCase("Abierto")||valor.equalsIgnoreCase("Cerrado")||valor.equalsIgnoreCase("Revision")){
					detalles_negocio.put("ESTADO", valor);
				}
				else{
						System.out.println("El Estado "+valor+" ingresado no es válido, se ha asignado el estado Abierto por defecto");
						detalles_negocio.put("CIERRE", "Abierto");
					}
			if(FabricaDeEntidades.getContador_personas()<1){
					System.out.println(usuario+"\n No existen personas registradas, es necesario crear una, deseas hacerlo ahora? (S ó N)");
					valor= scan.next();
					if(!valor.equalsIgnoreCase("S")){
							System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
							detalles_negocio.put("ESTADO", "Pendiente");
							detalles_negocio.put("PERSONA", "Pendiente");
					}
					else{
							valor= FabricaDeEntidades.FabricaEntidad("Persona", obtener_detalles_persona()).toString();
							detalles_negocio.put("PERSONA", valor);
						}
				}
			else if(FabricaDeEntidades.getContador_personas()==1){
					System.out.println(usuario+"\nExiste una persona registrada, deseas asignarla a este negocio? (S ó N)");
					valor= scan.next();
					if(!valor.equalsIgnoreCase("S")){
						
							System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
							detalles_negocio.put("ESTADO", "Pendiente");
							detalles_negocio.put("PERSONA", "Pendiente");
						}
					else{
							List<String> lista_personas= recupera_lista_personas();
							if(!lista_personas.isEmpty()){
									valor= lista_personas.get(0);
									detalles_negocio.put("Persona", valor);
									System.out.println("Se ha asignado la persona "+valor+" a este negocio");
							}
						}
				}
			else if(FabricaDeEntidades.getContador_personas()>1){
					System.out.println(usuario+"\nExisten más de una persona registrada, deseas asignar una de ellas a este negocio? (S ó N)");
					valor= scan.next();
					if(!valor.equalsIgnoreCase("S")){
							System.out.println("Deseas crear una nueva persona para este negocio? (S ó N)");
							valor= scan.next();
							if(!valor.equalsIgnoreCase("S")){
									System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
									detalles_negocio.put("ESTADO", "Pendiente");
									detalles_negocio.put("PERSONA", "Pendiente");
								}
							else{
									System.out.println("Procederemos a crear la nueva Persona");
									valor= FabricaDeEntidades.FabricaEntidad("Persona", obtener_detalles_persona());
									detalles_negocio.put("PERSONA", valor);
									entidades.add(valor);
									System.out.println("La referencia a la persona "+valor+" creada se ha agregado a la lista local de Entidades");
								}
						}
					else{
							List<String> lista_personas= recupera_lista_personas();
								if(!lista_personas.isEmpty()){
									System.out.println("Por favor selecciona una persona:(Ingresa el número a la izquierda del Item)");
									int contador=0;
									for (String persona : lista_personas) {
										System.out.println(contador+": "+recupera_entidad(persona));
									}
									
								}
						}
					if(FabricaDeEntidades.getContador_organizaciones()<1){
							System.out.println(usuario+"\n No existen organizaciones registradas, es necesario crear una, deseas hacerlo ahora? (S ó N)");
							valor= scan.next();
							if(!valor.equalsIgnoreCase("S")){
									System.out.println("La organización y el estado del negocio se asignarán como Pendiente.");
									detalles_negocio.put("ESTADO", "Pendiente");
									detalles_negocio.put("ORGANIZACION", "Pendiente");
								}
							else{
									valor= FabricaDeEntidades.FabricaEntidad("Organizacion", obtener_detalles_persona());
									detalles_negocio.put("ORGANIZACION", valor);
								}
						}
					else if(FabricaDeEntidades.getContador_organizaciones()==1){
								System.out.println(usuario+"\nExiste una organización registrada, deseas asignarla a este negocio? (S ó N)");
								valor= scan.next();
								if(!valor.equalsIgnoreCase("S")){
									System.out.println("Deseas crear una nueva organización para este negocio? (S ó N)");
									valor= scan.next();	
									if(!valor.equalsIgnoreCase("S")){
											System.out.println("La organización y el estado del negocio se asignarán como Pendiente.");
											detalles_negocio.put("ESTADO", "Pendiente");
											detalles_negocio.put("ORGANIZACION", "Pendiente");
										}
									}
								else{
										List<String> lista_organizaciones= recupera_lista_organizaciones();
										if(!lista_organizaciones.isEmpty()){
												valor= lista_organizaciones.get(0);
												detalles_negocio.put("Organizacion", valor);
												System.out.println("Se ha asignado la organización "+valor+" a este negocio");
										}
									}
						}
					else if(FabricaDeEntidades.getContador_organizaciones()>1){
						System.out.println(usuario+"\nExisten más de una organización registrada, deseas asignar una de ellas a este negocio? (S ó N)");
						valor= scan.next();
						if(!valor.equalsIgnoreCase("S")){
								System.out.println("Deseas crear una nueva organización para este negocio? (S ó N)");
								valor= scan.next();
								if(!valor.equalsIgnoreCase("S")){
										System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
										detalles_negocio.put("ESTADO", "Pendiente");
										detalles_negocio.put("PERSONA", "Pendiente");
									}
								else{
										System.out.println("Procederemos a crear la nueva Organización");
										valor= FabricaDeEntidades.FabricaEntidad("Organizacion", obtener_detalles_organizacion());
										detalles_negocio.put("ORGANIZACION", valor);
										entidades.add(valor);
										System.out.println("La referencia a la organización "+valor+" creada se ha agregado a la lista local de Entidades");
									}
							}
						else{
								List<String> lista_organizaciones= recupera_lista_organizaciones();
									if(!lista_organizaciones.isEmpty()){
										System.out.println("Por favor selecciona una Organización:(Ingresa el número a la izquierda del Item)");
										int contador=0;
										for (String organizacion : lista_organizaciones) {
											System.out.println(contador+": "+recupera_entidad(organizacion));
										}
										
									}
							}
					}
				}		
		return detalles_negocio;
	}
	
	protected static Map<String, String> obtener_detalles_actividad(){
		Map<String, String> detalles_actividad=new TreeMap<String, String>();
		String valor;
		int dato;
		
			System.out.println(usuario);
			System.out.println("Proporciona el nombre de la actividad a registrar: ");
			valor= scan.next();
			detalles_actividad.put("NOMBRE", valor);
			System.out.println("Proporciona la descripción de la actividad a registrar: ");
			valor= scan.next();
			detalles_actividad.put("DESCRIPCION", valor);
			System.out.println("Proporciona Indica el tipo de actividad a registrar: (Ingresa el número a la izquierda del Item)");
			System.out.println("1: Campaña en medios\n2: Evento en sitio\n3: Capaña digital");
			valor= scan.next();			
				switch (valor) {
				case "1":
					valor="Campaña en medios";
					detalles_actividad.put("CLASE", valor);
					break;
				case "2":
					valor="Evento en sitio";
					detalles_actividad.put("CLASE", valor);
					break;
				case "3":
					valor="Campaña Digital";
					detalles_actividad.put("CLASE", valor);
					break;

				default:
					System.out.println("El dato "+valor+" No corresponde con ninguna de las clases posibles\nLa clase se asignará al valor por defecto Campaña Digital");
					valor="Campaña Digital";
					detalles_actividad.put("CLASE", valor);
					break;
				}
			System.out.println("Procederemos a caprutar la fecha de inicio, proporciona el nombre del mes");
			valor=scan.next();
			String fecha=valor;
			if(valor.equalsIgnoreCase("Enero")||valor.equalsIgnoreCase("Marzo")||valor.equalsIgnoreCase("Mayo")||valor.equalsIgnoreCase("Julio")||valor.equalsIgnoreCase("Agosto")||valor.equalsIgnoreCase("Octubre")||valor.equalsIgnoreCase("Diciembre")){
					System.out.println("Ingresa el número del día:");
					dato= Integer.parseInt(scan.next());
					if(dato>0&&dato<=31){
							fecha+="/"+dato;
					  }
					else{System.out.println("El número de día proporcionado no es válido se asigná 1");
							fecha+="/1";
					}
				}
			else if(valor.equalsIgnoreCase("Abril")||valor.equalsIgnoreCase("Junio")||valor.equalsIgnoreCase("Septiembre")||valor.equalsIgnoreCase("Noviembre")){
				System.out.println("Ingresa el número del día:");
					dato= Integer.parseInt(scan.next());
				if(dato>0&&dato<=30){
						fecha+="/"+dato;
					}
				else{System.out.println("El número de día proporcionado no es válido se asigná 1");
						fecha+="/1";
					}
				}
			else if(valor.equalsIgnoreCase("Febrero")){
				System.out.println("Ingresa el número del día:");
					dato= Integer.parseInt(scan.next());
				if(dato>0&&dato<=29){
						fecha+="/"+dato;
					}
				else{System.out.println("El número de día proporcionado no es válido se asigná 1");
						fecha+="/1";
					}

				}
			else{
					System.out.println("El valor proporcionado no es válido se asignará Enero");
					System.out.println("Ingresa el número del día:");
						dato= Integer.parseInt(scan.next());
					if(dato>0&&dato<=29){
							fecha+="/"+dato;
						}
					else{System.out.println("El número de día proporcionado no es válido se asigná 1");
							fecha+="/1";
						}
					
				}
			System.out.println("Captura el año:");
			dato= Integer.parseInt(scan.next());
			if(dato<=2016){
					fecha+="/"+dato;
				}
			else{System.out.println("El año proporcionado no es válido se asigná 2017");
					fecha+="/2017";
				}
			detalles_actividad.put("FECHA", fecha);
			System.out.println("Procederemos a capturar la hora de inicio,sin minutos (Formato 24 Hrs)");
			String hora="";
					dato= Integer.parseInt(scan.next());
					if(dato>=0&&dato<=24){
							hora+=dato;
							System.out.println("Proporciona los minutos:");
							dato= Integer.parseInt(scan.next());
							if(dato>=0&&dato<=6){
								hora+=":"+dato;
							}
					else{System.out.println("El valor proporcionado no es válido se asignará 00");
							hora+=":00";
					    }
							
					  	}
					else{System.out.println("La hora proporcionada no es válida se asigná 10");
							hora+="10";
					    }
					detalles_actividad.put("HORA", fecha);
					System.out.println("Procederemos a capturar la duración en horas , minutos como decimales (Formato 24.0 Hrs)");
					String duracion="";
							Float dat= Float.parseFloat(scan.next());
							if(dat>=0.1&&dato<=24.0){
									duracion+=dat;
								}
							else{System.out.println("El valor proporcionado no es válido se asignará 1.0 Hrs");
									duracion+="1.0";
							    }
					detalles_actividad.put("DURACION", fecha);
					if(FabricaDeEntidades.getContador_personas()<1){
						System.out.println(usuario+"\n No existen personas registradas, es necesario crear una, deseas hacerlo ahora? (S ó N)");
						valor= scan.next();
						if(!valor.equalsIgnoreCase("S")){
								System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
								detalles_actividad.put("ESTADO", "Pendiente");
								detalles_actividad.put("PERSONA", "Pendiente");
						}
						else{
								valor= FabricaDeEntidades.FabricaEntidad("Persona", obtener_detalles_persona()).toString();
								detalles_actividad.put("PERSONA", valor);
							}
					}
				else if(FabricaDeEntidades.getContador_personas()==1){
						System.out.println(usuario+"\nExiste una persona registrada, deseas asignarla a este negocio? (S ó N)");
						valor= scan.next();
						if(!valor.equalsIgnoreCase("S")){
							
								System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
								detalles_actividad.put("ESTADO", "Pendiente");
								detalles_actividad.put("PERSONA", "Pendiente");
							}
						else{
								List<String> lista_personas= recupera_lista_personas();
								if(!lista_personas.isEmpty()){
										valor= lista_personas.get(0);
										detalles_actividad.put("Persona", valor);
										System.out.println("Se ha asignado la persona "+valor+" a este negocio");
								}
							}
					}
				else if(FabricaDeEntidades.getContador_personas()>1){
						System.out.println(usuario+"\nExisten más de una persona registrada, deseas asignar una de ellas a este negocio? (S ó N)");
						valor= scan.next();
						if(!valor.equalsIgnoreCase("S")){
								System.out.println("Deseas crear una nueva persona para este negocio? (S ó N)");
								valor= scan.next();
								if(!valor.equalsIgnoreCase("S")){
										System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
										detalles_actividad.put("ESTADO", "Pendiente");
										detalles_actividad.put("PERSONA", "Pendiente");
									}
								else{
										System.out.println("Procederemos a crear la nueva Persona");
										valor= FabricaDeEntidades.FabricaEntidad("Persona", obtener_detalles_persona());
										detalles_actividad.put("PERSONA", valor);
										entidades.add(valor);
										System.out.println("La referencia a la persona "+valor+" creada se ha agregado a la lista local de Entidades");
									}
							}
						else{
								List<String> lista_personas= recupera_lista_personas();
									if(!lista_personas.isEmpty()){
										System.out.println("Por favor selecciona una persona:(Ingresa el número a la izquierda del Item)");
										int contador=0;
										for (String persona : lista_personas) {
											System.out.println(contador+": "+recupera_entidad(persona));
										}
										
									}
							}
						if(FabricaDeEntidades.getContador_organizaciones()<1){
								System.out.println(usuario+"\n No existen organizaciones registradas, es necesario crear una, deseas hacerlo ahora? (S ó N)");
								valor= scan.next();
								if(!valor.equalsIgnoreCase("S")){
										System.out.println("La organización y el estado del negocio se asignarán como Pendiente.");
										detalles_actividad.put("ESTADO", "Pendiente");
										detalles_actividad.put("ORGANIZACION", "Pendiente");
									}
								else{
										valor= FabricaDeEntidades.FabricaEntidad("Organizacion", obtener_detalles_persona());
										detalles_actividad.put("ORGANIZACION", valor);
									}
							}
						else if(FabricaDeEntidades.getContador_organizaciones()==1){
									System.out.println(usuario+"\nExiste una organización registrada, deseas asignarla a este negocio? (S ó N)");
									valor= scan.next();
									if(!valor.equalsIgnoreCase("S")){
										System.out.println("Deseas crear una nueva organización para este negocio? (S ó N)");
										valor= scan.next();	
										if(!valor.equalsIgnoreCase("S")){
												System.out.println("La organización y el estado del negocio se asignarán como Pendiente.");
												detalles_actividad.put("ESTADO", "Pendiente");
												detalles_actividad.put("ORGANIZACION", "Pendiente");
											}
										}
									else{
											List<String> lista_organizaciones= recupera_lista_organizaciones();
											if(!lista_organizaciones.isEmpty()){
													valor= lista_organizaciones.get(0);
													detalles_actividad.put("Organizacion", valor);
													System.out.println("Se ha asignado la organización "+valor+" a este negocio");
											}
										}
							}
						else if(FabricaDeEntidades.getContador_organizaciones()>1){
							System.out.println(usuario+"\nExisten más de una organización registrada, deseas asignar una de ellas a este negocio? (S ó N)");
							valor= scan.next();
							if(!valor.equalsIgnoreCase("S")){
									System.out.println("Deseas crear una nueva organización para este negocio? (S ó N)");
									valor= scan.next();
									if(!valor.equalsIgnoreCase("S")){
											System.out.println("La persona y el estado del negocio se asignarán como Pendiente.");
											detalles_actividad.put("ESTADO", "Pendiente");
											detalles_actividad.put("PERSONA", "Pendiente");
										}
									else{
											System.out.println("Procederemos a crear la nueva Organización");
											valor= FabricaDeEntidades.FabricaEntidad("Organizacion", obtener_detalles_organizacion());
											detalles_actividad.put("ORGANIZACION", valor);
											entidades.add(valor);
											System.out.println("La referencia a la organización "+valor+" creada se ha agregado a la lista local de Entidades");
										}
								}
							else{
									List<String> lista_organizaciones= recupera_lista_organizaciones();
										if(!lista_organizaciones.isEmpty()){
											System.out.println("Por favor selecciona una Organización:(Ingresa el número a la izquierda del Item)");
											int contador=0;
											for (String organizacion : lista_organizaciones) {
												System.out.println(contador+": "+recupera_entidad(organizacion));
											}
											
										}
								}
						}
					}		
				
		
		return detalles_actividad;
	}
	
	protected static void registrar(String tipo, Map<String, String> detalles){
		String direccion=FabricaDeEntidades.FabricaEntidad(tipo, detalles);
		entidades.add(direccion);
	}
	
	protected static Map<String, String> registrar_nueva_entidad(String tipo){
		Map<String, String> detalles_entidad;
		switch (tipo) {
		case "Persona":
				detalles_entidad=obtener_detalles_persona();
			break;
		case "Organizacion":
				detalles_entidad=obtener_detalles_organizacion();
			break;
		case "Negocio":			
				detalles_entidad=obtener_detalles_negocio();
			break;
		case "Actividad":			
				detalles_entidad=obtener_detalles_actividad();
			break;
		default:
			System.out.println("El valor ingresado no es válido se procede con la creación de una persona");
			detalles_entidad=obtener_detalles_persona();
			break;
		}
		return detalles_entidad;
	}
	
 	protected static List<String> recupera_lista_personas(){
		List<String> lista_personas=new ArrayList<String>();
		for (String entidad : entidades) {
			       if(entidad.startsWith("Persona")){
			    	   	lista_personas.add(entidad);
			       }
		}
		return lista_personas;
	}
	
	protected static List<String> recupera_lista_organizaciones(){
		List<String> lista_organizaciones=new ArrayList<String>();
		for (String entidad : entidades) {
			       if(entidad.startsWith("Organizacion")){
			    	   	lista_organizaciones.add(entidad);
			       }
		}
		return lista_organizaciones;
	}
	
	protected static List<String> recupera_lista_actividades(){
		List<String> lista_actividades=new ArrayList<String>();
		for (String entidad : entidades) {
			       if(entidad.startsWith("Actividad")){
			    	   	lista_actividades.add(entidad);
			       }
		}
		return lista_actividades;
	}
	
	protected static String recupera_entidad(String llave_entidad){
		String entidad_solicitada=FabricaDeEntidades.recupera_entidad(llave_entidad).toString();
		return entidad_solicitada;
	}
	
	protected static List<String> buscar_entidad(){
		List<String> coincidencias_de_busqueda=new ArrayList<String>();	
		Map<String, String> resultados_de_busqueda=FabricaDeEntidades.buscar_entidades(obtener_criterios_busqueda());
		Iterator<String> ite= resultados_de_busqueda.keySet().iterator();
		while (ite.hasNext()) {
			String coincidencia = (String) ite.next();
			coincidencias_de_busqueda.add(coincidencia);
		}
		return coincidencias_de_busqueda;
	}
	
	protected static void borrar(String llave_de_entidad){}
	
	protected static void consultar_detalles_entidad(String tipo, ArrayList<String> criterios){}
	
	protected static void consultar_detalles_entidad(String llave){}
	
	protected static void alterar(){
		
	}
	
	protected static String solicita_tipo_entidad(String proceso){
		String clase_entidad=null;

		System.out.println("Qué clase de entidad deseas "+proceso+" "+usuario+"?"+
			 "\nRecuerda, las clases de entidad disponibles son:"+
			 "\n   Actividad, Negocio, Organizacion o Persona    "+
			 "\nUna entrada diferente regresa una Entidad abstracta");
					String entrada= scan.nextLine();
			  if(entrada.equalsIgnoreCase("Actividad")||entrada.equalsIgnoreCase("Negocio")||
				 entrada.equalsIgnoreCase("Organizacion")||entrada.equalsIgnoreCase("Persona")){
				  clase_entidad=entrada;
			  	}
			  else{System.out.println("Error: El tipo de entidad solicitado no es válido");}

			  return clase_entidad;
	}
	
	protected static boolean continuar(){
		boolean continuar=true;
		System.out.println("Realmente desas salir?...(S/N)");
		if (scan.next().equalsIgnoreCase("S")) {
			continuar=false;
		}
		return continuar;
	}

	
}
