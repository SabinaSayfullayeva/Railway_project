package com.example.railway.service.impl;

import com.example.railway.domain.Ticket;
import com.example.railway.dto.web.JwtTokenResponse;
import com.example.railway.provider.JwtTokenProvider;
import com.example.railway.repository.TicketRepo;
import com.example.railway.service.BookingService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class BookingServiceImpl implements BookingService {
    private  final TicketRepo ticketRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public BookingServiceImpl(TicketRepo ticketRepo, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.ticketRepo = ticketRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public JwtTokenResponse searching(String massage) {
if (massage.isEmpty())
{
    System.out.println(" field can not be empty");
    return null ;
}
else if (!ticketRepo.findAllTicketByTrainName(massage).isEmpty()) {

    return (JwtTokenResponse) ticketRepo.findAllTicketByTrainName(massage);
}/*else if (!ticketRepo.findAllByDepartureDate(LocalDate.parse(massage)).isEmpty()) {
            return (JwtTokenResponse) ticketRepo.findAllByDepartureDate(LocalDate.parse(massage));
        }*/
return null;

    }



}
