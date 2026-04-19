package fit.iuh;

public class XmlToJsonAdapter implements JsonService{
  private XmlSystem xmlSystem;

  public XmlToJsonAdapter(XmlSystem xmlSystem) {
    this.xmlSystem = xmlSystem;
  }

  @Override
  public String getJsonData() {
    String xml = xmlSystem.getXmlData();
    // Giả lập logic chuyển đổi
    return "{ \"data\": { \"name\": \"Thien Thien\" } }";
  }
}
