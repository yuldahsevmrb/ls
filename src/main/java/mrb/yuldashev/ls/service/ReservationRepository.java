package mrb.yuldashev.ls.service;

import mrb.yuldashev.ls.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Set<Reservation> findReservationsByDate(Date date);
}
