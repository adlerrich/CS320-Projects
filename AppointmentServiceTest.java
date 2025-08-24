package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import Appointment.AppointmentService;

public class AppointmentServiceTest {

    private Date validDate;
    private String validDescription = "Legal Appointment Description";

    @BeforeEach
    void setup() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        validDate = c.getTime();
    }

    @AfterEach
    void teardown() {
        AppointmentService.clearList();
    }

    @Test
    void testAddAppointment() {
        AppointmentService.addAppointment(validDate, validDescription);
        assertEquals(1, AppointmentService.sizeOfList());
        assertEquals("0", AppointmentService.getAppointment("0").getAppointmentID());
        assertEquals(validDate, AppointmentService.getAppointment("0").getDate());
        assertEquals(validDescription, AppointmentService.getAppointment("0").getDescription());
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService.addAppointment(validDate, validDescription);
        AppointmentService.addAppointment(validDate, validDescription);

        AppointmentService.deleteAppointmentByID("1");

        Assertions.assertThrows(
            NoSuchElementException.class,
            () -> AppointmentService.getAppointment("1")
        );
    }
}
