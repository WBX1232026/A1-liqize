package medical;

import java.util.ArrayList;

// GP subclass, inherit from MedicalPractitioner
public class GeneralPractitioner extends MedicalPractitioner {

    private int maxMedLimit;  // max medicine this GP can prescribe

    // create GP with custom work days
    public GeneralPractitioner(String id, String name, ArrayList<String> days, int limit) {
        super(id, name, days);
        maxMedLimit = limit;
    }

    // create GP with default work days and default medicine limit
    public GeneralPractitioner(String id, String name) {
        super(id, name);
        maxMedLimit = 10;
    }

    // return job type string
    @Override
    public String roleType() {
        return "GP";
    }

    // return GP specific detail
    @Override
    public String extraInfo()
    {
        return "maxMed=" + maxMedLimit;
    }

    // GP-only action: prescribe medicine
    public void prescribeDrug(String medicine) {
        System.out.println(getName() + " prescribed " + medicine);
    }
}
