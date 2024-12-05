import LinkedList.*;
import Stack.ArrayStack;
import Stack.LinkedListStack;

import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        ArrayStack s1 = new ArrayStack(10);
        s1.Print();
        s1.push(20);
        s1.Print();
        s1.push(21);
        s1.Print();
        s1.push(22);
        s1.Print();
        System.out.println(s1.Pop());
        s1.Print();
        s1.push(34);
        s1.Print();
        System.out.println(s1.Pop());
        s1.Print();
        System.out.println(s1.Pop());
        s1.Print();
        System.out.println(s1.Pop());
        s1.Print();
    }
}