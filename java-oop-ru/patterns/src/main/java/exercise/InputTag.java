package exercise;

// BEGIN
public class InputTag implements TagInterface {

    private String type;

    private String value;
    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", this.getType(), this.getValue());
    }
}
// END
