package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.BookingDto;
import Final_assignment.Sharing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    //Connexion  with service
    private final BookingService bookingService;

    //Constructor
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getAllBooking")
    public List<BookingDto> getAllBooking() {
        var dtos = bookingService.getAllBooking();

        return dtos;
    }

    @GetMapping("/booking/{id}")
    public BookingDto getBookingById(@PathVariable("id") Long id) {
        BookingDto bookingDto = bookingService.getBookingModel(id);
        return bookingDto;
    }

    @PostMapping("/postBooking")
    public BookingDto addBooking(@RequestBody BookingDto dto) {
        BookingDto bookingDto = bookingService.addBooking(dto);
        return bookingDto;
    }

    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBooking(@PathVariable("id") Long id){
        bookingService.deleteBooking(id);
    }

    @PutMapping("/putBooking/{id}")
    public BookingDto updateBooking(@PathVariable("id") Long id, @RequestBody BookingDto bookingDto){
        bookingService.updateBooking(id, bookingDto);
        return bookingDto;
    }

}
