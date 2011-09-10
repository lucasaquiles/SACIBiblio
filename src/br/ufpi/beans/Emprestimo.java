package br.ufpi.beans;

import java.util.ArrayList;

public class Emprestimo {
	private long id;
	private Usuario usuario;
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	private String dataEmprestimo;
	private String dataDevolucao;
	private static int LIMITE_PARA_LOCACAO = 3;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void getDataDevolucao() {

		System.out.println(dataEmprestimo);
	}

	public String toString() {

		return usuario + " pegou " + livros.size() + " e vai devolver no dia "
				+ dataEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addLivro(Livro livro) {

		if (livros.size() <= 2) {

			if (livro.getQuantidade() != 0) {
				livro.setQuantidade(livro.getQuantidade() - 1);
				livros.add(livro);

			} else {
				new Throwable("sem livros no repositório");
			}

		} else {
			new Throwable("você excedeu o limite de emprestimos");
		}
	}

	public void devolverLivro(Livro livro) {

		if (livros.size() > 0) {

			for (Livro l : livros) {
				if (l.getTitulo().equals(livro.getTitulo())) {

					l.setQuantidade(l.getQuantidade() + 1);
					l.setStatus(true);
					livros.remove(l);

					break;
				}
			}
		}
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void getRelatorio() {

		for (Livro l : livros) {
			System.out.println(l.getTitulo());
		}

		System.out.println(dataEmprestimo);
	}

}
