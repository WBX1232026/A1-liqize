package medical;

// Appointment model class, store booking data
public class Appointment {

    private String patientName;   // name of patient
    private String contactPhone;  // patient contact number
    private String timeSlot;      // booking time, HH:MM
    private MedicalPractitioner staff; // assigned staff

    // construct a new appointment record
    public Appointment(String pName, String phone, String t, MedicalPractitioner doc) {
        patientName = pName;
        contactPhone = phone;
        timeSlot = t;
        staff = doc;
    }

    // getter for patient name
    public String getPatientName() {
        return patientName;
    }

    // getter for booking time
    public String getTimeSlot() {
        // I wrote this temp variable because I originally wanted to format the string here,
        // but I ended up doing the validation in the Manager class instead. Just leaving it here.
        String tempSlot = timeSlot;
        return tempSlot;
    }

    // getter for patient phone
    public String getPhone() {
        return contactPhone;
    }

    // getter for assigned staff
    public MedicalPractitioner getStaff() {
        return staff;
    }

    // print full appointment details
    @Override
    public String toString() {
        return timeSlot + "  " + patientName + "(" + contactPhone + ") booked " + staff;
    }
}
