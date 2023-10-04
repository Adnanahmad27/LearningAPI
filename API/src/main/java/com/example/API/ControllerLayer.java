package com.example.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ControllerLayer {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        serviceLayer.addEmployee(employee);
        return "Employee is added Successfully";
    }

    @PostMapping("/addSeat")
    public String addSeat(@RequestBody Seat seat){
        serviceLayer.addSeat(seat);
        return "Seat is added Successfully";
    }
    @GetMapping("/getVacantSeat/{date}")
    public int getVacantSeat(@PathVariable("date") Date date){
        return serviceLayer.getVacantSeat(date);
    }
    @GetMapping("/EmployeeMoreThan5")
    public int getEmployeeComeMoreThan5Time(){
        return serviceLayer.getEmployeeComeMoreThan5Time();
    }
    @GetMapping("/getEmpOnGivenDate/{date}")
    public int getEmOnGivenDate(@PathVariable("date") Date date){
        return serviceLayer.getEmpOfSameTeam(date);
    }

    @GetMapping("/getNoOfEmployeeOfSameTeam/{team}/{date}")
    public int getNoOfEmployeeOfSameTeam(@PathVariable("team") String team , @PathVariable("date") Date date){
        return serviceLayer.getNoOfEmployeeOfSameTeam(team ,date);
    }

}
