package medical;

public class Appointment {

    private String patientName;
    private String contactPhone;
    private String timeSlot;
    private MedicalPractitioner staff;

    public Appointment(String pName, String phone, String t, MedicalPractitioner doc) {
        patientName = pName;
        contactPhone = phone;
        timeSlot = t;
        staff = doc;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getPhone() {
        return contactPhone;
    }

    public MedicalPractitioner getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return timeSlot + "  " + patientName + "(" + contactPhone + ") booked " + staff;
    }
}