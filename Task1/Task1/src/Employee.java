/* id, // Long
firstName, // String
lastName, // String
position, // enum: QA, BE, FE, HR
dateOfBirth // Date*/

import java.util.Date;

public class Employee {

        long id;
        String firstName;
        String lastName;
        Position position;
        Date dateOfBirth ;

        Employee(long id, String firstName, String lastName, Position position, Date dateOfBirth) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.position = position;
                this.dateOfBirth = dateOfBirth;
        }


}
