package src;

import java.util.ArrayList;
import java.util.List;

public class GestorDePublicaciones {

	private List<Publicacion> publicaciones;	
	private static GestorDePublicaciones single_instance = null;
	
	private GestorDePublicaciones(){
		super();
		this.publicaciones = new ArrayList<Publicacion> (publicaciones);
	}
	
	public static GestorDePublicaciones getInstance()
	{
	    if (single_instance == null)
	        single_instance = new GestorDePublicaciones();

	    return single_instance;
	}
	
	
	
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public ArrayList<String> getCiudadesConReserva(UsuarioInquilino usuario){
		
	}
}







//Ejemplo de Singleton.
/*class Singleton
{
// static variable single_instance of type Singleton
private static Singleton single_instance = null;

// variable of type String
public String s;

// private constructor restricted to this class itself
private Singleton()
{
    s = "Hello I am a string part of Singleton class";
}

// static method to create instance of Singleton class
public static Singleton getInstance()
{
    if (single_instance == null)
        single_instance = new Singleton();

    return single_instance;
	}
}
*/