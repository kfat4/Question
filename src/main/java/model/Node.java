package model;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final char nodeName;
    private final Node parent;
    private final List<Node> childList = new ArrayList<>();
    private int level;

    public Node(char nodeName, Node parent) {
        this.nodeName = nodeName;
        this.parent = parent;
    }

    public char getNodeName() {
        return nodeName;
    }

    public List<Node> getChildList() {
        return childList;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Node getParent() {
        return parent;
    }


    public void addChildNode(Node node) {
        this.childList.add(node);
    }

    public void writeChildNodeInfo() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.level; i++) {
            sb.append("-");
        }

        sb.append(nodeName);

        System.out.println(sb);

        for (Node node : this.childList) {
            node.writeChildNodeInfo();
        }
    }

    public Node findNode(Character nodeName) {

        if (this.nodeName == nodeName) {
//            System.out.println(this.nodeName);
            return this;
        }

        for (Node childNode : this.childList) {

            Node node = childNode.findNode(nodeName);

            if (node != null) {
//                System.out.println(nodeName);
                return node;
            }
        }

        return null;
    }

    public boolean hasNode(Character nodeName) {

        if (this.nodeName == nodeName){
            return true;
        }

        for (Node childNode : this.childList) {

            Node node = childNode.findNode(nodeName);

            if (node != null) {

                return true;
            }
        }

        return false;
    }


}
