package br.com.client;

import br.com.client.layout.CenterLayout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;


public class GwtMaven implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		//RootPanel.get().add(asWidget());
		
		Widget con = asWidget();
		Viewport viewport = new Viewport();
		viewport.add(con);//, new MarginData(-10, -10, -10, -10));
		viewport.setStyleName("imgFundo");
		viewport.setPagePosition(-10, -10);
		RootPanel.get().add(viewport);
	}
	 
	 public Widget asWidget() {
		 
		    BorderLayoutContainer con = new BorderLayoutContainer();
		    con.setBorders(false);
		    
		    ContentPanel north = new ContentPanel();
		    ContentPanel west = new ContentPanel();
		    ContentPanel center = new ContentPanel();
		    center.setHeadingText("BorderLayout Example");
		    
		    VerticalLayoutContainer p = new VerticalLayoutContainer();
		    //p.setStyleName("img1");
		    
		    north.setHeaderVisible(false);
		    north.setBorders(false);
		    north.setBodyBorder(false);
		    north.add(p);		     
		    
		    center.setResize(false);
		    center.setHeaderVisible(false);
		    center.setBorders(false);
		    center.setBodyBorder(false);
		    center.add(new CenterLayout());
		    
		    TextButton btn = new TextButton("TESTE");
		    
		      btn.addSelectHandler(new SelectHandler() {
		 
		        @Override
		        public void onSelect(SelectEvent event) {
		         
		        }
		      });
		    
		    west.setHeaderVisible(false);
		    west.setBorders(false);
		    west.setBodyBorder(false);
		    
		    ContentPanel east = new ContentPanel();
		    east.setHeaderVisible(false);
		    east.setBorders(false);
		    east.setBodyBorder(false);
		    
		    ContentPanel south = new ContentPanel();
		    south.setHeaderVisible(false);
		    south.setBorders(false);
		    south.setBodyBorder(false);
		 
		    BorderLayoutData northData = new BorderLayoutData(110);
		    northData.setMargins(new Margins(5));
		    northData.setSplit(false);
		 
		    BorderLayoutData westData = new BorderLayoutData(150);
		    westData.setCollapsible(true);
		    westData.setSplit(false);
		    westData.setMargins(new Margins(0, 5, 0, 5));
		 
		    MarginData centerData = new MarginData();
		 
		    BorderLayoutData eastData = new BorderLayoutData(150);
		    eastData.setMargins(new Margins(0, 5, 0, 5));
		    eastData.setSplit(false);
		 
		    BorderLayoutData southData = new BorderLayoutData(100);
		    southData.setMargins(new Margins(5));
		    southData.setSplit(false);
		    		    
		    con.setNorthWidget(north , northData);
		    con.setWestWidget(west, westData);
		    con.setCenterWidget(center, centerData);
		    con.setEastWidget(east, eastData);
		    con.setSouthWidget(south, southData);
		 
		    SimpleContainer simple = new SimpleContainer();
		    simple.add(con, new MarginData(0, 70,10,70));
		 
		    return simple;
		  }
		 
}
