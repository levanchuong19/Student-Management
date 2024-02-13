
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class BookList extends HashMap<String, Book>{
    public void displayAllBooks(){
        System.out.println("----------------------------");
        Collection<Book> book = this.values();
        for (Book x : book) {
            System.out.println(x);
        }
        System.out.println("----------------------------");
    }
    public Book searchBookByCode(String code){
        Collection<Book> book = this.values();
        for (Book x : book) {
            if(x.getCode().equals(code)){
                return x;
            }
        }
        return null;
    }
    public boolean removeBookByCode(String code){
        Book book = searchBookByCode(code);
        if(book != null){
            remove(book);
            return true;
        }
        return false;
    }
    
    public boolean addBookToBookListOfFPTU(Book b){
        this.put(b.getCode(), b);
        return true;
    }
    public void loatDataBookFromFile(String filename ){
        File f = new File(filename);
        if(f.exists()){
            FileReader r = null;
            BufferedReader b = null;
        try{
            r = new FileReader(filename);
            b = new BufferedReader(r);
            while(b.ready()){
                String s = b.readLine();
                String[] arr = s.split(",");
                if(arr.length == 3){
                    Book co = new Book(arr[0], arr[1],Integer.parseInt(arr[2]));
                    this.put(co.getCode(),co);
                }
            }
        }catch(Exception e){
            System.out.println("File Error");
        }finally{
            try {
                    if (f != null) r.close();
                    if (b != null) b.close();
            }catch(Exception e){
                System.out.println("file error");
            }
        }
    }
    }
    public  void saveDateBookToFile(String filename){
        PrintWriter w = null;
        try{
            w = new PrintWriter(filename);
            for(Map.Entry<String, Book> map : this.entrySet()){
                String s = map.getValue().getCode() + "," + map.getValue().getTitle()+ "," + map.getValue().getYear();
                w.println(s);
            }
        }catch(Exception e){
            System.out.println("file error"); 
        }finally{
        try{
           if(w != null) w.close();
        }catch(Exception e){
            System.out.println("file error");
        }
    }
    }
}
