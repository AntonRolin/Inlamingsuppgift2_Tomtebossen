import java.util.*;


public class HierarchyMethods {

    private final List<TreeNode> allElements;

    public HierarchyMethods(List<TreeNode> allElements){
        this.allElements = allElements;
        userInput();
    }

    public List<String> getParents(String name) {
        if (checkIfValidName(name)) {

            List<String> allParentsList = new ArrayList<>();

            if (checkHasParent(name)) {

                String parent = getParent(name);
                allParentsList.add(parent);
                allParentsList.addAll(getParents(parent));
            }
            return allParentsList;
        }
        else {
            invalidName();
            return null;
        }
    }

    public List<String> getChildren(String name){
        if(checkIfValidName(name)){
            List<String> allChildrenList = new ArrayList<>();

            if(checkHasChildren(name)){

                List<TreeNode> childrenList = getDirectChildren(name);
                for (TreeNode child: childrenList) {
                    allChildrenList.add(child.getName());
                    allChildrenList.addAll(getChildren(child.getName()));
                }
            }
            return allChildrenList;
        }
        else {
            invalidName();
            return null;
        }
    }

    public void userInput(){
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Vad letar du efter?");
            System.out.println("1. Överordnade");
            System.out.println("2. Underordnade");
            System.out.println("3. Avsluta");
            int input = scan.nextInt();
            scan.nextLine();

            System.out.println("Skriv in ett namn: ");
            String inputLine = scan.nextLine();
                switch(input){
                    case 1:
                        List<String> parentList = getParents(inputLine);
                        System.out.println(parentList);
                        break;
                    case 2:
                        List<String> childrenList = getChildren(inputLine);
                        System.out.println(childrenList);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            System.out.println("\n\n");
        }
    }

    public void invalidName(){
        System.out.println("Namnet finns inte :(\nFörsök igen!");
    }

    public boolean checkHasParent(String name){
       return allElements.stream().map(TreeNode::getChildren).flatMap(Collection::stream).anyMatch(e -> e.checkName(name));
    }

    public boolean checkHasChildren(String name){
        return !(allElements.stream().filter(e -> e.getName().equalsIgnoreCase(name)).map(TreeNode::getChildren).mapToInt(Collection::size).sum() == 0);
    }

    public String getParent(String name){
        for (TreeNode element: allElements) {
            for (TreeNode child: element.getChildren()) {
                if(child.getName().equalsIgnoreCase(name))
                    return element.getName();
            }
        }
        return null;
    }

    public List<TreeNode> getDirectChildren(String name){
        for (TreeNode element: allElements) {
            if(element.getName().equalsIgnoreCase(name))
                return element.getChildren();
        }
        return null;
    }

    public boolean checkIfValidName(String name){
        return allElements.stream().anyMatch(e -> e.checkName(name));
    }
}
