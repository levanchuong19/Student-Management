
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
public class LapTop {
   private  int id;
   private  String mac;

    public LapTop() {
       id = 0;
       mac = "";
    }

    public LapTop(int id, String mac) {
        this.id = id;
        this.mac = mac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
   public  void inputLapTop(){
       Scanner sc = new Scanner(System.in);
       System.out.print("enter laptop id: ");
       id = sc.nextInt();
       sc.nextLine();
       System.out.print("enter laptop mac: ");
       sc = new Scanner(System.in);
       mac = sc.nextLine();
       
   }
   public void outputLapTop(){
       System.out.println( "Laptop ID: "+id + " - "+ "laptop Name: " + mac);
   }
}
