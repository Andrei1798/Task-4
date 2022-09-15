import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Data {
    private String regDate;
    private Student student;
    public String getRegDate() {
        return regDate;
    }
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Data(String regDate, Student student) {
        this.regDate = regDate;
        this.student = student;
    }
    @Override
    public String toString() {
        return "Registration date: " + regDate + ",  Student:{" + student.toString() + "}";
    }


    public static ArrayList<Data> datab = new ArrayList<>();
    static{
        ArrayList<String> univ = new ArrayList();
        univ.add("USM");

        ArrayList<String> univ1 = new ArrayList();
        univ1.add("ASEM");
        univ1.add("USM");
        univ1.add("UTM");
        univ1.add("ULIM");
        univ1.add("USMF");
//
//        Student student1 = new Student(1, "Ion", "Perjan", 19, true, univ);
//        Student student3 = new Student(2, "Boris", "Toporovici", 23, false, univ1);
//        Student student2 = new Student(3, "Iulius", "Caesar", 22, true, univ);
//        Data registration1 = new Data("23/8/2022", student1);
//        Data registration2 = new Data("23/9/2022", student2);
//        Data registration3 = new Data("16/7/2022", student3);
//        datab.add(registration1);
//        datab.add(registration2);
//        datab.add(registration3);


        StringBuilder namesb = new StringBuilder("name");//pentru initializarea listei
        StringBuilder lastnamesb = new StringBuilder("lastname");//pentru initializarea listei
        boolean eligibleFor = false;
        int day = 13;
        int month = 7;
        for (int i = 0; i < 42 ; i++) {
            int id = i + 1;
            String name = namesb + String.valueOf(id);
            String lastname = lastnamesb + String.valueOf(id);
            int age = i+id;

            StringBuilder regDate = new StringBuilder();
            if(day <= 31 && month <=12){
                regDate.append(day).append("/").append(month).append("/");
                day++;
            }else if(day > 31){
                day = 1;
                month++;
                regDate.append(day).append("/").append(month).append("/");
            }else if(month > 12){
                day = 1;
                month = 1;
                regDate.append(day).append("/").append(month).append("/");
            }
            regDate.append(2022);//year
//            System.out.println(regDate);
            Data registration = null;
            if(i == 35 || i == 27){//pentru punctul 4
                registration = new Data(regDate.toString(), new Student(id, name, lastname, age, eligibleFor, univ1));
            }else registration = new Data(regDate.toString(), new Student(id, name, lastname, age, eligibleFor, univ));
            datab.add(registration);
        }//completarea listei
    }

    public static void readyForErasmus(String from, String to){
        ArrayList<Student> readyStudents = new ArrayList<>();
        try {
            Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from);
            Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(to);
            for (Data registration : datab) {
                Date dateReg = new SimpleDateFormat("dd/MM/yyyy").parse(registration.getRegDate());
                if (dateReg.equals(fromDate) && dateReg.before(toDate) || dateReg.after(fromDate) && dateReg.before(toDate)) {
                    readyStudents.add(registration.student);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The students who are ready for Erasmus is: ");
        readyStudents.forEach(Student -> System.out.println(Student.toString()));
    }

    public static void canVisitUniversity(String university){
        ArrayList<Student> studs = new ArrayList<>();
        datab.forEach(reg -> {
            Student student = reg.getStudent();
            ArrayList<String> studentUniversities = student.getUniversities();
            studentUniversities.forEach(univ ->{
                if(univ.equals(university)) studs.add(student);
            });
        });
        System.out.println("\nStudents who can visit " + university);
         studs.forEach(student -> System.out.println(student.toString()));
    }

    public static void universityStudents() {
        Set<String> universities = new HashSet();
        HashMap<String, ArrayList<Student>> universityAndStudentsList = new HashMap<>();
        ArrayList<Student> students = new ArrayList<>();

        datab.forEach(reg -> {
            students.add(reg.getStudent());
            reg.getStudent().getUniversities().forEach(uName -> universities.add(uName));
        });
        for (String uName : universities) {
            ArrayList<Student> students1 = new ArrayList<>();
            for (Student student : students) {
                for (String university : student.getUniversities()) {
                    if(university.equals(uName)){
                        students1.add(student);
                    }
                }
            }
            universityAndStudentsList.put(uName, students1);
        }
        System.out.println("University and his students\n");
        System.out.println(universityAndStudentsList);
    }
}
