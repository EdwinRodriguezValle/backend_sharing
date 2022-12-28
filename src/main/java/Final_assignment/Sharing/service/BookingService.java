package Final_assignment.Sharing.service;

import Final_assignment.Sharing.Dtos.BookingDto;
import Final_assignment.Sharing.exceptions.RecordNotFoundException;
import Final_assignment.Sharing.models.BookingModel;
import Final_assignment.Sharing.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    //Crud methods

    //Getting all the booking from  repository and transferring to Dtos to be user in the end points
    public List<BookingDto> getAllBooking(){
        List<BookingModel> bookingModels = bookingRepository.findAll();
        List<BookingDto> dtos = new ArrayList<>();

        for(BookingModel bm : bookingModels){
            dtos.add(transferFromBookingModelToDto(bm));
        }
        return dtos;
    }

    //Get individual booking to be transfer to the client if it exists in de database
    public BookingDto getBookingModel(long id){
        Optional<BookingModel> bookingModel= bookingRepository.findById(id);
        if(bookingModel.isPresent()){
            BookingDto bookingDto = transferFromBookingModelToDto(bookingModel.get());
            return bookingDto;
        }else {
            throw new RecordNotFoundException("Booking not found.");
        }
    }

    // This method add new booking to the database
    public BookingDto addBooking (BookingDto bookingDto){
        bookingRepository.save(transferFromBookingDtoToModel(bookingDto));
        return bookingDto;
    }

    //This method delete by id a specific data from the database
    public void deleteBooking (Long id){
        bookingRepository.deleteById(id);
    }

    //This method update the already existing data in the database
    public void updateBooking (Long id, BookingDto bookingDto){
        if(!bookingRepository.existsById(id)){
            throw new RecordNotFoundException("No booking found");
        }
        BookingModel storedBookingModel = bookingRepository.findById(id).orElse(null);

        storedBookingModel.setId(bookingDto.getId());
        storedBookingModel.setServiceType(bookingDto.getServiceType());
        storedBookingModel.setEntranceDate(bookingDto.getEntranceDate());
        storedBookingModel.setDepartureDate(bookingDto.getDepartureDate());
        storedBookingModel.setPrice(bookingDto.getPrice());

        bookingRepository.save(storedBookingModel);
    }

    //Transferring from Booking  model  to Dto
  public BookingDto transferFromBookingModelToDto(BookingModel bookingModel) {

        var dto = new BookingDto();

        dto.id = bookingModel.getId();
        dto.serviceType = bookingModel.getServiceType();
        dto.entranceDate = bookingModel.getEntranceDate();
        dto.departureDate = bookingModel.getDepartureDate();
        dto.price = bookingModel.getPrice();

        return dto;
    }

    // Transferring from booking Dto to  booking model
    public BookingModel transferFromBookingDtoToModel(BookingDto bookingDto){
        var bookingModel = new BookingModel();

        bookingModel.setId(bookingDto.getId());
        bookingModel.setServiceType(bookingDto.getServiceType());
        bookingModel.setEntranceDate(bookingDto.getEntranceDate());
        bookingModel.setDepartureDate(bookingDto.getDepartureDate());
        bookingModel.setPrice(bookingDto.getPrice());

        return bookingModel;
    }

}
