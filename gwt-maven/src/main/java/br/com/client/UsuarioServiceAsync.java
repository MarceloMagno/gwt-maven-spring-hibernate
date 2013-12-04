package br.com.client;

import java.util.List;

import br.com.shared.domai.Usuario;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UsuarioServiceAsync {

	void delete(Usuario usuario, AsyncCallback<Void> callback);

	void find(long id, AsyncCallback<Usuario> callback);

	void findAll(AsyncCallback<List<Usuario>> callback);

	void saveOrUpdate(Usuario usuario, AsyncCallback<Void> callback);

	void buscaUsuarioPorNome(String nome, AsyncCallback<Usuario> callback);

}
