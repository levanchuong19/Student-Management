/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Book {
    private String code;
    private String title;
    private int year;

    public Book() {
    }

    public Book(String code, String title, int year) {
        this.code = code;
        this.title = title;
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCourse(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book code : " + code +"\n" + "Book Title : " + title+"\n" +"Public year : " + year;
    }

    
    
    public void inputBook(){
        code = Inputter.inPutString("(.)+", "Enter the code book: ");
        title = Inputter.inPutString(("(.)+"), "Enter the title book: ");
        System.out.print("Enter the year of publication: ");
        year = Inputter.inputNumber(1, 2024);
    }
    
    public void outPutBook(){
        System.out.println("Book code : " + code);
        System.out.println("Book Title : " + title);
        System.out.println("Public year : " + year);
    }
    
    
   
}
