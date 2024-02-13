
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
//lop nay de quan li nhieu SV . do vay lop nay thua ke is-a voi ArrayList
public class StudentSet extends TreeSet<Student>{
   
    //ham nay de xuat ds sv ra man hinh
    public void displayAll(){
     
        //cach 1: duyet cac node tu trai giua phai(LNR)
        //-> in ra mh thu tu tang dan theo id
        for (Student stu : this) {
            stu.outputStudent();
        }
    }
    //xuat ds sv giam dan id
    //-> duyet cac node tu phai giua trai (RNL)
    public void displayAll2(){
        Iterator<Student> it=descendingIterator();
        while( it.hasNext()){
            Student stu=it.next();
            stu.outputStudent();
        }
    }
    //ham nay de tim student dua vao id
    //tra ve student tim thay/null
    public Student searchStudent(int id){
        for (Student stu : this) {
            if(stu.getId()==id) return stu;
        }
        return null;
    }
    //ham nay de sap xep ds sv tang dan theo id
    //dv TreeSet khi add da co thu tu dua vao compareTo nen we ko can sort no nua
//    public void sortByid(){
//        Collections.sort(this);
//    }
    //ham nay de sort by name
//    public void sortByName(){
//       Collections.sort(this, Student.byname);
//    }
    
    
     //ham nay de lay cac sv co id tu min den max
    //return ad sv thoa dk
    public ArrayList<Student> filterStudent(int min, int max){
        ArrayList<Student> kq=new ArrayList<>();
        
        //TODO
        return kq;
    }
    //ham nay de tim cac sv ten co chua chuoi can tim
    //input name="a" lay dc cac sv ma ten co chua chu a
    public HashSet<Student> filterStudentByName(String name){
        HashSet<Student> kq=new HashSet<>();
        //TODO
        return kq;
    }
    //ham nay de tra ve nhung sv dk hoc mon nao do
    //input : ma mahoc
    //output: return arrayList cac sv dk coc mon da nhap
    public ArrayList<Student> filterStudentByCourse(String code){
        ArrayList<Student> kq=new ArrayList<>();
        //TODO
        return kq;
    }
}
