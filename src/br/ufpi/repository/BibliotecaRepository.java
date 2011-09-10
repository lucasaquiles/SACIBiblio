package br.ufpi.repository;

import br.ufpi.beans.Usuario;

public final class BibliotecaRepository {

	
	static Usuario u;
	
	public BibliotecaRepository(){
		
	}
	
	public BibliotecaRepository(Usuario u){
		
		this.u =  u;
	}
	
	
	public Usuario getUsuario(){
		return u;
	}
}
