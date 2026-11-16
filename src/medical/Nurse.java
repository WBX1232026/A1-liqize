package medical;

import java.util.ArrayList;

// Nurse subclass
public class Nurse extends MedicalPractitioner {

    private String grade;  // nurse level/grade

    // nurse with default working days
    public Nurse(String id, String name, String lvl) {
        super(id, name);
        grade = lvl;
    }

    // return job type
    @Override
    public String roleType() { return "Nurse"; }

    // return nurse grade info
    @Override
    public String extraInfo() { return "grade=" + grade; }

    // nurse task: take blood sample
    public void takeBlood(String patient) {
        System.out.println(getName() + " collected blood sample from " + patient);
    }
}
