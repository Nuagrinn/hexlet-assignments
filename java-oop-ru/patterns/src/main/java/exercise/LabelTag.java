package exercise;

public class LabelTag implements TagInterface {
    private String label;
    private TagInterface tagInterface;

    public LabelTag(String label, TagInterface tagInterface) {
        this.label = label;
        this.tagInterface = tagInterface;
    }

    public String render() {
        return String.format("<label>%s%s</label>",
                this.label, this.tagInterface.render());
    }

}
