package medical;

import java.util.ArrayList;

public class Nutritionist extends MedicalPractitioner {

    private String focusArea;

    public Nutritionist(String id, String name, ArrayList<String> days, String focus) {
        super(id, name, days);
        focusArea = focus;
    }

    public Nutritionist(String id, String name, String focus) {
        super(id, name);
        focusArea = focus;
    }

    public void buildDietPlan(String person) {
        System.out.println(getName() + " created " + focusArea + " diet plan for " + person);
    }

    @Override
    public String roleType() {
        return "Nutritionist";
    }

    @Override
    public String extraInfo() {
        return "focus:" + focusArea;
    }
}