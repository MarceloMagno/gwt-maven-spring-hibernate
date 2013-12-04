package br.com.client.layout;

import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

public class LayoutPrincipal {
	
	private NorthLayout norteLayout;
	private WestLayout westLayout; 
	private CenterLayout centerLayout; 
	
	public LayoutPrincipal() {
		norteLayout = new NorthLayout();
		westLayout = new WestLayout();
		centerLayout = new CenterLayout();
	}
	public BorderLayoutContainer layoutFerroVelho() {
		BorderLayoutContainer con = new BorderLayoutContainer();
		con.setBorders(true);
		
		con.setNorthWidget(norteLayout.nortLayout(), norteLayout.borderNortLayoutData());

		con.setWestWidget(westLayout.westtLayout(), westLayout.borderWestLayoutData());

		con.setCenterWidget(centerLayout, centerLayout.borderCenterLayoutData());
		
		//con.setCenterWidget(centerLayout.getGridUsuarios(), centerLayout.borderCenterLayoutData());
     
		return con;
	}
	
	
	
	
}
