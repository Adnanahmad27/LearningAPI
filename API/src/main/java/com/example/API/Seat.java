package com.example.API;

import javax.xml.crypto.Data;

public class Seat {
    private int seatNo;
    private int employeeId;
    private Data date;
    private boolean isReserved;

    public Seat(int seatNo, int employeeId, Data date, boolean isReserved) {
        this.seatNo = seatNo;
        this.employeeId = employeeId;
        this.date = date;
        this.isReserved = isReserved;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Data getDate() {
        return date;
    }

    public boolean isReserved() {
        return isReserved;
    }
}
