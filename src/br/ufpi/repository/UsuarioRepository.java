package br.ufpi.repository;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import br.ufpi.beans.Usuario;
import br.ufpi.util.WebService;

public class UsuarioRepository {
	
	
	Usuario usuario = new Usuario();
	
	
	public Usuario getUsuario(){
		
		return usuario;
	}
	
	public Usuario autentica(Usuario usuario){
		
		WebService webService = new WebService("http://10.0.2.2:8080/vraptor-blank-project/autentica");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("usuario.matricula", usuario.getMatricula());
		params.put("usuario.senha", usuario.getSenha());

		String response = webService.webGet("", params);
		
		usuario =  new Gson().fromJson(response, getClass()).getUsuario();
		
		return usuario;
	}
	
}
