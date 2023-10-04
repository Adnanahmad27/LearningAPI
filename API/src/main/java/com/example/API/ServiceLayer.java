package com.example.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceLayer {
    @Autowired
    RepositoryLayer repositoryLayer ;

    public void addEmployee(Employee employee) {
        repositoryLayer.addEmployee(employee);
    }

    public void addSeat(Seat seat) {
        repositoryLayer.addSeat(seat);
    }
    public int getEmployeeComeMoreThan5Time() {
        List<List<Date>> list = repositoryLayer.getDateList();
        int cnt = 0;
        for(List<Date> l : list){
            if(l.size() > 5) cnt++;
        }
        return cnt;
    }
    public int getVacantSeat(Date date) {
        List<Seat> list = repositoryLayer.getSeatList(date); // date -> booked seat
        return 50 - list.size();
    }

    public int getEmpOfSameTeam(Date date) {
        List<Seat> list = repositoryLayer.getSeatList(date);
        HashMap<String ,Integer> fmap = new HashMap<>(); // store cnt
        for(Seat seat : list){
            int id = seat.getEmployeeId();
            Employee emp = repositoryLayer.getEmployee(id);
            String team = emp.getTeam();
            fmap.put(team , fmap.getOrDefault(team,0)+1);
        }
        int cnt = 0;
        for(int val : fmap.values()){
            if(val > 1){
                cnt++;
            }
        }
        return cnt;
    }
    public int getNoOfEmployeeOfSameTeam(String team, Date date) {
        List<Seat> list = repositoryLayer.getSeatList(date);
        int cnt = 0;
        for(Seat seat : list){
            int empId = seat.getEmployeeId();
            Employee employee = repositoryLayer.getEmployee(empId);
            String t = employee.getTeam();
            if(t.equals(team)){
                cnt++;
            }
        }
        return cnt;
    }
}
