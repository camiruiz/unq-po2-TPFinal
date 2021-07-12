package src;


import java.util.List;

public class APP {
	
	private List<UsuarioInquilino> usuarios;
	private List<String> tiposDeInmueble;
	private List<String> servicios;
	private List<String> categoriasDeInmueble;
	private List<String> categoriasDePropietario;
	private List<String> categoriasDeInquilino;

	public APP( List<UsuarioInquilino> usuarios,
				List<String> tiposDeInmueble,
				List<String> servicios,
				List<String> categoriasDeInmueble,
				List<String> categoriasDePropietario,
				List<String> categoriasDeInquilino) {
				super();
	}

	public void agregarCategoriaDeInmueble(String categoriaDeInmueble) {
		categoriasDeInmueble.add(categoriaDeInmueble);
	}
	

	public void agregarCategoriaDePropietario(String categoriaDePropietario) {
		categoriasDePropietario.add(categoriaDePropietario);
	}
	

	public void agregarCategoriaDeInquilino(String categoriaDeInquilino) {
		categoriasDeInquilino.add(categoriaDeInquilino);
	}
	

	public void agregarServicio(String servicio) {
		servicios.add(servicio);
	}
	

	public void agregarTipoDeInmueble(String tipoDeInmueble) {
		tiposDeInmueble.add(tipoDeInmueble);
	}
	
	
	
	
	//Getters y Setter
	public List<UsuarioInquilino> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioInquilino> usuarios) {
		this.usuarios = usuarios;
	}

	public List<String> getTiposDeInmueble() {
		return tiposDeInmueble;
	}

	public void setTiposDeInmueble(List<String> tiposDeInmueble) {
		this.tiposDeInmueble = tiposDeInmueble;
	}

	public List<String> getServicios() {
		return servicios;
	}

	public void setServicios(List<String> servicios) {
		this.servicios = servicios;
	}

	public List<String> getCategoriasDeInmueble() {
		return categoriasDeInmueble;
	}

	public void setCategoriasDeInmueble(List<String> categoriasDeInmueble) {
		this.categoriasDeInmueble = categoriasDeInmueble;
	}

	public List<String> getCategoriasDePropietario() {
		return categoriasDePropietario;
	}

	public void setCategoriasDePropietario(List<String> categoriasDePropietario) {
		this.categoriasDePropietario = categoriasDePropietario;
	}

	public List<String> getCategoriasDeInquilino() {
		return categoriasDeInquilino;
	}

	public void setCategoriasDeInquilino(List<String> categoriasDeInquilino) {
		this.categoriasDeInquilino = categoriasDeInquilino;
	}
	
	
	
	
	
}




