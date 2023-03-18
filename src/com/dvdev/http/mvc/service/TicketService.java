package com.dvdev.http.mvc.service;

import com.dvdev.http.mvc.dao.TicketDao;
import com.dvdev.http.mvc.dto.TicketDto;
import com.dvdev.http.mvc.entity.Ticket;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }


    //преобразуем Dao -> Dto
    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllById(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()
                ))
                .collect(toList());
    }
}
