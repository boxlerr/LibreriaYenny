package modelos;

public class Usuario {
	private int id;
	private String mail;
	private String contraseña;
	private String tipo;
	
	
	public Usuario(String mail, String contraseña, String tipo) {
		super();
		this.mail = mail;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}
	public Usuario(int id, String mail, String contraseña, String tipo) {
		super();
		this.id = id;
		this.mail = mail;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", mail=" + mail + ", contraseña=" + contraseña + ", tipo=" + tipo + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	public void Ingreso() {
		
	}

	public boolean IniciarSesion(String mail,String contraseña) {
		if (mail.length()>=4 && contraseña.length()>=4) {
				
			if (this.getMail().equals(mail)){
				if( this.getContraseña().equals(contraseña)) {
					return true;
				} else {
					//Error nombre
					return false;
				}
						
			} else {
				//Error apellido
				return false;
			}
		} else {
			return false;
	
		}
	}
	
}
