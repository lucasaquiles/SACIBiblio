package br.ufpi.ui;

import java.util.ArrayList;

import br.ufpi.beans.Livro;
import br.ufpi.repository.LivroRepository;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor.AutoCloseInputStream;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Busca extends Activity implements TextWatcher, OnClickListener {

	LivroRepository livroRepository = new LivroRepository();
	TextView txtTitulo, txtDescricao;
	AutoCompleteTextView autoCompleteLivro;
	Button btnBusca;
	Button btnDetalhes;
	Livro livro;
	ArrayList<Livro> livros;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		livros = livroRepository.carregaLivros();
		
		setContentView(R.layout.layout_busca);

		txtTitulo = (TextView) findViewById(R.id.txtTitulo);
		txtDescricao = (TextView) findViewById(R.id.txtDescricao);

		btnBusca = (Button) findViewById(R.id.btnBuscar);
 
		btnDetalhes= (Button) findViewById(R.id.btnDetalhe);
		btnDetalhes.setOnClickListener(this);
		
		btnBusca.setOnClickListener(this);

		autoCompleteLivro = (AutoCompleteTextView) findViewById(R.id.autoCompleteLivros);
		autoCompleteLivro.addTextChangedListener(this);
		autoCompleteLivro.setAdapter(new ArrayAdapter<Livro>(this,
				android.R.layout.simple_dropdown_item_1line, livros));

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if(v == btnDetalhes){
			
			Intent i = new Intent(this, DetalheLivro.class);
			i.putExtra("livro", livro);
			startActivity(i);
			
			//Toast.makeText(this, "Opoa!", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		for(Livro l : livros){
			
			if(l.getTitulo().equals(autoCompleteLivro.getText().toString())){
				
				txtTitulo.setText(l.getTitulo().toString());
				txtDescricao.setText(l.getDescricao().toString());
				
				livro = l;
			}
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub

	}
}
