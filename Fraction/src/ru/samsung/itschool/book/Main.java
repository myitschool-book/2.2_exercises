package ru.samsung.itschool.book;

import java.io.PrintStream;
import java.util.Scanner;

class Fraction{
    private int numerator;
    private int denominator = 1;

    public Fraction(int numerator, int denominator){
            if(denominator == 0){
                    System.out.println("Denominator can't be zero. Choose another one.");
                    return;
            }
            this.numerator = numerator * (denominator < 0 ? -1 : 1);
            this.denominator = Math.abs(denominator);
            Normalization();
    }

    private void Normalization(){
            int n = Nod(Math.abs(numerator), Math.abs(denominator));
            numerator /= n;
            denominator /= n;
    }

    private static int Nod(int numerator, int denominator){
            while (numerator != 0 && denominator != 0)
                    if (numerator > denominator)
                            numerator = numerator % denominator;
                    else
                            denominator = denominator % numerator;
            return numerator + denominator;
    }

    public boolean ProperFraction(){
            return (Math.abs(numerator) < denominator ? true : false);
    }

    public int isIntegerPart(){ 
            return (numerator / denominator);
    }

    public Fraction FractionalPart(){ 
            return new Fraction(numerator % denominator, denominator);
    }

    public String ToString(){ 
            return new String(numerator + " / " + denominator);
    }

    public double ToDecimalFractions(){ 
            return (double) numerator / denominator;
    }

    public int getNumerator(){
            return numerator;
    }

    public int getDenominator(){
            return denominator;
    }

    public void setNumerator(int numerator){
            this.numerator = numerator;
    }

    public void setDenominator(int denominator){
            if (denominator == 0) {
                    System.out.println("Denominator can't be zero. Choose another one.");
                    return;
            }
            if (denominator < 0){
                    this.numerator *= -1;
            }
            this.denominator = Math.abs(denominator);
    }

    public Fraction SumFractionTo(Fraction obj){
            return new Fraction(this.numerator * obj.denominator + obj.numerator * this.denominator, this.denominator * obj.denominator);
    }

    public static Fraction SumFraction(Fraction obj1, Fraction obj2){
            return new Fraction(obj1.numerator * obj2.denominator + obj2.numerator * obj1.denominator, obj1.denominator * obj2.denominator);
    }
}

public class Main{
    public static PrintStream out = System.out;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
            Fraction objectFraction1 = new Fraction(1,6);
            System.out.println(objectFraction1.ToString());

            Fraction objectFraction2 = new Fraction(1,3);
            System.out.println(objectFraction2.ToString());

            Fraction objectFraction3 = objectFraction1.SumFractionTo(objectFraction2);

            System.out.println(objectFraction3.ToString());

            Fraction objectFraction4 =  Fraction.SumFraction(objectFraction1,objectFraction2);

            System.out.println(objectFraction4.ToString());
    }
}