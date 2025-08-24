package Appointment;

import java.util.Date;

public class Appointment {

    private String appointmentID;
    private Date date;
    private String description;

    /**
     * Validates appointmentID
     * @param appointmentID
     * @return boolean
     */
    private Boolean validateAppointmentID(String appointmentID) {
        if (appointmentID == null || appointmentID.length() > 10) {
            return false;
        }
        return true;
    }

    /**
     * Validates appointment date
     * @param date
     * @return boolean
     */
    private Boolean validateDate(Date date) {
        if (date == null || date.before(new Date())) {
            return false;
        }
        return true;
    }

    /**
     * Validates appointment description
     * @param description
     * @return boolean
     */
    private Boolean validateDescription(String description) {
        if (description == null || description.length() > 50) {
            return false;
        }
        return true;
    }

    public Appointment(String appointmentID, Date date, String description) {
        if (!this.validateAppointmentID(appointmentID)) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        if (!this.validateDate(date)) {
            throw new IllegalArgumentException("Invalid date");
        }

        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentID = appointmentID;
        this.date = date;
        this.description = description;
    }

    // appointmentID only has a getter, it is not updatable
    public String getAppointmentID() {
        return this.appointmentID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        if (!validateDate(date)) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (!validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
