package day03.phase2;

/**
 * @author jsingh
 */
public interface Observer {
    public void update();     
    public void setObservable(Observable observable);
}
