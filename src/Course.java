
import java.util.Collection;
import java.util.HashMap;


public class Course {
    private String code;
    private String name;
    private int credit;
    private HashMap<Integer, Student> enrolledStudent;

    public Course(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        enrolledStudent = new HashMap<>();
    }
                 
    public Course() {
        code ="";
        name ="";
        credit = 0;
        enrolledStudent = new HashMap<>();
    }

    public Course(String code, String name, int credit, HashMap<Integer, Student> enrolledStudent) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.enrolledStudent = enrolledStudent;
    }

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public HashMap<Integer, Student> getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(HashMap<Integer, Student> enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }
    
    public  void inputCourse(){
        try{
        code = Inputter.inPutString("(.)+", "Enter the course,s code: ");
        name = Inputter.inPutString("(.)+", "Enter the course's name: ");
        System.out.print("Enter the course credit :");
        credit = Inputter.inputNumber(1, 10);
        }catch(Exception e){
            System.out.println("Input Invalid.");
        }
    }
    public void outPut(){
        System.out.println("the course's code : " + code);
        System.out.println("the course's name : " + name);
//        System.out.print("the course's enrolled Student : " );
//        
//        Collection<Student> dssv = enrolledStudent.values();
//        int dem =0;
//        for (Student x : dssv) {
//            if(x.getEnrolerCourse().c)
////            x.outputStudent();
//           dem++;
//        }
//        System.out.println(dem);
    }
    
    public boolean addStudentToEnrollStudent( Student stu){
     if(stu != null){
         enrolledStudent.put(stu.getId(), stu);
         return true;
     }
     return false;
    }
    
    
}
