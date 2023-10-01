package kosten_app.observable;

import java.util.Observer;

public interface Observable {
    public void addObserver(Observer obs);
    public void removeObserver(Observer obs);
    public void notifyObservers();
}
