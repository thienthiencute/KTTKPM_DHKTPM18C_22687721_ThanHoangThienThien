import fit.iuh.JsonService;
import fit.iuh.JsonSystem;
import fit.iuh.JsonToXmlAdapter;
import fit.iuh.XmlService;
import fit.iuh.XmlSystem;
import fit.iuh.XmlToJsonAdapter;


public class Main {

  public static void main(String[] args) {
    System.out.println("======= HỆ THỐNG CHUYỂN ĐỔI ĐA NĂNG EASTY =======");
    System.out.println("Nhân sự thực hiện: Thien Thien\n");

    // --- KỊCH BẢN 1: XML SANG JSON ---
    System.out.println(">>> Chiều 1: XML sang JSON");
    XmlSystem oldXmlSystem = new XmlSystem();
    JsonService xmlToJson = new XmlToJsonAdapter(oldXmlSystem);
    System.out.println("Kết quả: " + xmlToJson.getJsonData());

    System.out.println("\n-----------------------------------------------\n");

    // --- KỊCH BẢN 2: JSON SANG XML ---
    System.out.println(">>> Chiều 2: JSON sang XML");
    JsonSystem oldJsonSystem = new JsonSystem();
    XmlService jsonToXml = new JsonToXmlAdapter(oldJsonSystem);
    System.out.println("Kết quả:\n" + jsonToXml.getXmlData());

    System.out.println("=================================================");
  }
}