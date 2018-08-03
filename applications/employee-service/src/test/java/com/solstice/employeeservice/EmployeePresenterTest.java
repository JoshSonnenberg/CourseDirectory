package com.solstice.employeeservice;

import com.solstice.employeeservice.models.EmployeeInfo;
import com.solstice.employeeservice.models.EmployeeRecord;
import com.solstice.employeeservice.utils.EmployeePresenter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeePresenterTest {

    @Test
    public void testPresentEmployee() {
        EmployeeInfo expectedInfo = new EmployeeInfo("abc123", "ben", "gimbel", 123, "Chicago", "bgimbel@solstice.com", "Technical Analyst", "url");

        EmployeeRecord record = new EmployeeRecord("abc123", "ben", "gimbel", 123, "Chicago", "bgimbel@solstice.com", "Technical Analyst", "url");
        EmployeePresenter presenter = new EmployeePresenter();
        EmployeeInfo info = presenter.present(record);

        assertEquals(info, expectedInfo);
    }

}
