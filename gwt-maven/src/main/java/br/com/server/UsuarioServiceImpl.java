package br.com.server;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.client.UsuarioService;
import br.com.shared.Validator;
import br.com.shared.domai.Usuario;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Service("usuarioService")
public class UsuarioServiceImpl extends RemoteServiceServlet implements UsuarioService {

	private static final long serialVersionUID = -6547737229424190373L;
	private static final Log LOG = LogFactory.getLog(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	public void saveOrUpdate(Usuario usuario) throws Exception {
				if (Validator.isBlank(usuario.getNome()) || Validator.isBlank(usuario.getSenha())) {
				      throw new IllegalArgumentException("Porfavor digite o nome do titulo e o nome do altor do livro!");
				}
				
				try {
					if (usuario.getId() == null) {
						usuarioDao.save(usuario);
					} else {
						usuarioDao.update(usuario);
					}
				} catch (Exception e) {
					LOG.error(e);
					throw e;
				}
		
	}

	public void delete(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Usuario find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Usuario> findAll() {
		List<Usuario> list = usuarioDao.findAll();
		return list;
	}

	@Override
	public Usuario buscaUsuarioPorNome(String nome) {
		try {
			
			Usuario usuario;
			
			usuario = usuarioDao.buscaUsuarioPorNome(nome);
		
			return usuario;
			
		} catch (Exception e) {
			LOG.error(e);
			throw e;
		}
	}

}
