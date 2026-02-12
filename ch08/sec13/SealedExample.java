package ch08.sec13;

public class SealedExample {
    public static void main(String[] args) {
        Implclass impl = new Implclass();

        InterfaceA ia = impl;
        ia.methodA();
        System.out.println();
        
        InterfaceB ib = impl;
        ib.methodA();
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
