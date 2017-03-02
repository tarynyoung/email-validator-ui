package com.example.email_validator_ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ValidatorUI extends UI {
	 
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		
		final TextField email = new TextField();
        email.setCaption("Enter email here:");
		
        Button button = new Button("Enter");
        button.addClickListener( e -> {
            layout.addComponent(new Label(Validate.Validate(email.getValue())));
        });
    
        layout.addComponents(email, button);
        layout.setMargin(true);
        layout.setSpacing(true);
    
        setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	public static class MyUIServlet extends VaadinServlet {
	}
}
