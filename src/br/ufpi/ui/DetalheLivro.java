package br.ufpi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import br.ufpi.beans.Livro;
import br.ufpi.repository.BibliotecaRepository;
import br.ufpi.repository.EmprestimoRepository;

public class DetalheLivro extends Activity implements OnClickListener{

	
	TextView txtTitulo, txtDescricao, txtQuantidade, txtStatus;
	Button btnReserva;
	Intent i = null;
	Livro livro = null;
	EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
	BibliotecaRepository bibliotecaRepository = new BibliotecaRepository();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_detalhes);
		
		txtTitulo = (TextView) findViewById(R.id.txtTitulo);
		txtDescricao = (TextView) findViewById(R.id.txtDescricao);
		txtQuantidade = (TextView) findViewById(R.id.txtQuantidade);
		txtStatus = (TextView) findViewById(R.id.txtStatus);
		
		btnReserva = (Button) findViewById(R.id.btnReserva);
		btnReserva.setOnClickListener(this);
		
		i = getIntent();
		livro = (Livro) i.getSerializableExtra("livro");
		
		
		txtTitulo.setText(livro.getTitulo());
		txtDescricao.setText(livro.getDescricao());
		txtQuantidade.setText(Integer.toString(livro.getQuantidade()));
		txtStatus.setText(Boolean.toString(livro.getStatus()));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String resposta;
		
		Toast.makeText(getApplicationContext(), "Clicou!", Toast.LENGTH_SHORT).show();
		
		
		if(v == btnReserva){
		 resposta = emprestimoRepository.add(v.getContext(),bibliotecaRepository.getUsuario(),livro);
			if (resposta.equals("1")){
				Toast.makeText(getApplicationContext(), "Livro Reservado com Sucesso!", Toast.LENGTH_SHORT).show();
	
			}
		}
	}
}
