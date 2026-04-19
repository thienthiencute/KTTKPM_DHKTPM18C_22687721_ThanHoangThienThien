package fit.iuh.demo;

import fit.iuh.filesystem.FileComponent;
import fit.iuh.filesystem.FileLeaf;
import fit.iuh.filesystem.Folder;
import fit.iuh.ui.Button;
import fit.iuh.ui.Panel;
import fit.iuh.ui.UIComponent;

public class CompositeDemo {
  public static void main(String[] args) {
    System.out.println("======= COMPOSITE PATTERN DEMO - THIEN THIEN =======\n");

    // 1. THỰC HÀNH: HỆ THỐNG TẬP TIN (FILE SYSTEM)
    System.out.println(">>> 1. Tree Structure: FILE SYSTEM");

    // Tạo các thư mục (Composite)
    Folder root = new Folder("C: (System)");
    Folder documents = new Folder("Documents");
    Folder images = new Folder("Images");
    Folder music = new Folder("Music");

    // Tạo các tập tin (Leaf)
    FileLeaf readme = new FileLeaf("readme.txt");
    FileLeaf config = new FileLeaf("config.sys");
    FileLeaf avatar = new FileLeaf("avatar.png");
    FileLeaf song = new FileLeaf("thien-thien-song.mp3");

    // Lắp ghép cấu trúc cây
    root.add(readme);
    root.add(config);
    root.add(documents);
    root.add(images);

    documents.add(new FileLeaf("BaoCao_DesignPattern.docx"));
    documents.add(music); // Thư mục lồng trong thư mục

    images.add(avatar);
    music.add(song);

    // Hiển thị kết quả
    root.show("");

    System.out.println("\n----------------------------------------------------\n");

    // 2. THỰC HÀNH: GIAO DIỆN NGƯỜI DÙNG (UI SYSTEM)
    System.out.println(">>> 2. Tree Structure: USER INTERFACE");

    // Tạo khung hình chính
    Panel mainWindow = new Panel("Main Window");
    Panel sidebar = new Panel("Side Bar");
    Panel footer = new Panel("Footer");

    // Thêm nút bấm vào khung chính
    mainWindow.add(new Button("Home"));
    mainWindow.add(new Button("Settings"));
    mainWindow.add(sidebar);
    mainWindow.add(footer);

    // Thêm thành phần vào sidebar
    sidebar.add(new Button("Profile"));
    sidebar.add(new Button("Logout"));

    // Thêm thành phần vào footer
    footer.add(new Button("Copyright 2026 IUH"));

    // Hiển thị kết quả
    mainWindow.render("");

    System.out.println("\n====================================================");
  }
}