package org.asi.ui.customtextfield.client;

import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;
import org.asi.ui.customtextfield.CustomTextField;

@Connect(CustomTextField.class)
public class CustomTextFieldConnector extends TextFieldConnector {
    @Override
    public VCustomTextField getWidget() {
        return (VCustomTextField) super.getWidget();
    }
}
