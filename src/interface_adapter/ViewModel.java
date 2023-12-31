package interface_adapter;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    protected final String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return viewName;
    }

    public abstract void firePropertyChanged();

    public abstract void firePropertyChanged(String propertyName);

    public abstract void addPropertyChangeListener(PropertyChangeListener listener);


}
