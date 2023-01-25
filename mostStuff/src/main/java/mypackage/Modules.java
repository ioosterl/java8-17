package mypackage;

import package1.Service1;
//import package2.Service2;

public class Modules {

    public static void main(String[] args) {
        var s1 = new Service1();
//        var s2 = new Service2();

        s1.sayHi("Bob");
//        s2.howAreYouDoin();
    }
}
