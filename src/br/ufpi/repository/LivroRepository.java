package br.ufpi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import br.ufpi.beans.Livro;
import br.ufpi.util.WebService;

public class LivroRepository {

	ArrayList<Livro> livros = new ArrayList<Livro>();

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public ArrayList<Livro> carregaLivros() {

		WebService webService = new WebService(
				"http://10.0.2.2:8080/vraptor-blank-project/livro/loadTodosLivros");

		Map<String, String> params = new HashMap<String, String>();
		params.put("var", "");

		String response = webService.webGet("", params);
		livros = new Gson().fromJson(response, getClass()).getLivros();
		return livros;
	}
}
