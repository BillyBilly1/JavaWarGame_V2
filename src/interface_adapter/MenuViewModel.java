package interface_adapter;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;

public class MenuViewModel extends ViewModel {

    public static final String viewName = "menu";

    public MenuViewModel() {
        super("menu");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void firePropertyChanged(String propertyName) {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
