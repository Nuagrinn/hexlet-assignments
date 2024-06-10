package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes) {
        super.setTagName(tagName);
        super.setAttributes(attributes);
    }

}
// END
