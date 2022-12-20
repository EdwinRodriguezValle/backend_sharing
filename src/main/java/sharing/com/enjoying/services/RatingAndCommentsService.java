package sharing.com.enjoying.services;


import org.springframework.beans.factory.annotation.Autowired;
import sharing.com.enjoying.dtos.RatingAndCommentsDto;
import sharing.com.enjoying.exceptions.RecordNotFoundException;
import sharing.com.enjoying.models.RatingAndCommentsModel;
import sharing.com.enjoying.repositories.RatingAndCommentsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RatingAndCommentsService {
    //connexion with database
    @Autowired
    private RatingAndCommentsRepository ratingAndCommentsRepository;

    public List<RatingAndCommentsDto> getAllRatingAndCommentsModel(){
        List<RatingAndCommentsDto> dtos = new ArrayList<>();
        List<RatingAndCommentsModel> ratingAndCommentsModels = ratingAndCommentsRepository.findAll();
        for(RatingAndCommentsModel rcm : ratingAndCommentsModels){
            dtos.add(transferToRatingAndCommentsToDto(rcm));
        }
        return dtos;
    }

    /////////////
//    public List<RemoteControllerDto> getAllRemoteControllers() {
//        List<RemoteControllerDto> dtos = new ArrayList<>();
//        List<RemoteController> remoteControllers = remoteControllerRepository.findAll();
//        for (RemoteController rc : remoteControllers) {
//            dtos.add(transferToDto(rc));
//        }
//        return dtos;
//    }

    public RatingAndCommentsDto getRatingAndComments (long id){
        Optional<RatingAndCommentsModel> ratingAndCommentsModel = ratingAndCommentsRepository.findById(id);
        if(ratingAndCommentsModel.isPresent()){
            return transferToRatingAndCommentsToDto(ratingAndCommentsModel.get());
        }else {
            throw new RecordNotFoundException("Not rating and comments found");
        }
    }
    public RatingAndCommentsDto addRatinAndComments(RatingAndCommentsDto ratingAndCommentsDto){
        RatingAndCommentsModel rcm = transferToRatingAndCommentsModel(ratingAndCommentsDto);
        ratingAndCommentsRepository.save(rcm);
        return ratingAndCommentsDto;
    }

    public void deleteRatingAndCommentsModel(Long id){
        ratingAndCommentsRepository.deleteById(id);
    }

    public void updateRatingAndComments(Long id, RatingAndCommentsDto ratingAndCommentsDto){
        if(!ratingAndCommentsRepository.existsById(id)){
            throw new RecordNotFoundException("We could do not found rate and commets");
        }else{
            RatingAndCommentsModel storedRatingAndComments = ratingAndCommentsRepository.findById(id).orElse(null);
            storedRatingAndComments.setId(ratingAndCommentsDto.getId());
            storedRatingAndComments.setRate(ratingAndCommentsDto.getRate());
            storedRatingAndComments.setComments(ratingAndCommentsDto.getComments());
        }
    }

    //Transferring from controller to Dto
    public RatingAndCommentsDto transferToRatingAndCommentsToDto(RatingAndCommentsModel ratingAndCommentsModel) {

        var dto = new RatingAndCommentsDto();

        dto.id = ratingAndCommentsModel.getId();
        dto.rate = ratingAndCommentsModel.getRate();
        dto.comments = ratingAndCommentsModel.getComments();

        return dto;
    }

    public RatingAndCommentsModel transferToRatingAndCommentsModel(RatingAndCommentsDto ratingAndCommentsDto) {
        var ratingAndCommentsModel = new RatingAndCommentsModel();

        ratingAndCommentsModel.setId(ratingAndCommentsDto.id);
        ratingAndCommentsModel.setRate(ratingAndCommentsDto.rate);
        ratingAndCommentsModel.setComments(ratingAndCommentsDto.comments);

        return ratingAndCommentsModel;

    }
}
