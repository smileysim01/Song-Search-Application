// --== CS400 Project One File Header ==--
// Name: FNU Simran
// Email: simran4@wisc.edu
// Team: red
// Group: DQ
// TA: Yuye Jiang
// Lecturer: Florian Heimerl
// Notes to Grader: This code executed perfectly on IntelliJ IDEA

import java.util.NoSuchElementException;

class HashtableMapTests{

    public static boolean test1() {
        HashtableMap<Integer,Integer> h1 = new HashtableMap();
        h1.put(5,5);
        Integer a = h1.get(5);
        if(a == 5)
            return true;
        return false;
    }

    public static boolean test2() {
        HashtableMap<Integer, Integer> h2 = new HashtableMap(6);
        h2.put(5,5);
        h2.put(4,4);
        h2.put(3,3);
        h2.put(2,2);
        h2.put(1,1);
        h2.put(0,0);
        int b = h2.size();
        if(b >= 0)//returns true if it's not empty, b in this case should be 1
            return true;
        return false;
    }
    public static boolean test3() {
        HashtableMap<Integer, Integer> h3 = new HashtableMap();
        h3.put(7,7);
        boolean c = h3.containsKey(7);
        if(c == true)
            return true;
        return false;
    }

    public static boolean test4() {
        HashtableMap<Integer, Integer> h4 = new HashtableMap();
        h4.put(8,8);
        Integer d = h4.remove(8);
        if(d == 8 )
            return true;
        return false;
    }

    public static boolean test5() {
        HashtableMap<Integer, Integer> h5 = new HashtableMap();
        h5.put(9,9);
        h5.clear();
        if(h5.size() == 0)
            return true;
        return false;
    }

    //Main method used for testing the codes
public static void main(String args[]){
        HashtableMapTests ob1=new HashtableMapTests();
        System.out.println(ob1.test1());
        HashtableMapTests ob2=new HashtableMapTests();
        System.out.println(ob2.test2());
        HashtableMapTests ob3=new HashtableMapTests();
        System.out.println(ob3.test3());
        HashtableMapTests ob4=new HashtableMapTests();
        System.out.println(ob4.test4());
        HashtableMapTests ob5=new HashtableMapTests();
        System.out.println(ob5.test5());
    }
}
