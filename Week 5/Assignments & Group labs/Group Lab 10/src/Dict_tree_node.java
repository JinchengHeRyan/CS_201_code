import java.util.ArrayList;

public class Dict_tree_node {
    ArrayList<Dict_tree_node> children;
    Dict_tree_node parent;
    char data;

    public Dict_tree_node(char word) {
        this.data = word;
        this.children = new ArrayList<Dict_tree_node>();
    }

    public Dict_tree_node add_node(char word) {
        Dict_tree_node child_node = new Dict_tree_node(word);
        child_node.parent = this;
        this.children.add(child_node);
        return child_node;
    }
}