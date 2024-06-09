package archivos;

public class Archivo {
	private String nombreArchivo;
	
	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
		
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
}
