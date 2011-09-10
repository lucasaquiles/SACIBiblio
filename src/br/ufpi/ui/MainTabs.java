package br.ufpi.ui;

import br.ufpi.beans.Livro;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainTabs extends TabActivity {
	
	TabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		tabHost = getTabHost();
		
		createTab("abaHistorico", "histórico", new Intent(getApplicationContext(), HistoricoList.class));
		createTab("abaLivro", "livros", new Intent(getApplicationContext(), LivroList.class));
		createTab("abaBusca", "buscar", new Intent(getApplicationContext(), Busca.class));
	}
	
	public void createTab(String tag, String indicator, Intent i){
		
		TabSpec tab = tabHost.newTabSpec(tag);
		tab.setIndicator(indicator);
		tab.setContent(i);
		
		tabHost.addTab(tab);
	}
	
	
}
