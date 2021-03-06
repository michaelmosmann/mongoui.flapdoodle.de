/**
 * Copyright (C) 2011 Michael Mosmann <michael@mosmann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.flapdoodle.mongoui.ui;

import com.vaadin.data.util.BeanItem;
import com.vaadin.event.Action;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class ConfigDatabase extends VerticalLayout {

	
	public ConfigDatabase() {
		final FormData data = new FormData();
		final DatabaseForm form = new DatabaseForm(new BeanItem<ConfigDatabase.FormData>(data));
		HorizontalLayout footer = new HorizontalLayout();
		Button button = new Button("Verbinden");
		button.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				form.commit();
				System.out.println("Connect to: "+data.getDatabaseName()+":"+data.getPort());
				
			}
		});
		footer.addComponent(button);
		form.setFooter(footer);
		addComponent(form);
	}
	
	static class DatabaseForm extends Form {

		public DatabaseForm(BeanItem<FormData> itemDatasource) {

			setCaption("Connection Details");

			// Create our layout (3x3 GridLayout)
			GridLayout ourLayout = new GridLayout(3, 3);

			// Use top-left margin and spacing
			ourLayout.setMargin(true, false, false, true);
			ourLayout.setSpacing(true);

			setLayout(ourLayout);

			// Set up buffering
			setWriteThrough(false); // we want explicit 'apply'
			setInvalidCommitted(false); // no invalid values in datamodel

			setItemDataSource(itemDatasource);
			getField("databaseName").setRequired(true);
		}
	}
	
	public static class FormData {
		String _databaseName;
		int _port;
		
		public String getDatabaseName() {
			return _databaseName;
		}
		
		public void setDatabaseName(String databaseName) {
			_databaseName = databaseName;
		}
		
		public int getPort() {
			return _port;
		}
		
		public void setPort(int port) {
			_port = port;
		}
		
	}
}
