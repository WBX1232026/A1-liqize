package medical;

import java.util.ArrayList;

// Surgeon subclass
public class Surgeon extends MedicalPractitioner {

    private String specialty;  // surgery field, e.g. orthopedic

    // return job type
    @Override
    public String roleType() {
        return "Surgeon";
    }

    // return surgeon specialty info
    @Override
    public String extraInfo() {
        return "specialty:" + specialty;
    }

    // I had a bug here before, I passed the parameters in the wrong order.
    // Just leaving this note here so I remember.
    // public Surgeon(String spec, String id, String name)

    // surgeon with default Mon-Fri work days
    public Surgeon(String id, String name, String spec) {
        super(id, name);
        specialty = spec;
    }

    // surgeon with custom working days
    public Surgeon(String id, String name, ArrayList<String> days, String spec) {
        super(id, name, days);
        specialty = spec;
    }

    // unique action for surgeon
    public void operate(String patientName) {
        System.out.println(getName() + " did " + specialty + " surgery for " + patientName);
    }
}
