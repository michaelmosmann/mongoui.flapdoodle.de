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

package de.flapdoodle.mongoui;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

import de.flapdoodle.mongoui.ui.ConfigDatabase;


public class MongoUIApplication  extends Application{

	@Override
	public void init() {
		final Window window = new Window("My Vaadin Application");
		setMainWindow(window);
		Button button = new Button("Click Me");
		button.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				window.addComponent(new Label("Thank you for clicking: "+"Fuh"));
			}
		});
		window.addComponent(button);
		
		window.addComponent(new ConfigDatabase());
	}

}
