package br.com.client.layout;

import java.util.ArrayList;
import java.util.List;

import br.com.client.UsuarioService;
import br.com.client.UsuarioServiceAsync;
import br.com.shared.domai.Usuario;
import br.com.shared.domai.UsuarioProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class GridUsuarios extends ContentPanel{
	
	private static final UsuarioProperties usuarioProp = GWT.create(UsuarioProperties.class);
	private final UsuarioServiceAsync usuarioService  = GWT.create(UsuarioService.class);
	private ListStore<Usuario> store;
	private List<Usuario> usuarios;
	
	public GridUsuarios() {
		
		ColumnConfig<Usuario, String> nomeUsuario = new ColumnConfig<Usuario, String>(usuarioProp.nome(), 200, "Nome do Usuário");
		ColumnConfig<Usuario, String> loginUsuario = new ColumnConfig<Usuario, String>(usuarioProp.nome(), 200, "Login do Usuário");
		
		List<ColumnConfig<Usuario, ?>> l = new ArrayList<ColumnConfig<Usuario, ?>>();
		l.add(nomeUsuario);
		l.add(loginUsuario);
		
		ColumnModel<Usuario> cm = new ColumnModel<Usuario>(l);
		
		store = new ListStore<Usuario>(usuarioProp.key());
		
		usuarioService.findAll(new AsyncCallback<List<Usuario>>() {
			
			@Override
			public void onSuccess(List<Usuario> result) {
				store.addAll(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("ERRO AO CARREGAR GRID DE SENHA!");
			}
		});
		
		Grid<Usuario> grid = new Grid<Usuario>(store, cm);
		grid.getView().setAutoExpandColumn(nomeUsuario);
		grid.getView().setAutoExpandColumn(loginUsuario);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);
		grid.getView().setAdjustForHScroll(true);
		
		this.add(grid, new MarginData(0));
	}

	public ListStore<Usuario> getStore() {
		return store;
	}

	public void setStore(ListStore<Usuario> store) {
		this.store = store;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		store.clear();
		store.addAll(usuarios);
		this.usuarios = usuarios;
	}
	
	
	

}
