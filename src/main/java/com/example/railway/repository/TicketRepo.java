package com.example.railway.repository;

import com.example.railway.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {
    @Query("select t from Ticket t where upper(t.train.name) like upper(?1)")
    List<Ticket> findAllTicketByTrainName(String name);

    /*@Query("select t from Ticket t where t.departureDate = ?1")
    List<Ticket> findAllticketByDate(Date departureDate);*/
    List<Ticket> findAllByDepartureDate(LocalDate date);
    @Query("select t from Ticket  t")
    List<Ticket> getAll();
}
