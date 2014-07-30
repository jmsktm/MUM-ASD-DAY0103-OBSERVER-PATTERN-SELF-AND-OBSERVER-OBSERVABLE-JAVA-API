package day03.phase1;

/**
 * @author jsingh
 */
public interface Observable {    
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public Object getUpdate(Observer obj);    
}
