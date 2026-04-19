package fit.iuh.stock;

import fit.iuh.common.Observer;

public class Investor implements Observer<Double> {
  private String name;

  public Investor(String name) {
    this.name = name;
  }

  @Override
  public void update(Double price) {
    System.out.println(name + " nhận thông báo: Giá cổ phiếu = " + price);
  }
}

