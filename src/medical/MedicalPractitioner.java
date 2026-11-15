package medical;

import java.util.ArrayList;

// abstract parent class for all staff
public abstract class MedicalPractitioner {

    private String id;
    private String name;
    private ArrayList<String> workDays;

    public MedicalPractitioner(String id, String name, ArrayList<String> workDays) {
        this.id = id;
        this.name = name;
        this.workDays = workDays;
    }

    public MedicalPractitioner(String id, String name) {
        // default Mon-Fri if not passed
        ArrayList<String> days = new ArrayList<>();
        days.add("MON");
        days.add("TUE");
        days.add("WED");
        days.add("THU");
        days.add("FRI");
        this.id = id;
        this.name = name;
        this.workDays = days;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public ArrayList<String> getWorkDays() {
        return workDays;
    }

    // must be implemented by subclasses
    public abstract String roleType();
    public abstract String extraInfo();

    @Override
    public String toString() {
        return roleType() + " | id=" + id + " | name=" + name + " | working:" + workDays + " | " + extraInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MedicalPractitioner) {
            MedicalPractitioner m = (MedicalPractitioner) o;
            // null check to prevent crash
            if (this.id == null || m.id == null) {
                return false;
            }
            return this.id.equals(m.id);
        }
        return false;
    }

}