package next.u01final.include;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Organizacion extends Entidad {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4043508106839556606L;
	private  static String nombre="NOMBRE", direccion="DIRECCION", telefono="TELEFONO";
	
	public static List<String> getListaDeLlaves(){
		List<String> lista_de_llaves_detalles=new ArrayList<String>();
		lista_de_llaves_detalles.add(nombre);
		lista_de_llaves_detalles.add(direccion);
		lista_de_llaves_detalles.add(telefono);
		return lista_de_llaves_detalles;
	}

	public Organizacion() {
		setTipo("Organizacion");
		Map<String, String> detalles_organizacion= new TreeMap<String, String>();
			detalles_organizacion.put(telefono, null);
			detalles_organizacion.put(direccion, null);
			detalles_organizacion.put(nombre, null);
		setDetalles(detalles_organizacion);
	}


	public Organizacion(String[] valores) {
		setTipo("Organizacion");
		Map<String, String> detalles_organizacion= new TreeMap<String, String>();
			detalles_organizacion.put(telefono, valores[2]);
			detalles_organizacion.put(direccion, valores[1]);
			detalles_organizacion.put(nombre, valores[0]);
		setDetalles(detalles_organizacion);
	}
	
	
	public void mostrar(){
		String[] llaves=new String[]{nombre, direccion, telefono};
		mostrar(llaves);
	}
	
	@Override
	public String toString(){
		String string_organizacion;
		String[] llaves=new String[]{nombre, direccion, telefono};
			string_organizacion= toString(llaves);
		return string_organizacion;
		
	}
	
	public String getNombre() {
		return getDetalles().get(nombre);
	}


	public void setNombre(String nuevo) {
		getDetalles().put(nombre, nuevo);
	}


	public String getDireccion() {
		return getDetalles().get(direccion);
	}


	public void setDireccion(String nuevo) {
		getDetalles().put(direccion, nuevo);
	}


	public String getTelefono() {
		return getDetalles().get(telefono);
	}


	public void setTelefono(String nuevo) {
		getDetalles().put(telefono, nuevo);
	}
	
}
