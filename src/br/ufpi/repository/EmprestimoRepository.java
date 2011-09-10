package br.ufpi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.widget.Toast;
import br.ufpi.beans.Livro;
import br.ufpi.beans.Usuario;
import br.ufpi.util.WebService;

import com.google.gson.Gson;

public class EmprestimoRepository {

	ArrayList<Livro> livros = new ArrayList<Livro>();

	public ArrayList<Livro> getLivros() {

		return livros;
	}

	public ArrayList<Livro> carregaLivros(Usuario u) {

		WebService webService = new WebService(
				"http://10.0.2.2:8080/vraptor-blank-project/emprestimo/loadEmprestimosLivros");

		Map<String, String> params = new HashMap<String, String>();
		params.put("u.id", Long.toString(u.getId()));

		String response = webService.webGet("", params);
		livros = new Gson().fromJson(response, getClass()).getLivros();

		return livros;
	}
	
	public String add(Context c, Usuario u, Livro l){
	
		WebService webService = new WebService("http://10.0.2.2:8080/vraptor-blank-project/emprestimo/addEmprestimo");
		Map<String, String> params = new HashMap<String, String>();
		params.put("usuario.id", Long.toString(u.getId()));
		params.put("livro.id", Long.toString(l.getId()));
		String response = webService.webGet("", params);
		
		Toast.makeText(c, "caralho :"+response, Toast.LENGTH_SHORT).show();
		
		return response;

	}

}
