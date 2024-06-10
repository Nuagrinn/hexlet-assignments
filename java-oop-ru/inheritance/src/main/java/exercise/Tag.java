package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    private String tagName;
    private Map<String, String> attributes;

    @Override
    public String toString() {
        String attributesString = attributesToString(attributes);
        if (attributesString.isEmpty()) {
            return String.format("<%s>", tagName);
        } else {
            return String.format("<%s %s>", tagName, attributesString);
        }
    }

    public static String attributesToString(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));
    }

}
// END
