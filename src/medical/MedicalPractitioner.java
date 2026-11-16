package medical;

import java.util.ArrayList;

// abstract superclass for all medical staff
public abstract class MedicalPractitioner {

    private String id;          // unique staff id number
    private String name;        // staff full name
    private ArrayList<String> workDays;  // days this staff works

    // full constructor for custom working days
    public MedicalPractitioner(String id, String name, ArrayList<String> workDays) {
        this.id = id;
        this.name = name;
        this.workDays = workDays;
    }

    // overloaded constructor, default work days Mon-Fri
    public MedicalPractitioner(String id, String name) {
        ArrayList<String> dList = new ArrayList<>();
        dList.add("MON");
        dList.add("TUE");
        dList.add("WED");
        dList.add("THU");
        dList.add("FRI");
        this.id = id;
        this.name = name;
        this.workDays = dList;
    }

    // getter for staff name
    public String getName() {
        return name;
    }

    // getter for staff id
    public String getID() {
        return id;
    }

    // getter for working day list
    public ArrayList<String> getWorkDays() {
        return workDays;
    }

    // return the job title of staff
    public abstract String roleType();
    // return extra details specific to each role
    public abstract String extraInfo();

    // print readable staff info
    @Override
    public String toString() {
        return roleType() + " | id=" + id + " | name=" + name + " | working:" + workDays + " | " + extraInfo();
    }

    // compare staff using id
    @Override
    public boolean equals(Object o) {
        // check if the object belongs to this class
        if (o instanceof MedicalPractitioner) {
            MedicalPractitioner m = (MedicalPractitioner) o;
            // had a NullPointerException here before when id was empty
            if(this.id == null || m.id == null){
                return false;
            }
            return this.id.equals(m.id);
        }
        return false;
    }

}
