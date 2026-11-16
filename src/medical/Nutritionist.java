package medical;

import java.util.ArrayList;

// Nutritionist subclass
public class Nutritionist extends MedicalPractitioner {

    private String focusArea;  // nutrition focus field

    // nutritionist with custom work days
    public Nutritionist(String id, String name, ArrayList<String> days, String focus) {
        super(id, name, days);
        focusArea = focus;
    }

    // nutritionist with default work days
    public Nutritionist(String id, String name, String focus) {
        super(id, name);
        focusArea = focus;
    }

    // nutritionist exclusive function
    public void buildDietPlan(String person) {
        System.out.println(getName() + " created " + focusArea + " diet plan for " + person);
    }

    // return job type
    @Override
    public String roleType() {
        return "Nutritionist";
    }

    // return nutritionist focus detail
    @Override
    public String extraInfo() {
        return "focus:" + focusArea;
    }
}
