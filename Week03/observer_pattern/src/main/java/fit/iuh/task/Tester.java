package fit.iuh.task;

import fit.iuh.common.Observer;

public class Tester implements Observer<String> {
  public void update(String status) {
    System.out.println("Tester nhận: " + status);
  }
}
