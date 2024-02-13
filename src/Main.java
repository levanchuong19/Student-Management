
public class Main {

    public static void main(String[] args) {
        String file1 = "dssv.txt";
        String file2 = "dsmh.txt";
        String file3 = "dss.txt";
        StudentList dssv = new StudentList();// check file neu ton tai thi load data vao dssv
        dssv.loadDataFromFile(file1);
        CourseList dsmh = new CourseList();
        dsmh.loatDataCourseInFPTFromFile(file2);
        BookList dss = new BookList();
        dss.loatDataBookFromFile(file3);
        int choice = 0;
        do {
            System.out.println("Student management");
            System.out.println("1.Add a new student");
            System.out.println("2.Display all students");// can phai sua qua list
            System.out.println("3.Search a student by id");
            System.out.println("4.Search student by name");
            System.out.println("5.Sort student by id");
            System.out.println("6.Sort student by name");
            System.out.println("7.Remove the student by id");
            System.out.println("8.Update the student by name");
            System.out.println("9.Save all student to the test file");
//            System.out.println("10.Enroll the course ");
//            System.out.println("11.DisplayAll the course infor");
            System.out.println("Course management");
            System.out.println("10.Add a new course to courseList of FPTU");
            System.out.println("11.Display all course of FPTU");
            System.out.println("12.Search the course in courseList of FPTU");
            System.out.println("13.Remove the course ");
            System.out.println("Book management ");
            System.out.println("14.Add new book to bookList of FPTU");
            System.out.println("15.Display all book of bookList of FPTU");
            try {
                System.out.print("enter a choice :");
                choice = Inputter.inputNumber(1, 15);
                switch (choice) {
                    case 1:
                        Student stu = null;
                        boolean check;
                        do {
                            stu = new Student();
                            stu.inPutStudent();
                            check = true;
                            for (Student student : dssv) {
                                if (student.getId() == stu.getId()) {
                                    check = false;
                                    break;
                                }
                            }
                            if (!check) {
                                System.out.println("----------------------------");
                                System.out.println("Invalid ID. Enter different ID.");
                                System.out.println("----------------------------");
                                check = true;
                            } else {
                                if (dssv.add(stu)) {
                                    System.out.println("----------------------------");
                                    System.out.println("ADD STUDENT SUCCESSFULLY.");
                                    System.out.println("----------------------------");
                                } else {
                                    System.out.println("----------------------------");
                                    System.out.println("ADD STUDENT FAIL.");
                                    System.out.println("----------------------------");
                                }
                                break;
                            }
                        } while (check);
                        break;
                    case 2:
                        dssv.displayALl();
                        break;
                    case 3:
                        System.out.print("Enter the student id to find id :");
                        int findID = Inputter.inputNumber(1, 100000000);
                        Student result = dssv.searchStudentByID(findID);
                        if (result != null) {
                            int choice2 = 0;
                            do {
                                System.out.println("student found");
                                result.outputStudent();
                                System.out.println("1. Update student infor");
                                System.out.println("2. Enroll the course to this student");
                                System.out.println("3. Display all enrolled course");
                                System.out.println("4. Add a new laptop to this student");
                                System.out.println("5. Display all laptop of this student");
                                System.out.println("6. Add a borrowed book to this student");
                                System.out.println("7. Display all borrower books of this student");
                                System.out.print("Enter choice :");
                                choice2 = Inputter.inputNumber(1, 7);
                                switch (choice2) {
                                    case 1:
                                        String newName = Inputter.inPutString("(.)+", "Enter the new name: ");
                                        result.setName(newName);
                                        continue;

                                    case 2:
                                        dsmh.displayAllCourse(); // code ham nay o courseList
                                        String code = Inputter.inPutString("(.)+", "Enter the course'id to enroll: ");
                                        Course c = dsmh.searchCourseByCode(code); // ham nay code trong lop courseList
                                        if (c != null) {
                                            result.addCourseToEnrrolledCourse(c);
                                            System.out.println("enrolled this course for the student.");
                                            System.out.println("----------------------------");
                                        } else {
                                            System.out.println("Not Found this course in FPTU.");
                                            System.out.println("----------------------------");
                                        }
                                        continue;
                                    case 3:
                                        System.out.println("----------------------------");
                                        result.displayAllEnrolledCourse();
                                        System.out.println("----------------------------");
                                        continue;
                                    case 4:
                                        System.out.println("Enter the new laptop :");
                                        LapTop e = new LapTop();
                                        e.inputLapTop();
                                        result.addLaptop(e);
                                        continue;
                                    case 5:
                                        System.out.println("----------------------------");
                                        result.displayAllLaptop();
                                        System.out.println("----------------------------");
                                        continue;

                                    case 6:
                                        dss.displayAllBooks();// code trong lop bookList
                                        String bookcode = Inputter.inPutString("(.)+", "Enter the book code to borrow: ");
                                        Book b = dss.get(bookcode);
                                        if (b != null) {
                                            result.addBorrowerBook(b);
                                            System.out.println("----------------------------");
                                            System.out.println("Borrowed this book done.");
                                            System.out.println("----------------------------");
                                        }else {
                                            System.out.println("----------------------------");
                                            System.out.println("Not found this book.");
                                            System.out.println("----------------------------");
                                        }
                                        continue;
                                    case 7:
                                        System.out.println("----------------------------");
                                        System.out.println("ds book da muon la :");
                                        result.displayAllBorrowedBooks();
                                        System.out.println("----------------------------");
                                        continue;
                                }
                                break;
                            } while (choice2 != 0);
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("student not found.");
                            System.out.println("----------------------------");
                        }
                        break;

                    case 4:
                        String ten = Inputter.inPutString("(.)+", "Enter the name to search : ");
                        Student name = dssv.searchStudentByName(ten);
                        if (name != null) {
                            System.out.println("----------------------------");
                            System.out.println("Student found.");
                            name.outputStudent();
                            System.out.println("----------------------------");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("Student not found.");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 5:
                        dssv.sortStudentByID();
                        dssv.displayALl();
                        break;
                    case 6:
                        dssv.sortStudentByName();
                        dssv.displayALl();
                        break;
                    case 7:
                        System.out.print("Enter the id to remove: ");
                        int a = Inputter.inputNumber(1, 100000000);
                        dssv.removeStudentById(a);
                        System.out.println("----------------------------");
                        System.out.println("remove student successfully.");
                        System.out.println("----------------------------");
                        break;
                    case 8:
                        String nameStu = Inputter.inPutString("(.)+", "Enter the name student want update: ");
                        Student findName = dssv.searchStudentByName(nameStu);

                        if (findName != null) {
                            int choice3 = 0;
                            do {
                                System.out.println("student found");
                                findName.outputStudent();
                                System.out.println("1. Update student infor");
                                System.out.println("2. Enroll the course to this student");
                                System.out.println("3. Display all enrolled course");
                                System.out.println("4. Add a new laptop to this student");
                                System.out.println("5. Display all laptop of this student");
                                System.out.println("6. Add a borrowed book to this student");
                                System.out.println("7. Display all borrower books of this student");
                                System.out.print("Enter choice :");
                                choice3 = Inputter.inputNumber(1, 7);
                                switch (choice3) {
                                    case 1:
                                        String newName = Inputter.inPutString("(.)+", "Enter the new name: ");
                                        findName.setName(newName);
                                        continue;

                                    case 2:
                                        dsmh.displayAllCourse(); 
                                        String code = Inputter.inPutString("(.)+", "Enter the course'id to enroll: ");
                                        Course c = dsmh.searchCourseByCode(code);
                                        if (c != null) {
                                            findName.addCourseToEnrrolledCourse(c);
                                            System.out.println("enrolled this course for the student.");
                                            System.out.println("----------------------------");
                                        } else {
                                            System.out.println("Not Found this course in FPTU.");
                                            System.out.println("----------------------------");
                                        }
                                        continue;
                                    case 3:
                                        System.out.println("----------------------------");
                                        findName.displayAllEnrolledCourse();
                                        System.out.println("----------------------------");
                                        continue;
                                    case 4:
                                        System.out.println("Enter the new laptop :");
                                        LapTop e = new LapTop();
                                        e.inputLapTop();
                                        findName.addLaptop(e);
                                        continue;
                                    case 5:
                                        System.out.println("----------------------------");
                                        findName.displayAllLaptop();
                                        System.out.println("----------------------------");
                                        continue;

                                    case 6:
                                        dss.displayAllBooks();// code trong lop bookList
                                        String bookcode = Inputter.inPutString("(.)+", "Enter the book code to borrow: ");
                                        Book b = dss.get(bookcode);
                                        if (b != null) {
                                            findName.addBorrowerBook(b);
                                            System.out.println("----------------------------");
                                            System.out.println("Borrowed this book done.");
                                            System.out.println("----------------------------");
                                        }else {
                                            System.out.println("----------------------------");
                                            System.out.println("Not found this book.");
                                            System.out.println("----------------------------");
                                        }
                                        continue;
                                    case 7:
                                        System.out.println("----------------------------");
                                        System.out.println("ds book da muon la :");
                                        findName.displayAllBorrowedBooks();
                                        System.out.println("----------------------------");
                                        continue;
                                }
                                break;
                            } while (choice3 != 0);
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("student not found.");
                            System.out.println("----------------------------");
                        }
                        break;

                    case 9:
                        dssv.saveDataToFile(file1);
                        dsmh.saveDateCourseInFPTToFile(file2);
                        dss.saveDateBookToFile(file3);
                        System.out.println("---------------------------------------");
                        System.out.println("Add to file successfully");
                        System.out.println("---------------------------------------");
                        break;
                    case 10:
                        Course co = new Course();
                        co.inputCourse();
                        if (dsmh.addCourseOfCourseListOFPTU(co)) {
                            System.out.println("----------------------------");
                            System.out.println("Add course Successfully");
                            System.out.println("----------------------------");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("Add Course Fail.");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 11:
                        dsmh.displayAllCourse();
                        break;
                    case 12:
                        String code = Inputter.inPutString("(.)+", "Enter the code course to search: ");
                        Course find = dsmh.searchCourseByCode(code);
                        if (find != null) {
                            find.outPut();
                        } else {
                            System.out.println("Course Invalid");
                        }
                        break;

                    case 13:
                        dsmh.displayAllCourse();
                        String codeCourse = Inputter.inPutString("(.)+", "Enter the code course to remove: ");
//                        for (Course course : dsmh) {
//                            if (course.getCode().equals(codeCourse)) {
                                if (dsmh.removeCourseById(codeCourse)) {
                                    System.out.println("----------------------------");
                                    System.out.println("Remove successfully.");
                                    System.out.println("----------------------------");
                                } else {
                                    System.out.println("----------------------------");
                                    System.out.println("Remove fail.");
                                    System.out.println("----------------------------");
                                }
//                                break;
//                            } else {
//                                System.out.println("Course not found");
//                                break;
//                            }
//                        }
                        break;
                    case 14:
                        Book b = new Book();
                        b.inputBook();
                        if (dss.addBookToBookListOfFPTU(b)) {
                            System.out.println("----------------------------");
                            System.out.println("Add book successfully");
                            System.out.println("----------------------------");
                        } else {
                                
                            System.out.println("----------------------------");
                            System.out.println("Add fail");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 15:
                        dss.displayAllBooks();
                        break;
                }

            } catch (Exception e) {
                System.out.println("----------------------------");
                System.out.println("----------------------------");
                System.out.println("Data is invalid");
                System.out.println("----------------------------");
                System.out.println("----------------------------");
            }
        } while (choice <= 15);
    }
}
