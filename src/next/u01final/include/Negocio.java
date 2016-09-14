package next.u01final.include;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Negocio extends Entidad {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5292378107953880946L;
	private  static final String titulo="TITULO", descripcion="DESCRIPCION",
						 organizacion="ORGANIZACION", persona="PERSONA",
						 fecha_estimada_cierre="CIERRE", estado="ESTADO",
						 valor="VALOR";
	public static List<String> getListaDeLlaves(){
		List<String> lista_de_llaves_detalles=new ArrayList<String>();
		lista_de_llaves_detalles.add(titulo);
		lista_de_llaves_detalles.add(descripcion);
		lista_de_llaves_detalles.add(organizacion);
		lista_de_llaves_detalles.add(persona);
		lista_de_llaves_detalles.add(fecha_estimada_cierre);
		lista_de_llaves_detalles.add(estado);
		return lista_de_llaves_detalles;
	}
	
	public Negocio() {
		super();
		setTipo("Negocio");
		Map<String, String> detalles_negocio= new TreeMap<String, String>();
			detalles_negocio.put(descripcion, null);
			detalles_negocio.put(organizacion, null);
			detalles_negocio.put(persona, null);
			detalles_negocio.put(fecha_estimada_cierre, null);
			detalles_negocio.put(estado, null);
			detalles_negocio.put(valor, null);
			detalles_negocio.put(titulo, null);
		setDetalles(detalles_negocio);
	}
	
	public Negocio(String[] valores) {
		super();
		setTipo("Negocio");
		Map<String, String> detalles_negocio= new TreeMap<String, String>();			
			detalles_negocio.put(descripcion, valores[1]);
			detalles_negocio.put(organizacion, valores[2]);
			detalles_negocio.put(persona, valores[3]);
			detalles_negocio.put(fecha_estimada_cierre, valores[4]);
			detalles_negocio.put(estado, valores[6]);
			detalles_negocio.put(valor, valores[3]);
			detalles_negocio.put(titulo, valores[0]);
		setDetalles(detalles_negocio);
	}
	
	@Override
	public void mostrar(){
		String[] llaves=new String[]{titulo, valor, estado, persona, organizacion, descripcion, fecha_estimada_cierre};
		mostrar(llaves);
	}
	
	@Override
	public String toString(){
		String string_negocio;
		String[] llaves=new String[]{titulo, valor, estado, persona, organizacion, descripcion, fecha_estimada_cierre};
			string_negocio= toString(llaves);
		return string_negocio;
		
	}

	public String getTitulo() {
		return getDetalles().get(titulo);
	}

	public void setTitulo(String nuevo) {
		getDetalles().put(titulo, titulo);
	}

	public String getDescripcion() {
		return getDetalles().get(descripcion);
	}

	public void setDescripcion(String nuevo) {
		getDetalles().put(descripcion, nuevo);
	}

	public String getOrganizacion() {
		return getDetalles().get(organizacion);
	}

	public void setOrganizacion(String nuevo) {
		getDetalles().put(organizacion, nuevo);
	}

	public String getPersona() {
		return getDetalles().get(persona);
	}

	public void setPersona(String nuevo) {
		getDetalles().put(persona, nuevo);
	}

	public String getFecha_estimada_cierre() {
		return getDetalles().get(fecha_estimada_cierre);
	}

	public void setFecha_estimada_cierre(String nuevo) {
		getDetalles().put(fecha_estimada_cierre, nuevo);
	}

	public String getEstado() {
		return getDetalles().get(estado);
	}

	public void setEstado(String nuevo) {
		getDetalles().put(estado, nuevo);
	}

	public double getValor() {
		double detalle_valor= Double.valueOf(getDetalles().get(valor));
		return detalle_valor;
	}

	public void setValor(double nuevo) {
		String dato_valor= Double.toString(nuevo);
		getDetalles().put(valor, dato_valor);
	}
	
}
