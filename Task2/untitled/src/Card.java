/*Card {
id // string
fingerprint //string
expiryDate // Date
}*/

import java.util.Date;

public class Card {
    String id;
    String fingerprint;
    Date expires;

    public Card(String id, String fingerprint, Date date) {
        this.id = id;
        this.fingerprint = fingerprint;
        this.expires = date;
    }
}
