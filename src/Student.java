 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Student {

    private int id;
    private String name;
    private ArrayList<LapTop> laptops;
    private ArrayList<Course> enrolerCourse;
    private HashMap<String, Book> books;
//1 sinh vien thi co nhieu laptop

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        laptops = new ArrayList<>();
        enrolerCourse = new ArrayList<>();
        books = new HashMap<>();
    }

    public Student() {
        id = 0;
        name = "";
        laptops = new ArrayList<>();
        enrolerCourse = new ArrayList<>();
        books = new HashMap<>();
    }

    public Student(int id, String name, ArrayList<LapTop> laptops) {
        this.id = id;
        this.name = name;
        this.laptops = laptops;
    }

    public Student(int id, String name, ArrayList<LapTop> laptops, ArrayList<Course> enrolerCourse, HashMap<String, Book> books) {
        this.id = id;
        this.name = name;
        this.laptops = laptops;
        this.enrolerCourse = enrolerCourse;
        this.books = books;
    }

    public ArrayList<Course> getEnrolerCourse() {
        return enrolerCourse;
    }

    public void setEnrolerCourse(ArrayList<Course> enrolerCourse) {
        this.enrolerCourse = enrolerCourse;
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public void setBooks(HashMap<String, Book> books) {
        this.books = books;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<LapTop> getLaptops() {
        return laptops;
    }

    public void setLaptop(ArrayList<LapTop> laptop) {
        this.laptops = laptop;
    }

    public void inPutStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter student id: ");
        id = sc.nextInt();
        System.out.print("enter student name: ");
        sc = new Scanner(System.in);
        name = sc.nextLine();
        String cont = "n";
        do {
            try {
                System.out.println("Enter new laptop infor:");
                LapTop tmp = new LapTop();
                tmp.inputLapTop();
                if (laptops.add(tmp)) {
                    System.out.println("add laptop successfully");
                } else {
                    System.out.println("fail");
                }
                cont = Inputter.inPutString("[yYnN]$", "add a more laptop(Y/N)?:");
            } catch (Exception e) {
                System.out.println("----------------------------");
                System.out.println("Invalid input");
                System.out.println("----------------------------");
            }
        } while (cont.equalsIgnoreCase("y"));
    }

    public void outputStudent() {
        System.out.println("Student: ");
        System.out.println("Student ID: " + id + " - " + "Student Name: " + name);
        System.out.println("Laptop cua student: ");
        for (LapTop x : laptops) {
            x.outputLapTop();
        }
        System.out.println("Course student enrolled:");
        for (Course x : enrolerCourse) {
            if(x != null){
                x.outPut();
      
            }else{
                System.out.println("Student not yet enrrol course");
            }
        }
        System.out.println("Book student borrowed:");
        Collection<Book> book = books.values();
        for (Book x : book) {
            System.out.println(x);
        }
            
        
    }
    // add course
    //ham nay de thrm 1 book vao book cua sv

    public boolean addBorrowerBook(Book b) {
        books.put(b.getCode(), b);
        return true;
    }
    // ham nay de xuat cac book ma sv da muon

    public void displayAllBorrowedBooks() {
        Collection<Book> cacSach = books.values();
        for (Book x : cacSach) {
            System.out.println(x);
        }
    }

    public Book searchBook(String code) {
        return books.get(code);
    }

    public boolean addCourseToEnrrolledCourse(Course b) {
        for (Course a : enrolerCourse) {
            if (a.getCode().equals(b.getCode())) {
                return false;
            }
        }
        enrolerCourse.add(b);
        return true;
    }

    public void displayAllEnrolledCourse() {
        for (Course cou : enrolerCourse) {
            System.out.println(cou);
        }
    }

    public boolean addLaptop(LapTop b) {
        for (LapTop lap : laptops) {
            if (lap.getId() != b.getId()) {
                laptops.add(b);
                return true;
            }
        }
        return false;
    }

    public void displayAllLaptop() {
        for (LapTop lap : laptops) {
            if (lap != null) {
                lap.outputLapTop();
            }
        }
    }
    // ham nay de doc mot text file va luu va- arr laptop

    public void loadDataLaptopFromFile(String filename) {
        File f = new File(filename);// them duong dan file vao
        if (f.exists()) {
            FileReader fr = null;
            BufferedReader bf = null;
            try {
                fr = new FileReader(filename);
                bf = new BufferedReader(fr);
                while (bf.ready()) {
                    String s = bf.readLine();
                    String[] arr = s.split(",");
                    if (arr.length == 2) {
                        LapTop t = new LapTop(Integer.parseInt(arr[0].trim()), arr[1]);
                        laptops.add(t);
                    }
                }
            } catch (Exception e) {
                System.out.println("File error");
            } finally {
                try {
                    if (f != null) fr.close();
                    if (bf != null) bf.close();
                } catch (Exception e) {
                    System.out.println("file error");
                }

            }
        }
    }

    public void saveDataLaptopToFile(String file) {
        PrintWriter w = null;
        try {
            w = new PrintWriter(file);
            for (LapTop x : laptops) {
                String s = x.getId() + "," + x.getMac(); // chinh lai de in ra toString chuan theo bai la duoc roi kkk
                w.println(s);
            }
        } catch (Exception e) {
            System.out.println("file error");
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
                System.out.println("file error");
            }
        }
    }
    
    public void loatDataBookForStudentFromFile(String filename ){
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
                    books.put(co.getCode(), co);
                }
            }
        }catch(Exception e){
            System.out.println("File error");
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
     public  void saveDateBookForStudentToFile(String filename){
        PrintWriter w = null;
        try{
            w = new PrintWriter(filename);
            for(Map.Entry<String, Book> map : books.entrySet()){
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
     
      public  void saveDateCourseToFile(String filename){
        PrintWriter w = null;
        try{
            w = new PrintWriter(filename);
            for (Course x : enrolerCourse) {
                String s = x.getCode() + "," + x.getName() + "," + x.getCredit(); 
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
    public void loatDataCourseFromFile(String filename ){
        File f = new File(filename);
        if(f.exists()){
            FileReader rf = null;
            BufferedReader br = null;
        try{
            rf = new FileReader(filename);
            br = new BufferedReader(rf);
            while(br.ready()){
                String s = br.readLine();
                String[] arr = s.split(",");
                if(arr.length == 3){
                    Course co = new Course(arr[0], arr[1],Integer.parseInt(arr[2]));
                    enrolerCourse.add(co);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
                try {
                    if (f != null) rf.close();
                    if (br != null) br.close(); 
            }catch(Exception e){
                System.out.println("file error");
            }
        }
    }
    }
}
