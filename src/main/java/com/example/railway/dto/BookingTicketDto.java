package com.example.railway.dto;

import com.example.railway.domain.Ticket;
import com.example.railway.domain.Train;

import java.io.Serializable;
import java.util.List;

public record BookingTicketDto(
        List<Train> trains,
        List<Ticket> tickets,
        Long occupiedSeats,
        Long emptySeats

) implements Serializable {}
