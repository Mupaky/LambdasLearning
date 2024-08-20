package com.supplyboost.exampleone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Human bob = new Human();
        bob.walk();

        Robot bot = new Robot();
        bot.walk();
        walker(() -> System.out.println("Custom entity is walking"));
        Walkable ablockOfCode = () -> { System.out.println("Custom entity is walking");
            System.out.println("Another Custom is walking");
        };
        walker(ablockOfCode);


        ALambdaInterface helloVarr = () -> System.out.println("Hello there once");
        CalculateInterface sumVar = (a, b) -> a+b;
        helloVarr.someMethod();
        System.out.println(sumVar.compute(4, 6));

        CalculateInterface divideVar = (a, b) -> {
            if(a == 0)return 0;
            return a/b;
        };
        System.out.println(divideVar.compute(0, 6));
        System.out.println(divideVar.compute(20, 6));


        StringWorkerInterface srt = (s) -> {
            StringBuilder result = new StringBuilder();
            for(int i = s.length() - 1; i >= 0; i--) {
              result.append(s.charAt(i));
            }
            return result.toString();
        };

        System.out.println(srt.work("Gospodarkata na gospod"));


        NumberWorkerInterface computedNumber = (num) -> {
            int res = 1;
            for(int i = 2; i <= num; i++) {
                res = i*res;
            }
            return res;
        };
        System.out.println(computedNumber.result(10));

        //My Generic Interface
        MyGenericInterface<String> srtGeneric = (s) -> {
            StringBuilder result = new StringBuilder();
            for(int i = s.length() - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            return result.toString();
        };

        System.out.println(srtGeneric.work("Walk into a cave"));

        //My Generic Interface
        MyGenericInterface<Integer> computedNumberGeneric = (num) -> {
            int res = 1;
            for(int i = 2; i <= num; i++) {
                res = i*res;
            }
            return res;
        };
        System.out.println(computedNumberGeneric.work(10));
    }

    public int factorial(int num){
        int result = 1;
        for(int i = 2; i <= num; i++) {
          result = i*result;
        }
        return result;
    }

    public static void walker(Walkable walkableEntity){
        walkableEntity.walk();
    }

    public void sayHello(){
        System.out.println("Hello there");
    }

    public int sum(int arg1, int arg2){
        return arg1 + arg2;
    }

    public int nonZeroDivide(int arg1, int arg2){
        if(arg1 == 0){
            return 0;
        }
        return arg1 / arg2;
    }


}