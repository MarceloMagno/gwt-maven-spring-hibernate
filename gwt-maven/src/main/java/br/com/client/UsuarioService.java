package br.com.client;

import java.util.List;

import br.com.shared.domai.Usuario;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/usuarioService")
public interface UsuarioService extends RemoteService {
	
	public void saveOrUpdate(Usuario usuario) throws Exception;

	public void delete(Usuario usuario) throws Exception;

	public Usuario find(long id);

	public List<Usuario> findAll();
	
	public Usuario buscaUsuarioPorNome(String nome);
}