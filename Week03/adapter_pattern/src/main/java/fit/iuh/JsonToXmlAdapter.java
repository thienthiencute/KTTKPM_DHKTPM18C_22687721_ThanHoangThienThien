package fit.iuh;

public class JsonToXmlAdapter implements XmlService{
  private JsonSystem jsonSystem;

  public JsonToXmlAdapter(JsonSystem jsonSystem) {
    this.jsonSystem = jsonSystem;
  }

  @Override
  public String getXmlData() {
    String json = jsonSystem.getJsonData();
    // Giả lập logic chuyển đổi
    return "<response>\n  <name>Thien Thien</name>\n</response>";
  }
}
