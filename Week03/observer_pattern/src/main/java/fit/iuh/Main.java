package fit.iuh;

import fit.iuh.stock.Investor;
import fit.iuh.stock.Stock;
import fit.iuh.task.Developer;
import fit.iuh.task.Manager;
import fit.iuh.task.Task;
import fit.iuh.task.Tester;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    // stock
    System.out.println("=== STOCK ===");
    Stock stock = new Stock();

    stock.attach(new Investor("A"));
    stock.attach(new Investor("B"));

    stock.setPrice(100);
    stock.setPrice(150);

    // task
    System.out.println("\n=== TASK ===");
    Task task = new Task();

    task.attach(new Developer());
    task.attach(new Tester());
    task.attach(new Manager());

    task.setStatus("In Progress");
    task.setStatus("Completed");
  }
}