package next.u01final.include;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Persona extends Entidad {
	/**
	 * 
	 */
	private static final long serialVersionUID = 24602239990948529L;
	private  static final String nombre="NOMBRE", telefono="TELEFONO", correo="CORREO";
	
	public static List<String> getListaDeLlaves(){
		List<String> lista_de_llaves_detalles=new ArrayList<String>();
		lista_de_llaves_detalles.add(nombre);
		lista_de_llaves_detalles.add(telefono);
		lista_de_llaves_detalles.add(correo);
		return lista_de_llaves_detalles;
	}
	
	public Persona() {
		setTipo("Persona");
		Map<String, String> detalles_persona= new TreeMap<String, String>();
			detalles_persona.put(correo, null);
			detalles_persona.put(telefono, null);
			detalles_persona.put(nombre, null);
		setDetalles(detalles_persona);
	}

	public Persona(String[] valores) {
		setTipo("Persona");
		Map<String, String> detalles_persona= new TreeMap<String, String>();
			detalles_persona.put(correo, valores[2]);
			detalles_persona.put(telefono, valores[1]);
			detalles_persona.put(nombre, valores[0]);
		setDetalles(detalles_persona);
	}
	
	public void mostrar(){
		String[] llaves=new String[]{nombre, correo, telefono};
		mostrar(llaves);
	}
	
	@Override
	public String toString(){
		String string_persona;
		String[] llaves=new String[]{nombre, correo, telefono};
			string_persona= toString(llaves);
		return string_persona;
		
	}

	public String getNombre() {
		return  getDetalles().get(nombre);			
	}

	public String getTelefono() {
		return getDetalles().get(telefono);
	}

	public String getCorreo() {
		return  getDetalles().get(correo);
	}
	
	public void setNombre(String nuevo){
		getDetalles().put(nombre, nuevo);
	}
	
	public void setTelefono(String nuevo){
		getDetalles().put(telefono, nuevo);
	}
	
	public void setCorreo(String nuevo){
		getDetalles().put(correo, nuevo);
	}
	
}
