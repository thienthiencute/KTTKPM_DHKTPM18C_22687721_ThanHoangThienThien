package fit.iuh.common;

public interface Subject<T>{
  void attach(Observer<T> o);
  void detach(Observer<T> o);
  void notifyObservers();
}
