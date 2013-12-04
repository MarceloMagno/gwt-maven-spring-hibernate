package br.com.shared.domai;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface UsuarioProperties extends PropertyAccess<Usuario> {

	@Path("id")
	ModelKeyProvider<Usuario> key();

	@Path("usuario")
	LabelProvider<Usuario> usuarioLabel();

	ValueProvider<Usuario, String> nome();

	ValueProvider<Usuario, String> login();

	ValueProvider<Usuario, String> senha();

	// ValueProvider<Senha, Date> senhaCriadaTime();

}
