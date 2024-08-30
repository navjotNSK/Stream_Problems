package org.example.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamWorkshopPractise {





    public static void main(String[] args){

        // 1) Remove duplicates from string and return in same order".
        String s = "dabfcadef";
        System.out.println( s.chars().distinct().toString());
        System.out.println(s);

        // 2)  Given a sentence find the word that has the highest length. The solution is:
        String str1 = "I am interested123455 to grow in my organization";
        String[] arr = str1.split(" ");
        Arrays.stream(str1.split(" ")).sorted(Comparator.comparing(String::length)).skip(arr.length - 1).forEach(System.out::println);



        String maxString = Arrays.stream(str1.split(" ")).max(Comparator.comparing(String::length).reversed()).get();
        System.out.println("The maxString is: " + maxString);

        // 3) Given a sentence find the word that has the 2nd (Nth) highest length.
        String secMaxString = Arrays.stream(str1.split(" ")).max(Comparator.comparing(String::length)).stream().skip(1).toString();
        System.out.println("The second maxString is: " + secMaxString);

        // Q4) Find the length of the longest word
        Integer maxLength = Arrays.stream(str1.split(" ")).max(Comparator.comparing(String::length)).map(str->str.length()).get();
        System.out.println("The max length is: " + maxLength);

        // Q5). Find the 2nd highest length word in the given sentence
        System.out.println(Arrays.stream(str1.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).mapToInt(String::length).findFirst().orElse(-1));

        // Q6) Given a sentence, find the number of occurrence of each word.
        String str2 = "the quick brown fox jumps right over the little lazy dog little";


        Arrays.stream(str2.split(" ")).collect(Collectors.toMap(w->w,l->1L, Long::sum));

        Arrays.stream(str2.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        // Q7) Given a word, find the occurrence of Each Character
        str2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        // Q8) There is a list of Employees and Employee object has a field called e-mail. Find the list of domains ( gmail.com, yahoo.com..) and the no of occurrences for each domain.
        Employee emp1 = new Employee("nav@gmail.com");
        Employee emp2 = new Employee("nav@yahoo.com");
        Employee emp3 = new Employee("navu@gmail.com");
        List<Employee> list = Arrays.asList(emp1,emp3,emp2);
        Map<String , Long> map = list.stream().collect(Collectors.groupingBy(e-> e.getEmail().substring(e.getEmail().indexOf("@") + 1),Collectors.counting()));
        System.out.println(map);


        // Q9) Given a string, find the words with the maximum number of vowels.
        //
        //       "The quick brown fox jumps right over the little lazy dog."
        //        Maximum Number of Vowels: 2
        //        output Words: quick, over, little  ( because each word has maximum of 2 vowels)
        System.out.println(Arrays.stream(str2.split(" ")).map(e->e.replaceAll("^aeiouAEIOU" , "").length()).max(Comparator.naturalOrder()).get());

        Arrays.stream(str2.split(" "))
                .filter(e -> !e.replaceAll("[^aeiouAEIOU]", "").isEmpty())
                .forEach(System.out::println);

        Arrays.stream(str2.split(" "))
                .map(e -> e.replaceAll("[^aeiouAEIOU]", "").length())
                .forEach(System.out::println);

        Arrays.stream(str2.split(" "))
                .map(e -> e + " " + e.replaceAll("[^aeiouAEIOU]", "").length())
                .forEach(System.out::println);

         // Q10) Reverse a string with special characters and special characters position shouldn't be changed".

        String speString = "abnc_&";
        String[] arr3 = speString.split("");
        String regex = "[^a-z0-9A-Z]";
       StringBuffer rev =  new StringBuffer(speString).reverse();
        IntStream.range(0, arr3.length - 1)
                .filter(i -> arr3[i].matches(regex))
                .forEach(i->rev.insert(i,arr[i]));

        System.out.println(rev);

        // Q11) Given a list of integers, divide into two lists one having even numbers and other having odd numbers.
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list1.stream().filter(i->i%2==0).toList();
        List<List<Integer>> divList = list1.stream().collect(Collectors.groupingBy(key->key%2==0,Collectors.toList())).values().stream().toList();

        // Q12) Given an array of integers (2,34,54,23,33,20,59,11,19,37 ) group the numbers by the range they belong to. The put put should be {0=[2], 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}
         List<Integer> list2 = Arrays.asList( 2,34,54,23,33,20,59,11,19,37 );
        Map<Integer, List<Integer>> map1 = list2.stream().collect(Collectors.groupingBy(n->n/10 * 10,Collectors.toList()));

        // Q13) Given a List of Strings  ["as", "123", "32", "2as"], create another Integer list that contains only integers. The output should be: List<Integer> iList = [123,32]
        List<String> list3 = Arrays.asList("as", "123", "32", "2as");
         list3.stream().filter(s1->s1.matches("[0-9]*")).mapToInt(Integer::valueOf).forEach(System.out::println);

         //Q14) Given an array of integers arr = {5,6,7,8,5,5,8,8,7) find the sum of the unique elements. The output should be in this case is: 26.

        List<Integer> list4 = Arrays.asList(5,6,7,8,5,5,8,8,7);
        int res = list4.stream().distinct().reduce(0,(a,b)->a+b);
        System.out.println(res);

        // Q15 ) Given a numeric array , re arrange the elements to form a smallest possible value.
        //
        //input is: int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
        //
        //output is: 133444576998

        int arr4[] = {1, 34, 3, 98, 9, 76, 45, 4};
        System.out.println(Arrays.stream(arr4).mapToObj(a->a+"").sorted().collect(Collectors.joining()));

        //Q16) Given a numeric array , re arrange the elements to form a highest possible value.
        //
        //input is: int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
        //
        //output is: 998764543431

        System.out.println(Arrays.stream(arr4).mapToObj(a->a+"").sorted(Comparator.reverseOrder()).collect(Collectors.joining()));

        //Q17)  Given a String = The quick brown fox jumps over the lazy dog, find the first non repeated character. (Google interview)
        System.out.println( str2.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),()->new LinkedHashMap<>(), Collectors.counting())).entrySet().stream().filter(k->k.getValue()==1).findFirst().orElse(null) );


        System.out.println(Arrays.stream(str2.split("")).filter(c -> str2.indexOf(c) == str2.lastIndexOf(c)).findFirst().get());


        // 1) Find the longest word in a sentence?
        //
        //	Input: I am interested to grow in my organization
        //	output is: organization
        String str3 = "I am interested to grow in my organization";
        System.out.println(Arrays.stream(str3.split(" ")).max(Comparator.comparing(String::length)).orElse(null));


        // 2) Find the lenght of the longest word.
        //
        //	Input: I am interested to grow in my organization
        //	output is: 	12
        System.out.println(Arrays.stream(str3.split(" ")).max(Comparator.comparing(String::length)).map(String::length).orElse(null));

        // 3) Find the 2nd highest length in the sentence.
        //
        // 4) FInd the length of the 2nd longest word.

        System.out.println( Arrays.stream(str3.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).map(String::length).findFirst().orElse(null ) );


        System.out.println( Arrays.stream(str3.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().orElse(null) );


        // 5) List of cities
        //
        //	"Mumbai"
        //	"Munnar"
        //	"chennai"
        //	"Hyderabad"
        //
        //	Calcullate the lenght of each city where the city name starts with 'm' or 'M' and create a list.

        List<String> list5 = Arrays.asList("Mumbai" , "Munnar" , "chennai" , "Hyderabad");
        list5.stream().filter(city->city.substring(0,1).equalsIgnoreCase("m")).collect(Collectors.toList()).forEach(System.out::println);


        //6)  I have to arrays
        //	 int arr1[] = {21,6,8,9,10,5};
        //	 int arr2[] = {10,21,5,8,6,9};
        //
        //	 write a program to check whether both arrays are equal or not.
        int[] arr1 = {21,6,8,9,10,5};
        int[] arr2 = {10,21,5,8,6,9};

        System.out.println(equalsArr(arr1,arr2));
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("The arrays are equal");
        } else {
            System.out.println("The arrays are not equal");
        }


        //7)  Given a string, find the words with the maximum number of vowels.
        //
        //		"The quick brown fox jumps right over the little lazy dog."
        //		Maximum Number of Vowels: 2
        //
        //		output Words: quick, over, little  ( because each word has maximum of 2 vowels)



        Arrays.stream(str2.split(" ")).filter(n->n.replaceAll("[^aeiouAEIOU]","").length()>=2).forEach(System.out::println);

   // Given String "aaabbcaabbddd" asked to print the frequency into the order of character given so out should be:
        //
        //a=3,
        //
        //b=2,
        //
        //c=1,
        //
        //a=2,
        //
        //b=2,
        //
        //d=3

        String str4 = "aaabbcaabbddd";
        Arrays.stream(str4.split("")).collect(Collectors.groupingBy(Function.identity() , Collectors.counting())).entrySet().stream().forEach(k-> System.out.println(k.getKey() + " " + k.getValue()));

    }

    public static boolean equalsArr(int[] arr1 , int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(arr1.length == arr2.length){
            int check = (int) IntStream.range(0,arr1.length).filter(i->arr1[i] == arr2[i]).count();
            if(check == arr1.length){
                return true;
            }
        }

        return false;
    }

}
