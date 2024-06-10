package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN

public class PairedTag extends Tag{

    private String tagBody;
    private List<Tag> childTags;
    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> childTags) {
        super.setTagName(tagName);
        super.setAttributes(attributes);
        this.tagBody = tagBody;
        this.childTags = childTags;
    }

    @Override
    public String toString() {
        String attributesString = attributesToString(getAttributes());
        String childTagsString = childTags.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());

        if (attributesString.isEmpty()) {
            return String.format("<%s>%s%s</%s>", getTagName(), tagBody, childTagsString, getTagName());
        } else {
            return String.format("<%s %s>%s%s</%s>", getTagName(), attributesString, tagBody, childTagsString, getTagName());
        }
    }

    public String getTagBody() {
        return tagBody;
    }

    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    public List<Tag> getChildTags() {
        return childTags;
    }

    public void setChildTags(List<Tag> childTags) {
        this.childTags = childTags;
    }
}
// END
