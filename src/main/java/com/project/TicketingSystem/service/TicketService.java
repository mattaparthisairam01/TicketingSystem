package com.project.TicketingSystem.service;

import com.project.TicketingSystem.model.Ticket;
import com.project.TicketingSystem.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    public Ticket risedTicket(Ticket request) {
        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setModule(request.getModule());
        ticket.setCategory(request.getCategory());
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepo.save(ticket);
    }

    public Ticket getTicketById(int id) {
        return ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: "+id));
    }

    public void deleteTicketById(int id) {
        ticketRepo.deleteById(id);
    }
}


