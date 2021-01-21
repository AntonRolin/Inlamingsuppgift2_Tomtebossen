import java.util.ArrayList;
import java.util.List;


public class Database{

    TreeNode tomten = new TreeNode("Tomten");
    TreeNode glader = new TreeNode("Glader");
    TreeNode butter = new TreeNode("Butter");
    TreeNode troger = new TreeNode("Tröger");
    TreeNode trotter = new TreeNode("Trötter");
    TreeNode blyger = new TreeNode("Blyger");
    TreeNode radjuret = new TreeNode("Rådjuret");
    TreeNode nyckelpigan = new TreeNode("Nyckelpigan");
    TreeNode haren = new TreeNode("Haren");
    TreeNode raven = new TreeNode("Räven");
    TreeNode skumtomten = new TreeNode("Skumtomten");
    TreeNode dammrattan = new TreeNode("Dammråttan");
    TreeNode grasuggan = new TreeNode("Gråsuggan");
    TreeNode myran = new TreeNode("Myran");
    TreeNode bladlusen = new TreeNode("Bladlusen");


    public Database(){
        tomten.addChild(glader);
        tomten.addChild(butter);

        glader.addChild(troger);
        glader.addChild(trotter);
        glader.addChild(blyger);

        butter.addChild(radjuret);
        butter.addChild(nyckelpigan);
        butter.addChild(haren);
        butter.addChild(raven);

        trotter.addChild(skumtomten);

        skumtomten.addChild(dammrattan);

        raven.addChild(grasuggan);
        raven.addChild(myran);

        myran.addChild(bladlusen);

        new HierarchyMethods(getAllElements());
    }

    public List<TreeNode> getAllElements(){
        List<TreeNode> allElements = new ArrayList<>();

        allElements.add(tomten);
        allElements.add(glader);
        allElements.add(butter);
        allElements.add(troger);
        allElements.add(trotter);
        allElements.add(blyger);
        allElements.add(radjuret);
        allElements.add(nyckelpigan);
        allElements.add(haren);
        allElements.add(raven);
        allElements.add(skumtomten);
        allElements.add(dammrattan);
        allElements.add(grasuggan);
        allElements.add(myran);
        allElements.add(bladlusen);

        return allElements;
    }

}
