package br.ufpi.ui;

import java.util.ArrayList;

import br.ufpi.beans.Livro;
import br.ufpi.repository.BibliotecaRepository;
import br.ufpi.repository.EmprestimoRepository;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class HistoricoList extends ListActivity {

	EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
	BibliotecaRepository biblioRepository = new BibliotecaRepository();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		try {

			ArrayList<Livro> livrosEmprestimo = emprestimoRepository
					.carregaLivros(biblioRepository.getUsuario());

			if (livrosEmprestimo.size() > 0) {

				setListAdapter(new ArrayAdapter<Livro>(getApplicationContext(),
						android.R.layout.simple_list_item_1, livrosEmprestimo));

			}else{
				setListAdapter(new ArrayAdapter<String>(getApplicationContext(),
						android.R.layout.simple_list_item_1, new String[] {
								"sem itens"}));
			}
			
		} catch (Exception e) {

			setListAdapter(new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_list_item_1, new String[] { e
							.getMessage().toString() }));
		}

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Toast.makeText(getApplicationContext(),
				l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT)
				.show();
	}
}
