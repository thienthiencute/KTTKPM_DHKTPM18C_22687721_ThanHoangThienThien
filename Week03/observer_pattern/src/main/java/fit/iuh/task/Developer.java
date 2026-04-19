package fit.iuh.task;

import fit.iuh.common.Observer;

public class Developer implements Observer<String> {
  public void update(String status) {
    System.out.println("Developer nhận: " + status);
  }
}
