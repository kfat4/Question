package questionOne;

import model.Node;

import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
* 1. Belli bir formata göre hazırlanmış aşağıdaki stringden standard outputta aşağıdaki çıktıyı
üreten bir kod yazılmasını bekliyoruz.
 Varsayımlar ve kurallar:
• Verilen stringte her harf 2 defa kullanılır ve aynı 2 harf arasında kalan harfler child
harflerdir.
• Verilen stringin daima düzgün formatta verildiğini kabul ediyoruz. String formatının
kontrol edilmesine gerek yok.
• Standart outputta ağaç yapısını gösterecek şekilde bir çıktı beklenir.
• Verilen string sonsuz derinlikte bir ağaç olabilir.
Örnek :
Input:
abccbdeeda
Output:
a
--b
----c
--d
----e
* */

public class QuestionOne {

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {

        LinkedHashMap<Character, Node> map = new LinkedHashMap<>();

        String input = "abccbdeeda";
        Node firstNode = null;
        Node parentNode = null;

        for (int i = 0; i < input.length(); i++) {

            char character = input.charAt(i);

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

        firstNode.writeChildNodeInfo();

    }

}
