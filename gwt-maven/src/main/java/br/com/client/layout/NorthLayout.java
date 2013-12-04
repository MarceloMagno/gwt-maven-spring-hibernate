package br.com.client.layout;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class NorthLayout {

	public ContentPanel nortLayout() {
		ContentPanel cp = new ContentPanel();

		cp.add(new Label("North Content"));
		ToolButton toolBut = new ToolButton(ToolButton.GEAR);
		cp.addTool(toolBut);
		cp.addTool(new ToolButton(ToolButton.DOUBLEDOWN));
		cp.addTool(new ToolButton(ToolButton.CLOSE));
		cp.setWidget(new HTML("This is an HTML Widget in a ContentPanel."));
		cp.addButton(new TextButton("Ok"));

		Image imagem = new Image("http://www.criacaodelogomarcas.com/imagens/meiod.jpg");

		cp.add(imagem);

		return cp;
	}
	
	public BorderLayoutData borderNortLayoutData() {
		BorderLayoutData d = new BorderLayoutData(.20);

		d.setMargins(new Margins(0));
		d.setCollapsed(false);
		d.setCollapseHidden(false);

		// d.setSize(0);
		d.setCollapsible(false);
		d.setSplit(false);

		return d;
	}
}
