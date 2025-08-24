package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import Appointment.Appointment;

public class AppointmentTest {

    private String validAppointmentID = "1001";
    private Date validDate;
    private Calendar c = Calendar.getInstance();
    private String validDescription = "A really good appointment description";

    // Initialize validDate to tomorrow before each test
    @BeforeEach
    void setup() {
        validDate = new Date();
        c.setTime(validDate);
        c.add(Calendar.DATE, 1);
        validDate = c.getTime();
    }

    @Test
    void testValidAppointment() {
        Appointment testAppointment = new Appointment(validAppointmentID, validDate, validDescription);

        assertEquals(validAppointmentID, testAppointment.getAppointmentID());
        assertEquals(validDate, testAppointment.getDate());
        assertEquals(validDescription, testAppointment.getDescription());
    }

    @Test
    void testInvalidAppointmentID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("Illegal Appointment ID", validDate, validDescription);
        });
    }

    @Test
    void testInvalidDate() {
        c.setTime(validDate);
        c.add(Calendar.DATE, -7);
        Date invalidDate = c.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(validAppointmentID, invalidDate, validDescription);
        });
    }

    @Test
    void testInvalidDescription() {
        String longDescription = "Illegal Appointment Description that is way way way way toooooooooooo long";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(validAppointmentID, validDate, longDescription);
        });
    }

    @Test
    void testNullAppointmentID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, validDate, validDescription);
        });
    }

    @Test
    void testNullDate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(validAppointmentID, null, validDescription);
        });
    }

    @Test
    void testNullDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(validAppointmentID, validDate, null);
        });
    }
}
