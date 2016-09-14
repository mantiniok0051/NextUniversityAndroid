/**
 * Clase base para las Personas, Organizaciones, Negocios y Actividades involucrados
 *  en las operaciones de la empresa, haciendo uso de la herencia sacamos 
 *  ventaja del poliformismo al permitirnos Agrupar los elementos en una sola 
 *  estructura de datos 
 */

package next.u01final.include;

import java.io.Serializable;
import java.util.*;

public class Entidad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9039334766125164127L;
	private  String tipo; //Tipo de entidad
	private  Map<String, String> detalles; //Estructura que permite 
	
	@SuppressWarnings("unused")
	private static Iterator<String> puntero; //Mecanismo para acceder iterativamente a los valores
	
	/**Constructor por defecto, retorna objeto Entidad 
	   cuyos atributos son declarados nulos, para ser 
	   asignados en ejecucuión.
	**/
	public Entidad() {
		tipo=null;
		detalles=null;
		puntero= null;
	}
	
	public void mostrar(){}
	
	protected void mostrar(String[] llaves){
		//Creamos un medio para construir la cadena de texto "Preformateada"
		StringBuilder desplegar= new StringBuilder();
		//Construimos la salida
		for (int i = 0; i < llaves.length; i++) {
				String llave= llaves[i];
				desplegar.append(llave+": "+detalles.get(llave)+" ");
			}
		//La mostramos al usuario
		System.out.println(tipo+":: "+desplegar);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Map<String, String> getDetalles() {
		return detalles;
	}

	public void setDetalles(Map<String, String> valores) {
		this.detalles = valores;
		setPuntero();
	}
	
	public void setPuntero(){
		puntero= detalles.keySet().iterator();
	}
	
	public String toString(String[] llaves){
		String entidad="TIPO"+tipo+"_";
		//Creamos un medio para construir la cadena de texto "Preformateada" para almacenamiento en el map
				StringBuilder entidad_string= new StringBuilder();
				//Construimos la forma serializada de los detalles
				for (int i = 0; i < llaves.length; i++) {
						String llave= llaves[i];
						entidad_string.append(llave+":"+detalles.get(llave)+"_");
					}
				//Construimos la forma serializada de la entidad
				entidad= entidad+entidad_string;
		return entidad;
	}
	
	public String toString(){
		String entidad="TIPO:"+tipo+"_";
		//Creamos un medio para construir la cadena de texto "Preformateada" para almacenamiento en el map
				StringBuilder entidad_string= new StringBuilder();
				//Construimos la forma serializada de los detalles
				Set<String> llaves= detalles.keySet();
				for (String llave : llaves) {
					   entidad_string.append(llave+":"+detalles.get(llave)+"_"); 
					}				
				//Construimos la forma serializada de la entidad
				entidad= entidad+entidad_string;
		return entidad;
	}
}
