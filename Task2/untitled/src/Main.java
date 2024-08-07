import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Card {
id // string
fingerprint //string
expiryDate // Date
}

this class is close to how payment gateways represent payment cards.
Assume that the id is unique across any card, but the fingerprint is not unique.
if two card objects have the same fingerprint,
then they are basically the same card but with maybe some different values regarding the expiryDate for example.

assume you have a list of cards, We want to filter them in a way that there is no two cards with the same fingerprint,
 so if the two have the same fingerprint, select the card with the highest expiryDate.*/
public class Main {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<Card>();
        List<Card> cards1 = new ArrayList<Card>();
        cards.add(new Card("1","Ace",new Date(2024-1900,8,29)));
        cards.add(new Card("2","Ace",new Date(2024-1900,12,5)));//true
        cards.add(new Card("3","Cold",new Date(2025-1900,2,4)));
        cards.add(new Card("4","Cold",new Date(2025-1900,8,29)));//true
        cards.add(new Card("5","Hot",new Date(2026-1900,2,23)));
        cards.add(new Card("6","Hot",new Date(2027-1900,9,12)));//true
        cards.add(new Card("7","Rainy",new Date(2025-1900,7,16)));
        cards.add(new Card("8","Rainy",new Date(2026-1900,8,24)));//true
        cards.add(new Card("9","Sunny",new Date(2025-1900,5,16)));
        cards.add(new Card("0","Sunny",new Date(2026-1900,4,28)));//true
        cards.add(new Card("11","Sunny",new Date(2028-1900,5,29)));
        cards.add(new Card("12","Sunny",new Date(2029-1900,4,28)));

        cards.add(new Card("10","BBBBBB",new Date(2026-1900,4,28)));

         System.out.println("____________________________________________________________________________________________________\n");
                cards.stream().forEach(card -> System.out.println(card.id+" "+card.fingerprint+" "+card.expires));

        System.out.println("____________________________________________________________________________________________________\n");
        /* cards.stream().filter(card -> {

            for (Card card2 : cards)
                if ((card.fingerprint.equals(card2.fingerprint ))&&(!card.id.equals(card2.id)))
                    if(card.expires.after(card2.expires))
                        return true;

            return false;


        }).forEach(card -> System.out.println(card.id+" "+card.fingerprint+" "+card.expires));

*/
         /*cards
                .stream()
                .collect(Collectors.groupingBy(card -> card.fingerprint))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= 2)
                .forEach(stringListEntry -> {
                    if(stringListEntry.getValue().get(0).expires.after(stringListEntry.getValue().get(1).expires))
                        cards1.add(stringListEntry.getValue().get(0));
                    else
                        cards1.add(stringListEntry.getValue().get(1));

                });*/


        cards1 = (List<Card>) cards.stream()
                .collect(Collectors.toMap(
                        card -> card.fingerprint,
                        card -> card,
                        (card1, card2) -> card1.expires.after(card2.expires) ? card1 : card2
                ))
                .values()
                .stream()
                .collect(Collectors.toList());





          System.out.println("____________________________________________________________________________________________________\n");
          cards1.stream().forEach(card -> System.out.println(card.id+" "+card.fingerprint+" "+card.expires));

 System.out.println("____________________________________________________________________________________________________\n");
  System.out.println("____________________________________________________________________________________________________\n");
   System.out.println("____________________________________________________________________________________________________\n");
   /* cards
                .stream()
                .collect(Collectors.groupingBy(card -> card.fingerprint))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= 2)
                .collect(Collectors.toCollection(() -> {

                    return null;
                }));*/

    }
}