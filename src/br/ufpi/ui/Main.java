package br.ufpi.ui;

import br.ufpi.beans.Usuario;
import br.ufpi.repository.BibliotecaRepository;
import br.ufpi.repository.UsuarioRepository;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	EditText txtSenha, txtMatricula;
	Button btnAcesso;
	UsuarioRepository usuarioRepository = new UsuarioRepository();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		txtSenha = (EditText) findViewById(R.id.txtSenha);
		txtMatricula = (EditText) findViewById(R.id.txtMatricula);

		btnAcesso = (Button) findViewById(R.id.btnAcesso);
		btnAcesso.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v == btnAcesso) {

			Usuario usuario = new Usuario();

			usuario.setMatricula(txtMatricula.getText().toString().trim());
			usuario.setSenha(txtSenha.getText().toString().trim());
			usuario = usuarioRepository.autentica(usuario);

			if (!usuario.getNome().equals("1")) {
				
				BibliotecaRepository br = new BibliotecaRepository(usuario);
				
				Intent i = new Intent(getApplicationContext(), MainTabs.class);
				 startActivity(i);
			} else {
				Toast.makeText(getApplicationContext(),
						"nome de usuário ou senha inválido(s)",
						Toast.LENGTH_SHORT).show();
			}

		}
	}
}