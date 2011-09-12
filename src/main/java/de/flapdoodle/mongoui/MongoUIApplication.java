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
