package medical;

public class Nurse extends MedicalPractitioner {

    private String grade;

    public Nurse(String id, String name, String lvl) {
        super(id, name);
        grade = lvl;
    }

    @Override
    public String roleType() { return "Nurse"; }

    @Override
    public String extraInfo() { return "grade=" + grade; }

    public void takeBlood(String patient) {
        System.out.println(getName() + " collected blood sample from " + patient);
    }
}