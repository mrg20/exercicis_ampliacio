package ex2parcial2016v2;

import java.util.List;

/**
 * Created by noki on 22/05/17.
 */
public class SumVisitor implements Visitor {
    private int leaf_info = 0;

    @Override
    public int visit(Leaf leaf) {
        if (leaf.hasBeenVisited()){
            leaf.isVisited();
            return leaf.getInfo();
        }
        return 0;
    }

    @Override
    public int visit(Composite composite) {
        List<Component> components = composite.getComponents();
        for (Component component : components) {
            if (composite.hasBeenVisited()) {
                leaf_info += component.accept(this);
                composite.isVisited();
            }
        }
        return leaf_info;
    }
}