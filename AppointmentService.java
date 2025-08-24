package Appointment;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

public class AppointmentService {

    private static List<Appointment> appointmentList = new ArrayList<Appointment>();

    // ID to assign to incoming appointments
    private static int currID = 0;

    public static void clearList() {
        appointmentList.clear();
        currID = 0;
    }

    public static int sizeOfList() {
        return appointmentList.size();
    }

    /**
     * Adds a new appointment to the appointmentList using a generated appointmentID
     * @param date
     * @param description
     */
    public static void addAppointment(Date date, String description) {
        // convert currID to string to assign to the appointment being added
        String strID = Integer.toString(currID);
        Appointment appointment = new Appointment(strID, date, description);
        appointmentList.add(appointment);
        // increment currID so the next appointment has another unique ID
        currID += 1;
    }

    /**
     * Find an appointment in the private appointment list using its ID,
     * throws a NoSuchElementException if no appointment is found
     * @param targetID
     */
    public static Appointment getAppointment(String targetID) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getAppointmentID().equals(targetID)) {
                return appointmentList.get(i);
            }
        }
        throw new NoSuchElementException("No matching appointment");
    }

    /**
     * Delete an appointment using the appointmentID
     * @param targetID
     */
    public static void deleteAppointmentByID(String targetID) {
        try {
            Appointment appointment = getAppointment(targetID);
            appointmentList.remove(appointment);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
