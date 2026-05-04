package com.project.TicketingSystem.service;

import com.project.TicketingSystem.model.Ticket;
import com.project.TicketingSystem.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    public Ticket addTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }
}
