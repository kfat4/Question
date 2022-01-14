package questionTwo;

import model.Node;

import java.util.LinkedHashMap;


/*
* 2. Bir ağaçta verilen iki düğüm (node) arasındaki patikayı (path) nasıl bulursunuz? Kodu
yazınız. Kod yazamaz iseniz algoritmanızı anlatınız.
• Örnek ağaç:
a
 -b
 --c
 ---d
 --e
 ---f
 -g
• Algoritmaya ek olarak, yukarıdaki örnek için f ile d arasındaki patikayı yazı ile yazınız
•
• Algoritmaya ek olarak, yukarıdaki örnek için g ile c arasındaki patikayı yazı ile yazınız
* */


public class QuestionTwo {

    public static void main(String[] args) {
        String treeNodeCode = "abcddceffebgg";
        Node mainTreeNode = createTree(treeNodeCode);
        System.out.println("Tree child node info");
        mainTreeNode.writeChildNodeInfo();
        System.out.println("**************************************");
        System.out.println("path from start node f to end node d");

        writeRoadPath(mainTreeNode,'f','d');
        System.out.println("**************************************");
        System.out.println("path from start node g to end node c");
        writeRoadPath(mainTreeNode,'g','c');

    }

    private static Node createTree(String treeNodeCode) {
        LinkedHashMap<Character, Node> map = new LinkedHashMap<>();


        Node firstNode = null;
        Node parentNode = null;

        for (int i = 0; i < treeNodeCode.length(); i++) {

            char character = treeNodeCode.charAt(i);

            if (i == 0) {
                Node node = new Node(character, null);
                node.setLevel(0);
                parentNode = node;
                firstNode = node;
                map.put(character, node);
                continue;
            }

            Node currentNode = map.get(character);

            if (currentNode == null) {
                Node node = new Node(character, parentNode);
                node.setLevel(parentNode.getLevel() + 2);
                parentNode.addChildNode(node);
                map.put(character, node);
                parentNode = node;
            } else {
                parentNode = currentNode.getParent();
            }

        }
        return firstNode;
    }


    private static void writeRoadPath(Node mainNode, Character startNodeCh, Character targetNodeCh) {

        Node startNode = mainNode.findNode(startNodeCh);
        char lastNodeName = startNode.getNodeName();

        Node parentNode = startNode.getParent();

        boolean flag = true;

        while (flag) {
            if (parentNode.hasNode(targetNodeCh)) {

                System.out.printf( "%s -> %s\n" ,lastNodeName , parentNode.getNodeName());
                lastNodeName = parentNode.getNodeName();

                parentNode = findNodeInChildNodes(parentNode, targetNodeCh);


                flag = !(lastNodeName == targetNodeCh);

            } else {

                System.out.printf( "%s -> %s\n" ,lastNodeName , parentNode.getNodeName());

                lastNodeName = parentNode.getNodeName();
                parentNode = parentNode.getParent();
                flag = !(lastNodeName == targetNodeCh);

            }
        }


    }

    private static Node findNodeInChildNodes(Node node, char nodeName) {

        for (Node child : node.getChildList()) {
            if (child.hasNode(nodeName)) {
                return child;
            }
        }
        return node;
    }

}
