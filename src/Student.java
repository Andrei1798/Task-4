import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private boolean eligibleForErasmusScholarship;
    private ArrayList<String> universities = new ArrayList<>();

    public ArrayList<String> getUniversities() {
        return universities;
    }
    public void setUniversities(ArrayList<String> universities) {
        this.universities = universities;
    }

    public Student() {
    }

    public Student(int id, String name, String lastname, int age, boolean eligibleForErasmusScholarship, ArrayList<String> universities) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.eligibleForErasmusScholarship = eligibleForErasmusScholarship;
        this.universities = universities;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isEligibleForErasmusScholarship() {
        return eligibleForErasmusScholarship;
    }
    public void setEligibleForErasmusScholarship(boolean eligibleForErasmusScholarship) {
        this.eligibleForErasmusScholarship = eligibleForErasmusScholarship;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
//        return "[id]: " + id + " [name]: " + name + " [lastname]: " + lastname + "";
        return "" + id + "  " + name + " " + lastname + "";
    }
}
