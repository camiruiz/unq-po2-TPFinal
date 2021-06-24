package src;

public class Comentario {
	
	private String 	cuerpo;
	private UsuarioInquilino usuario;
	
	public Comentario(String cuerpo, UsuarioInquilino usuario) {
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

	public UsuarioInquilino getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioInquilino usuario) {
		this.usuario = usuario;
	}
	
	

	
}