package com.ilkerdev.reservation.reservationbackend.rest;


import com.ilkerdev.reservation.reservationbackend.entity.Tables;
import com.ilkerdev.reservation.reservationbackend.entity.User;
import com.ilkerdev.reservation.reservationbackend.service.TableServiceImpl;
import com.ilkerdev.reservation.reservationbackend.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TableRestController {

    private TableServiceImpl tableService;

    @Autowired
    public TableRestController(TableServiceImpl tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/tables")
    public List<Tables> findAll(){
        return tableService.findAll();
    }

    @GetMapping("/tables/{tableId}")
    public Tables findById(@PathVariable String tableId){
        Tables table = tableService.findById(tableId);
        if (tableId == null){
            throw new RuntimeException("Table not found");
        }
        return  table;
    }

}
