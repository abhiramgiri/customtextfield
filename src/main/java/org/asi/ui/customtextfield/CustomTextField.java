package org.asi.ui.customtextfield;

import com.vaadin.data.Property;
import com.vaadin.shared.EventId;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;

public class CustomTextField extends TextField{
    /**
     * Constructs an empty <code>TextField</code> with no caption.
     */
    public CustomTextField() {
        super();
    }

    /**
     * Constructs an empty <code>TextField</code> with given caption.
     * 
     * @param caption
     *            the caption <code>String</code> for the editor.
     */
    public CustomTextField(String caption) {
        super(caption);
    }

    /**
     * Constructs a new <code>TextField</code> that's bound to the specified
     * <code>Property</code> and has no caption.
     * 
     * @param dataSource
     *            the Property to be edited with this editor.
     */
    public CustomTextField(Property dataSource) {
        super(dataSource);
    }

    /**
     * Constructs a new <code>TextField</code> that's bound to the specified
     * <code>Property</code> and has the given caption <code>String</code>.
     * 
     * @param caption
     *            the caption <code>String</code> for the editor.
     * @param dataSource
     *            the Property to be edited with this editor.
     */
    public CustomTextField(String caption, Property dataSource) {
        super(caption,dataSource);
    }

    /**
     * Constructs a new <code>TextField</code> with the given caption and
     * initial text contents. The editor constructed this way will not be bound
     * to a Property unless
     * {@link com.vaadin.data.Property.Viewer#setPropertyDataSource(Property)}
     * is called to bind it.
     * 
     * @param caption
     *            the caption <code>String</code> for the editor.
     * @param value
     *            the initial text content of the editor.
     */
    public CustomTextField(String caption, String value) {
        super(caption,value);
    }
   
     @Override
    public void changeVariables(Object source, Map<String, Object> variables) {
        if (variables.containsKey(EventId.CLICK_EVENT_IDENTIFIER)) {
                fireEvent(new ClickEvent(this));
            }
        super.changeVariables(source, variables);
    }
   

     public static class ClickEvent extends Component.Event {
public static final Method CLICK_METHOD;

        static {
            try {
                CLICK_METHOD = ClickListener.class
                        .getDeclaredMethod(EventId.CLICK_EVENT_IDENTIFIER,
                                new Class[] { ClickEvent.class });
            } catch (final java.lang.NoSuchMethodException e) {
                // This should never happen
                throw new java.lang.RuntimeException(e);
            }
        }
        public ClickEvent(Component source) {
            super(source);
        }
    }

     public interface ClickListener extends Serializable {
        public void click(ClickEvent event);
    }
    
      /**
     * Adds a click listener to the TextField.
     * 
     * @param listener
     *            The listener to attach to the TextField
     */
    public void addClickListener(ClickListener listener) {
        addListener(EventId.CLICK_EVENT_IDENTIFIER,
                ClickEvent.class, listener,
                ClickEvent.CLICK_METHOD);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #addClickListener(ClickListener)}
     **/
    @Deprecated
    public void addListener(ClickListener listener) {
        addClickListener(listener);
    }

    /**
     * Removes a click listener from the TextField.
     * 
     * @param listener
     *            The listener to remove
     */
    public void removeClickListener(ClickListener listener) {
        removeListener(EventId.CLICK_EVENT_IDENTIFIER,
                ClickEvent.class, listener);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #removeClickListener(ClickListener)}
     **/
    @Deprecated
    public void removeListener(ClickListener listener) {
        removeClickListener(listener);
    }
}
