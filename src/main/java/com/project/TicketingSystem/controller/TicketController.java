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

    @PostMapping("riseTicket")
    public ResponseEntity<Ticket> riseTicket(@RequestBody Ticket ticket){
        Ticket risedTicket = ticketService.risedTicket(ticket);
        return new ResponseEntity<Ticket>(risedTicket,HttpStatus.CREATED);
    }

    @GetMapping("viewTicket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id){
        Ticket viewTicket = ticketService.getTicketById(id);
        return new ResponseEntity<Ticket>(viewTicket,HttpStatus.OK);
    }

    @DeleteMapping("deleteTicket/{id}")
    public ResponseEntity<String> deleteTicketById(@PathVariable int id){
        ticketService.deleteTicketById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
