package com.example.railway.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String T_from;
    String T_to;
    LocalDate departureDate;
    LocalDateTime departureTime;
    LocalDateTime reachTime;
    Double price;
    Long numberOfSeat;

    @ManyToOne
    Train train;

}
