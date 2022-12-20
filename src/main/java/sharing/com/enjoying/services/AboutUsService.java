package sharing.com.enjoying.services;

import org.springframework.stereotype.Service;
import sharing.com.enjoying.dtos.AboutUsDto;
import sharing.com.enjoying.dtos.BookingDto;
import sharing.com.enjoying.exceptions.RecordNotFoundException;
import sharing.com.enjoying.models.AboutUsModel;
import sharing.com.enjoying.models.BookingModel;
import sharing.com.enjoying.repositories.AboutUsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AboutUsService {

    private static AboutUsRepository aboutUsRepository;

    //CRUD methods

    public List <AboutUsDto> getAllDescriptions() {
        List<AboutUsModel> aboutUsModelList = aboutUsRepository.findAll();
        List<AboutUsDto> dtos = new ArrayList<>();
        for (AboutUsModel x : aboutUsModelList) {
            dtos.add(transferringToAbouUsDto(x));
        }
        return dtos;
    }

    public AboutUsDto getAboutUs(long id){
        Optional<AboutUsModel> aboutUsModel= aboutUsRepository.findById(id);
        if(aboutUsModel.isPresent()){
            AboutUsDto aboutUsDto = transferringToAbouUsDto(aboutUsModel.get());
            return aboutUsDto;
        }else {
            throw new RecordNotFoundException("About us not found.");
        }
    }


    public AboutUsDto addAboutUsModel(AboutUsDto aboutUsDto){
        AboutUsModel aboutUsModel = transferringToAboutUsModel(aboutUsDto);
        aboutUsRepository.save(aboutUsModel);
        return  transferringToAbouUsDto(aboutUsModel);
    }

    public void deleteAboutUsModel(Long id){
        aboutUsRepository.deleteById(id);
    }

    public void updateAboutUsModel(Long id, AboutUsDto aboutUsDto){
        if(!aboutUsRepository.existsById(id)){
            throw new RecordNotFoundException("No comments found.");
        }
        AboutUsModel storedAboutUsModel = aboutUsRepository.findById(id).orElse(null);
        storedAboutUsModel.setId(aboutUsDto.getId());
        storedAboutUsModel.setDescription(aboutUsDto.getDescription());
    }

    //Transferring from Dto to model
    public AboutUsModel transferringToAboutUsModel(AboutUsDto aboutUsDto){
        var aboutUsModel = new AboutUsModel();

        aboutUsModel.setId(aboutUsModel.getId());
        aboutUsModel.setDescription(aboutUsModel.getDescription());

        return aboutUsModel;
    }

    //Transferring from model to Dto
    public AboutUsDto transferringToAbouUsDto(AboutUsModel aboutUsModel) {
        AboutUsDto dto = new AboutUsDto();

        dto.id = aboutUsModel.getId();
        dto.description = aboutUsModel.getDescription();

        return dto;
    }

}
