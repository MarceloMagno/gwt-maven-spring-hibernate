package br.com.client.layout;

import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class WestLayout {
	public ContentPanel westtLayout() {
		ContentPanel cp = new ContentPanel();
		//cp.setHeadingText("West");
		cp.add(new Label("West Content"));
		
		return cp;
	}

	public BorderLayoutData borderWestLayoutData() {
		BorderLayoutData d = new BorderLayoutData(.20);
		d.setMargins(new Margins(0, 5, 5, 5));
		d.setCollapsible(false);
		d.setSplit(false);
		d.setCollapseMini(false);

		return d;
	}
}