package fit.iuh.task;

import fit.iuh.common.Observer;

public class Manager implements Observer<String> {
  public void update(String status) {
    System.out.println("Manager nhận: " + status);
  }
}
