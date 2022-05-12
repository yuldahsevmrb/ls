package mrb.yuldashev.ls.util;

import mrb.yuldashev.ls.business.ReservationService;
import mrb.yuldashev.ls.business.RoomReservation;
import mrb.yuldashev.ls.model.Guest;
import mrb.yuldashev.ls.model.Reservation;
import mrb.yuldashev.ls.model.Room;
import mrb.yuldashev.ls.service.GuestRepository;
import mrb.yuldashev.ls.service.ReservationRepository;
import mrb.yuldashev.ls.service.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservationList = this.reservationService.getRoomReservationsForDate(date);
        reservationList.forEach(System.out::println);

    }
}
