package com.project.TicketingSystem.controller;

import com.project.TicketingSystem.model.Ticket;
import com.project.TicketingSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String greet(){
        return "Welcome to Ticketing System";
    }

    @PostMapping("addTicket")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        Ticket addedTicket = ticketService.addTicket(ticket);
        return new ResponseEntity<Ticket>(addedTicket,HttpStatus.CREATED);
    }

    @GetMapping("viewTicket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id){
        Ticket viewTicket = ticketService.getTicketById(id);
        return new ResponseEntity<Ticket>(viewTicket,HttpStatus.OK);
    }
}
