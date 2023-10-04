package com.example.API;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class RepositoryLayer {

    HashMap<Integer , Employee> employeeHashMap = new HashMap<>(); // empId -> key && Employee --> value
    HashMap<Integer , Seat> seatHashMap = new HashMap<>(); // seatNo -> key && Seat -> value
    HashMap<Date, List<Seat>> dateListHashMap = new HashMap<>(); // Date -> key && List<Seat> -> value
    HashMap<Integer, List<Date>> employeeListHashMap = new HashMap<>(); // empId -> key && List<Date> --> value

    public void addEmployee(Employee employee) {
        int key = employee.getEmployeeId();
        employeeHashMap.put(key , employee);
    }
    public void addSeat(Seat seat){
        int key = seat.getSeatNo();
        seatHashMap.put(key , seat);

        Date date = (Date)seat.getDate();
        addDateOnSeat(date,seat);
        int empId = seat.getEmployeeId();
        addEmployeeOnGivenDate(empId,date);
    }
    public void addEmployeeOnGivenDate(int empId,Date date){
        if(employeeListHashMap.containsKey(empId)){
            List<Date> lt = employeeListHashMap.get(empId);
            lt.add(date);
            employeeListHashMap.put(empId,lt);
        }else{
            List<Date> lt = new ArrayList<>();
            lt.add(date);
            employeeListHashMap.put(empId,lt);
        }
    }
    public void addDateOnSeat(Date date , Seat seat){
        if(dateListHashMap.containsKey(date)){
            List<Seat> lt = dateListHashMap.get(date);
            lt.add(seat);
            dateListHashMap.put(date,lt);
        }else{
            List<Seat> lt = new ArrayList<>();
            lt.add(seat);
            dateListHashMap.put(date,lt);
        }
    }

    public List<List<Date>> getDateList() {
        return employeeListHashMap.values().stream().toList();
    }

    public List<List<Seat>> getAllSeatList(){
        return dateListHashMap.values().stream().toList();
    }
    public List<Seat> getSeatList(Date date){
        List<Seat> lt = new ArrayList<>();
        for(Date key : dateListHashMap.keySet()){
            if(key.compareTo(date)==0){
                return dateListHashMap.get(key);
            }
        }
        return lt;
    }

    public Employee getEmployee(int id) {
        return employeeHashMap.get(id);
    }
}
