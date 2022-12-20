package sharing.com.enjoying.services;

import org.springframework.beans.factory.annotation.Autowired;
import sharing.com.enjoying.dtos.BookingDto;
import sharing.com.enjoying.exceptions.RecordNotFoundException;
import sharing.com.enjoying.models.BookingModel;
import sharing.com.enjoying.repositories.BookingRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BookingService {
    //connexion with database
    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingDto> getAllBooking(){
        List<BookingModel> bookingModels = bookingRepository.findAll();
        List<BookingDto> dtos = new ArrayList<>();

        for(BookingModel bm : bookingModels){
            dtos.add(transferToBookingDto(bm));
        }
        return dtos;
    }

    public BookingDto getBookingModel(long id){
        Optional<BookingModel> bookingModel= bookingRepository.findById(id);
        if(bookingModel.isPresent()){
            BookingDto bookingDto = transferToBookingDto(bookingModel.get());
            return bookingDto;
        }else {
            throw new RecordNotFoundException("Booking not found.");
        }
    }

    public BookingDto addBooking (BookingDto bookingDto){
        bookingRepository.save(transferToBookingModel(bookingDto));
        return bookingDto;
    }

    public void deleteBooking (Long id){
        bookingRepository.deleteById(id);
    }

    public void updateBooking (Long id, BookingDto bookingDto){
        if(!bookingRepository.existsById(id)){
            throw new RecordNotFoundException("No booking found");
        }
        BookingModel storedBookingModel = bookingRepository.findById(id).orElse(null);
        storedBookingModel.setId(bookingDto.getId());
        storedBookingModel.setServiceType(bookingDto.getServiceType());
        storedBookingModel.setDate(bookingDto.getDate());
        storedBookingModel.setPrice(bookingDto.getPrice());
        bookingRepository.save(storedBookingModel);
    }

    //Transferring from controller to Dto
    public BookingDto transferToBookingDto(BookingModel bookingModel) {

        var dto = new BookingDto();

        dto.id = bookingModel.getId();
        dto.serviceType = bookingModel.getServiceType();
        dto.date = bookingModel.getDate();
        dto.price = bookingModel.getPrice();

        return dto;
    }

    //Transferring from  Dto to BookingModel
    public BookingModel transferToBookingModel(BookingDto bookingDto) {
        var bookingModel = new BookingModel();

        bookingModel.setId(bookingDto.id);
        bookingModel.setServiceType(bookingDto.serviceType);
        bookingModel.setDate(bookingDto.date);
        bookingModel.setPrice(bookingDto.price);

        return bookingModel;
    }

}
