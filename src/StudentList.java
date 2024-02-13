
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
// qaun li nhieu sinh vien do do se thua ke is-a voi arraylist
public class StudentList extends ArrayList<Student> {

    // HashMap<Integer, course> Student
    // HashMap<String, book> book
//     xuat danhs sach sinh vien ra man hinh
    public void saveDataToFile(String file) {
        PrintWriter w = null;
        try {
            w = new PrintWriter(file);
            //ghi thong tin sinh vien vao fiel;
            for (Student x : this) {
                String fileStudent = x.getId() + "," + x.getName(); // chinh lai de in ra toString chuan theo bai la duoc roi kkk
                w.println(fileStudent);
                //ghi laptop vao file
                String fileLapTop = x.getId() + "_" + x.getName() + "_lap" + ".txt";
                x.saveDataLaptopToFile(fileLapTop);
                String fileCourse = x.getId() + "_" + x.getName() + "_course" + ".txt";
                x.saveDateCourseToFile(fileCourse);
                String fileBook = x.getId() + "_" + x.getName() + "_book" + ".txt";
                x.loatDataBookForStudentFromFile(fileBook);
                //ghi course, book
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

    //ham nay de load laptop tu file cho sinh vien
    public void loadDataFromFile(String filename) {
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
                        Student sv = new Student(Integer.parseInt(arr[0].trim()), arr[1]);

                        String fileLapTop = sv.getId() + "_" + sv.getName() + "_lap" + ".txt";
                        sv.loadDataLaptopFromFile(fileLapTop);

                        String fileCourse = sv.getId() + "_" + sv.getName() + "_course" + ".txt";
                        sv.loatDataCourseFromFile(fileCourse);

                        String fileBook = sv.getId() + "_" + sv.getName() + "_book" + ".txt";
                        sv.loatDataBookForStudentFromFile(fileBook);
                        this.add(sv);
                    }
                }
            } catch (Exception e) {
                System.out.println("File error");
            } finally {
                try {
                    if (f != null) {
                        fr.close();
                    }
                    if (bf != null) {
                        bf.close();
                    }
                } catch (Exception e) {
                    System.out.println("file error");
                }

            }
        }

    }

    public void displayALl() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------");
        for (Student x : this) {
            x.outputStudent();
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public Student searchStudentByID(int id) {
        for (Student x : this) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public void sortStudentByID() {
        Collections.sort(this, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }

        });
    }

    //sort o trong set hoac map thi khong cho phep
    public void removeStudentById(int id) {
        Student x = searchStudentByID(id);
        if (x != null) {
            this.remove(x);
        }
    }

    public Student updateStudentByName(String name) {
        Student a = searchStudentByName(name);
        if (a != null) {
            a.setName(Inputter.inPutString("(.)+", "Enter the new name : "));
            System.out.println("Enter the new id laptop: ");
            int newId = Inputter.inputNumber(1, 100000000);
            String newMac = Inputter.inPutString("(.)+", "Enter the new mac : ");
            for (LapTop x : a.getLaptops()) {
                if (x != null) {
                    x.setId(newId);
                    x.setMac(newMac);
                } else {
                    System.out.println("Laptops not found for this student.");
                }
            }
        }
        return a;
    }

    public Student searchStudentByName(String name) {
        for (Student x : this) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }

    public void sortStudentByName() {
        Collections.sort(this, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
