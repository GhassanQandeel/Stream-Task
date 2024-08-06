/*
Employee {
id, // Long
firstName, // String
lastName, // String
position, // enum: QA, BE, FE, HR
dateOfBirth // Date
}

1. Use streams to create a comma separated string with employees ids.
2. Use streams to create a Map<Long, Employee> where the key is the employee id, and the value is the employee itself.
3. Define a method that takes an Employee and prints a salary based on the position. then call it from the forEach.
*/

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {



        List<Employee> employees = new ArrayList<Employee>();
        String comma_separated_ids = "";
        StringBuilder temp = new StringBuilder();

        employees.add(new Employee(1,"Ghassan","Qandeel",Position.QA,new Date(2003,11,15)));
        employees.add(new Employee(2,"Omar","AL jamal",Position.HR,new Date(2022,2,14)));
        employees.add(new Employee(3,"Lafi","qandeel",Position.BE,new Date(1999,8,8)));
        employees.add(new Employee(4,"Ahmad ","badwan",Position.FE,new Date(1972,7,2)));
        employees.add(new Employee(5,"sohaib","badaha",Position.BE,new Date(1988,5,8)));
        employees.add(new Employee(6,"Ahmad","hamdan",Position.QA,new Date(1745,9,5)));

        /*
         1. Use streams to create a comma separated string with employees ids.
         i am  understand you want to put the ids of employees in string between them commas
        */
        temp = employees.stream().mapToLong(employee -> employee.id).collect(StringBuilder ::new, (stringBuilder, value) -> stringBuilder.append(value+","), StringBuilder::append);
        temp.deleteCharAt(temp.length()-1);




        System.out.println("____________________________________________________________________________________________________\n");
        System.out.println("Q1: Use streams to create a comma separated string with employees ids.");
        System.out.println("Solution is : "+ temp +"\n");
        System.out.println("____________________________________________________________________________________________________\n");



//        2. Use streams to create a Map<Long, Employee> where the key is the employee id, and the value is the employee itself.
          Map<Long,Employee> Q2 = new HashMap<Long,Employee>();

          //employees.stream().forEach(employee -> Q2.put(employee.id, employee)); // its declarative , as i know foreach can consider  a declarative  ??
/*
          employees
           .stream()
           .map(employee -> Q2.put(employee.id,employee))
           .collect(Collectors.toSet());
*/
        //second way (This maybe not as required I am use map in some strange way )





        System.out.println("____________________________________________________________________________________________________\n");
        System.out.println("Q2: Use streams to create a Map<Long, Employee> where the key is the employee id, and the value is the employee itself.");


        /*
        employees
                .stream()
                .collect(Collectors.toMap(employee -> employee.id, employee -> employee))
                .forEach((aLong, employee) -> System.out.println(aLong + ": " + employee.toString()));
         */

        //this way maybe can consider a logical way but without declare map Q2 , i create it from stream and print it




         Q2=employees
                .stream()
                .collect(Collectors.toMap(employee -> employee.id, employee -> employee));




        System.out.println("The request map is :"+Q2);
        System.out.println("____________________________________________________________________________________________________\n");

        /*if (Position.HR==employee.position) System.out.println("Salary for "+employee.firstName+" "+employee.lastName+"("+employee.position+") is :"+1000+"$");
        else if (Position.BE==employee.position) System.out.println("Salary for "+employee.firstName+" "+employee.lastName+"("+employee.position+") is :"+2000+"$");
        else if (Position.FE==employee.position) System.out.println("Salary for "+employee.firstName+" "+employee.lastName+"("+employee.position+") is :"+3000+"$");
        else System.out.println("Salary for "+employee.firstName+" "+employee.lastName+"("+employee.position+") is :"+1000+"$");*/






       SomeMethod someMethod = employee ->
               System.out.println("Salary for "+employee.firstName+" " +
                       ""+employee.lastName+"("+employee.position+") is :" +
                       ""+employee.position.value*1000+"$");
            // I can do without if statements by define values for enum class ( I don't know if there are some else ways )


        //3. Define a method that takes an Employee and prints a salary based on the position. then call it from the forEach.
        System.out.println("____________________________________________________________________________________________________\n");
        System.out.println("Q3: Define a method that takes an Employee and prints a salary based on the position. then call it from the forEach.");
        System.out.println("Solution is : ");
        employees.forEach(someMethod::someMethod);
        System.out.println("____________________________________________________________________________________________________\n");






    }
}