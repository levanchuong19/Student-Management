
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class CourseList extends  ArrayList<Course>{
    
    // add
    ///search course by id
    // displayAllCourse
    //remove course by id neu mon do chua duoc luu vao danh sach khoa hoc
    
    public  void saveDateCourseInFPTToFile(String filename){
        PrintWriter w = null;
        try{
            w = new PrintWriter(filename);
            for (Course x : this) {
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
    public void loatDataCourseInFPTFromFile(String filename ){
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
                    Course co = new Course(arr[0], arr[1],(Integer.parseInt(arr[2])));
                    this.add(co);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
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
    public boolean addCourseOfCourseListOFPTU(Course b){
             CourseList.super.add(b);
                     return true;    
    }
    
    public boolean removeCourseById(String code){
        Course co = searchCourseByCode(code);
        if(co != null){
            remove(co);
            return true;
        }
        return false;
    }
    
    public Course searchCourseById(String code){
        for (Course x : this) {
            if(x.getCode().equals(code)){
                return x;
            }
        }
        return null;
    }
    
    public void displayAllCourse(){
        System.out.println("----------------------------");
        for (Course x : this) {
            x.outPut();
            System.out.println("");
        }
        System.out.println("----------------------------");
    }
    
    public Course searchCourseByCode (String code){
        for (Course c : this) {
            if(c.getCode().equals(code)){
                return c;
            }
        }
        return null;
    }
}
