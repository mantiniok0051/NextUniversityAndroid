package next.u01final.include;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Actividad extends Entidad {
	private static final long serialVersionUID = 7980004205532825918L;
	
	private static String nombre="NOMBRE", descripcion="DESCRIPCION", clase="CLASE", fecha="FECHA", hora="HORA", duracion="DURACION",
				   persona="RESPONSABLE", organizacion="ORGANIZACION", negocio="NEGOCIO";
	
	public static List<String> getListaDeLlaves(){
		List<String> lista_de_llaves_detalles=new ArrayList<String>();
		lista_de_llaves_detalles.add(nombre);
		lista_de_llaves_detalles.add(descripcion);
		lista_de_llaves_detalles.add(clase);
		lista_de_llaves_detalles.add(fecha);
		lista_de_llaves_detalles.add(hora);
		lista_de_llaves_detalles.add(duracion);
		lista_de_llaves_detalles.add(persona);
		lista_de_llaves_detalles.add(organizacion);
		lista_de_llaves_detalles.add(negocio);
		return lista_de_llaves_detalles;
	}

	public Actividad() {
		super();
		Map<String, String> detalles_actividad= new TreeMap<String, String>();
			detalles_actividad.put(clase, null);
			detalles_actividad.put(descripcion, null);
			detalles_actividad.put(fecha, null);
			detalles_actividad.put(hora, null);
			detalles_actividad.put(duracion, null);
			detalles_actividad.put(persona, null);
			detalles_actividad.put(organizacion, null);
			detalles_actividad.put(negocio, null);
			detalles_actividad.put(nombre, null);			
	}
	
	public Actividad(String[] detalles) {
		super();
		Map<String, String> detalles_actividad= new TreeMap<String, String>();
			detalles_actividad.put(clase, detalles[9]);
			detalles_actividad.put(descripcion, detalles[7]);
			detalles_actividad.put(fecha, detalles[6]);
			detalles_actividad.put(hora, detalles[5]);
			detalles_actividad.put(duracion, detalles[4]);
			detalles_actividad.put(negocio, detalles[3]);
			detalles_actividad.put(organizacion, detalles[2]);			
			detalles_actividad.put(persona, detalles[1]);
			detalles_actividad.put(nombre, detalles[0]);			
	}
	
	@Override
	public void mostrar(){
		String[] llaves=new String[]{nombre, descripcion, clase, fecha, hora, duracion,
				   persona, organizacion, negocio};
		mostrar(llaves);
	}

	public String getNombre() {
		return getDetalles().get(nombre);
	}

	public void setNombre(String nuevo) {
		getDetalles().put(nombre, nuevo);
	}

	public String getDescripcion() {
		return getDetalles().get(descripcion);
	}

	public void setDescripcion(String nuevo) {
		getDetalles().put(descripcion, nuevo);
	}

	public String getClase() {
		return getDetalles().get(clase);
	}

	public void setClase(String nuevo) {
		getDetalles().put(clase, nuevo);
	}

	public String getFecha() {
		return getDetalles().get(fecha);
	}

	public void setFecha(String nuevo) {
		getDetalles().put(fecha, nuevo);
	}

	public String getHora() {
		return getDetalles().get(hora);
	}

	public void setHora(String nuevo) {
		getDetalles().put(hora, nuevo);
	}

	public String getDuracion() {
		return getDetalles().get(duracion);
	}

	public void setDuracion(String nuevo) {
		getDetalles().put(duracion, nuevo);
	}

	public String getPersona() {
		return getDetalles().get(persona);
	}

	public void setPersona(String nuevo) {
		getDetalles().put(persona, nuevo);
	}

	public String getOrganizacion() {
		return getDetalles().get(organizacion);
	}

	public void setOrganizacion(String nuevo) {
		getDetalles().put(organizacion, nuevo);
	}

	public String getNegocio() {
		return getDetalles().get(negocio);
	}

	public void setNegocio(String nuevo) {
		getDetalles().put(negocio, nuevo);
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
