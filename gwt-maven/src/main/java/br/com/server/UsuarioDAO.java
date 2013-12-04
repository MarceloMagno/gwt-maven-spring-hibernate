package br.com.server;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.shared.domai.Usuario;

@Repository("usuarioDao")
public class UsuarioDAO extends GenericDAO<Usuario> {
	
	@Transactional
	public Usuario buscaUsuarioPorNome(String nome) {	
		try {
			String queryStr = "SELECT u FROM Usuario u where u.login = '"+nome+"'";
			Query query = entityManager.createQuery(queryStr);
			if( query.getResultList().size() > 0){
				Usuario resultList = (Usuario) query.getResultList().get(0);
				return resultList;				
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
            this.entityManager.getTransaction().getRollbackOnly();
		}
		return null;
	}
	
}
