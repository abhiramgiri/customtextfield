/*
 * Copyright 2014 Abhiram.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.asi.ui.customtextfield.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.vaadin.client.ui.VTextField;
import com.vaadin.shared.EventId;

/**
 *
 * @author Abhiram
 */
public class VCustomTextField extends VTextField implements ClickHandler{
    public VCustomTextField(){
        super();
        addClickHandler(this);
    }
    @Override
    public void onClick(ClickEvent event) {
        if (client != null && client.hasEventListeners(this, EventId.CLICK_EVENT_IDENTIFIER)) {
            client.updateVariable(paintableId, EventId.CLICK_EVENT_IDENTIFIER, "", true);
        }
    }
}
