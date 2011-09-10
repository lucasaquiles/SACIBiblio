package br.ufpi.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import br.ufpi.beans.Livro;
import br.ufpi.repository.LivroRepository;

public class LivroList extends ListActivity {

	LivroRepository livroRepository = new LivroRepository();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<Livro>(getApplicationContext(),
				android.R.layout.simple_list_item_1,
				livroRepository.carregaLivros()));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Livro livro = (Livro) l.getItemAtPosition(position);

		Toast.makeText(getApplicationContext(), "livro: " + livro.getDescricao(),
				Toast.LENGTH_SHORT).show();
	}
}
