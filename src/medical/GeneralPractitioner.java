package medical;

import java.util.ArrayList;

public class GeneralPractitioner extends MedicalPractitioner {

    private int maxMedLimit;

    public GeneralPractitioner(String id, String name, ArrayList<String> days, int limit) {
        super(id, name, days);
        maxMedLimit = limit;
    }

    public GeneralPractitioner(String id, String name) {
        super(id, name);
        maxMedLimit = 10;
    }

    @Override
    public String roleType() {
        return "GP";
    }

    @Override
    public String extraInfo() {
        return "maxMed=" + maxMedLimit;
    }

    public void prescribeDrug(String medicine) {
        System.out.println(getName() + " prescribed " + medicine);
    }
}