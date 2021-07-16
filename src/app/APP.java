package app;


import java.util.ArrayList;
import java.util.List;

import usuarios.Usuario;

public class APP {
	
	private List<Usuario> usuarios;
	private List<String> tiposDeInmueble;
	private List<String> servicios;
	private List<String> categoriasDeInmueble;
	private List<String> categoriasDePropietario;
	private List<String> categoriasDeInquilino;
	

	public APP( List<Usuario> usuarios,
				List<String> tiposDeInmueble,
				List<String> servicios,
				List<String> categoriasDeInmueble,
				List<String> categoriasDePropietario,
				List<String> categoriasDeInquilino) {
				super();
				
				this.usuarios 					=  usuarios;
				this.tiposDeInmueble 			= tiposDeInmueble;
				this.servicios 					= servicios;
				this.categoriasDeInmueble 		= categoriasDeInmueble;
				this.categoriasDePropietario	= categoriasDePropietario;
				this.categoriasDeInquilino 		= categoriasDeInquilino;
	}

	public void agregarCategoriaDeInmueble(String categoriaDeInmueble) {
		this.categoriasDeInmueble.add(categoriaDeInmueble);
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public List<String> getTiposDeInmueble() {
		return tiposDeInmueble;
	}


	public List<String> getServicios() {
		return servicios;
	}


	public List<String> getCategoriasDeInmueble() {
		return categoriasDeInmueble;
	}


	public List<String> getCategoriasDePropietario() {
		return categoriasDePropietario;
	}

	

	public List<String> getCategoriasDeInquilino() {
		return categoriasDeInquilino;
	}

	
	
	
	
	
	
}




