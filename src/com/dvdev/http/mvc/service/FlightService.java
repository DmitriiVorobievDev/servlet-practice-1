package com.dvdev.http.mvc.service;

import com.dvdev.http.mvc.dao.FlightDao;
import com.dvdev.http.mvc.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/*
 * Преобразуем метод findAll() из FlightDao в метод на уровне сервисов
 */

public class FlightService {

    //синглтон
    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance(); //1 объект INSTANCE

    private FlightService() {
    }

    public List<FlightDto> findAll() { //преобразуем все сущности(строки) в DTO
        return flightDao.findAll().stream()
                .map(flight -> new FlightDto( //преобразуем entity в dto
                        flight.getId(),
                        """
                                %s - %s - %s
                                """.formatted(flight.getDepartureAirportCode(),
                                flight.getArrivalAirportCode(),
                                flight.getStatus())
                ))
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
