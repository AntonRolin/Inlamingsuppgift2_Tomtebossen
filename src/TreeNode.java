import java.util.ArrayList;
import java.util.List;


public class TreeNode {

    private final String name;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode(String name){
        this.name = name;
    }


    public void addChild(TreeNode child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public boolean checkName(String name){
        return this.name.equalsIgnoreCase(name);
    }
}
