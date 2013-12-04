package br.com.client.layout;

import java.util.List;

import br.com.client.UsuarioService;
import br.com.client.UsuarioServiceAsync;
import br.com.shared.domai.Usuario;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel.Encoding;
import com.sencha.gxt.widget.core.client.form.FormPanel.Method;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;

public class CenterLayout extends ContentPanel{
	
	private FramedPanel panel;
	private FramedPanel panelGrid;
	private TextField nome;
	private TextField login;
	private PasswordField senha;
	private Usuario usuario;
	private GridUsuarios gridUsuarios;
	private final UsuarioServiceAsync usuarioService  = GWT.create(UsuarioService.class);
	
	public CenterLayout() {
		panel = new FramedPanel();
		panelGrid = new FramedPanel();
		gridUsuarios = new GridUsuarios();
		
		
		
		this.add(createColumnForm(), new  MarginData(5));
	}

	public BorderLayoutData borderCenterLayoutData() {
		BorderLayoutData d = new BorderLayoutData(.20);
		
		
		d.setMargins(new Margins(0, 5, 5, 0));

		return d;
	}
	
	 public FramedPanel createColumnForm() {
		      
		      panel.setHeadingText("Criar Usuário");
		      panel.setButtonAlign(BoxLayoutPack.CENTER);
		      panel.setWidth(350);
		      //panel.setPixelSize(350, 250);
		      panel.getElement().setMargins(10);
		 
		      final FormPanel form = new FormPanel();
		      form.setAction("myurl");
		      form.setEncoding(Encoding.MULTIPART);
		      form.setMethod(Method.POST);
		      panel.add(form);
		 
		      VerticalLayoutContainer p = new VerticalLayoutContainer();
		      form.add(p);
		 
		      nome = new TextField();
		      nome.setAllowBlank(false);
		      p.add(new FieldLabel(nome, "Nome"), new VerticalLayoutData(-18, -1));
		      
		      login = new TextField();
		      login.setAllowBlank(false);
		      p.add(new FieldLabel(login, "Login"), new VerticalLayoutData(-18, -1));
		      
		      
		      senha = new PasswordField();
		      nome.setAllowBlank(false);
		      p.add(new FieldLabel(senha, "Senha"), new VerticalLayoutData(-18, -1));
		 
		      TextButton btn = new TextButton("Limpar");
		      btn.addSelectHandler(new SelectHandler() {
		 
		        @Override
		        public void onSelect(SelectEvent event) {
		          form.reset();
		        }
		      });
		 
		      panel.addButton(btn);
		 
		      btn = new TextButton("Salvar");
		      btn.addSelectHandler(new SelectHandler() {
		 
		        @Override
		        public void onSelect(SelectEvent event) {
		        	
		        	usuario = new Usuario();
		        	usuario.setNome(nome.getText());
		        	usuario.setLogin(login.getText());
		        	usuario.setSenha(senha.getText());
		        	
		        	usuarioService.buscaUsuarioPorNome(login.getText(), new AsyncCallback<Usuario>() {
						
						@Override
						public void onSuccess(Usuario result) {
							if(result == null){
								usuarioService.saveOrUpdate(usuario, new AsyncCallback<Void>() {
									
									@Override
									public void onSuccess(Void result) {
										Window.alert("Usuário Criado com Sucesso!");	
										form.reset();
										carregarUsuarios();
									}
									
									@Override
									public void onFailure(Throwable caught) {
										Window.alert("ERROR ao tenta Salvar Usuário!");
									}
								});
							}else{
								Window.alert("Usuário já Cadastrado!");
							}
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("ERROR ao tenta Salvar Usuário!");
							
						}
					});
		        	
		        	
		        }
		        
		      });
		      
		      panel.addButton(btn);

		      panelGrid = new FramedPanel();
		      panelGrid.setHeaderVisible(false);
		      panelGrid.setPixelSize(350, 350);
		      panelGrid.add(gridUsuarios);
		      p.add(panelGrid, new VerticalLayoutData(1, 0.7));
		      
		    return panel;
	 }
	 
	 private void carregarUsuarios(){
		 
		 usuarioService.findAll(new AsyncCallback<List<Usuario>>() {
			
			@Override
			public void onSuccess(List<Usuario> result) {
				getGridUsuarios().setUsuarios(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("ERROR ao tentar atualizar lista de Usuários");
			}
		});
		 
	 }

	public GridUsuarios getGridUsuarios() {
		return gridUsuarios;
	}

	public void setGridUsuarios(GridUsuarios gridUsuarios) {
		this.gridUsuarios = gridUsuarios;
	}
	 
	 
}
