package calculadorDeCalificaciones;

import usuarios.Usuario;

public class Comentario {
	
	private String 	cuerpo;
	private Usuario usuario;
	
	public Comentario(String cuerpo, Usuario usuario) {
		super();
		this.cuerpo = cuerpo;
		this.usuario = usuario;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	
}