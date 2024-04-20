package com.example.railway.controller;

import com.example.railway.domain.Ticket;
import com.example.railway.dto.web.JwtTokenResponse;
import com.example.railway.repository.TicketRepo;
import com.example.railway.service.impl.BookingServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingServiceImpl bookingService;
    private final TicketRepo ticketRepo;
    @GetMapping("/search/{message}")
    public List<Ticket> search(@PathVariable String message)
    {
        return  ticketRepo.findAllTicketByTrainName(message);
    }

}
