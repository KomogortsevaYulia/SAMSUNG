package com.company;

public class Main {

    public static void main(String[] args) {
        Fraction f=new Fraction(1,5);
        Fraction f1=new Fraction(3,4);
        System.out.println(Fraction.sumFraction(f,f1));
        System.out.println(Fraction.DifferFraction(f,f1));
        System.out.println(Fraction.increaseFraction(f,f1));
        System.out.println(Fraction.divisionFraction(f,f1));
    }
}
