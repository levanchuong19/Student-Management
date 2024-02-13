
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
// dung de chau cac ham thu vien trong project
// su dung cac ham nay o dau cun duoc
public class Inputter {
    // nhap 1 so nguyen va tra ve so nguyen vua nhap
    public  static int inputNumber(int min, int max){
        Scanner sc = new Scanner(System.in);
//        System.out.println("enter a number");
        int num = sc.nextInt();
        if(num >= min && num <= max){
            return num;
        }
        return -1;
    }
    // nhap mot chuoi , check chuoi vua nhap co thoa man 1 pattern hay k
   // neu pattern = "[SE][0-9]{3}" phai la 3 kis tu aphabet
    public static  String inPutString( String pattern, String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        String s = sc.nextLine();
        if(s.matches(pattern))
            return s ;
        return "";
    }
    
}
