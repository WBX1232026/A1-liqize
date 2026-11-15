package medical;

import java.util.ArrayList;

public class Surgeon extends MedicalPractitioner {

    private String specialty;

    @Override
    public String roleType() {
        return "Surgeon";
    }

    @Override
    public String extraInfo() {
        return "specialty:" + specialty;
    }

    public Surgeon(String id, String name, String spec) {
        super(id, name);
        specialty = spec;
    }

    public Surgeon(String id, String name, ArrayList<String> days, String spec) {
        super(id, name, days);
        specialty = spec;
    }

    public void operate(String patientName) {
        System.out.println(getName() + " did " + specialty + " surgery for " + patientName);
    }
}