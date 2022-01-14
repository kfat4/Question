package questionThree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionThree {

    /*
    * 3. 9 büyüklüğündeki bir listeyi 1 den 9 a kadar tekrar etmeyecek şekilde random olarak
dolduran ve kaç kere random kodunun çağrıldığını output a yazan kodu yazınız.
 Varsayımlar ve kurallar:
• İndise eklenen bir rakam tekrar edemez.
• Eklenecek rakam hardcode olarak eklenemez.
Örnek 1:
5,2,3,8,1,4,6,9,7
Random fonksiyonu 24 kere çalışmıştır
Örnek 2:
4,1,3,2,7,9,5,6,8
Random fonksiyonu 86 kere çalışmıştır
    * */


    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < 8; i++) {

            while (true) {
                count++;
                int randomNum = ThreadLocalRandom.current().nextInt(1, 9);
                if (!numberList.contains(randomNum)) {
                    numberList.add(randomNum);
                    break;
                }
            }
        }

        System.out.println(numberList);
        System.out.printf("Random fonksiyonu %d kere çalışmıştır", count);

    }

}
