package Final_assignment.Sharing.service;

import Final_assignment.Sharing.Dtos.RatingDto;
import Final_assignment.Sharing.exceptions.RecordNotFoundException;
import Final_assignment.Sharing.models.RatingModel;
import Final_assignment.Sharing.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    //Crud methods

    // Getting all the booking from  repository and transferring to Dtos to be user in the end points
    public List<RatingDto> getAllRatingModel(){
        List<RatingDto> dtos = new ArrayList<>();
        List<RatingModel> ratingModels = ratingRepository.findAll();
        for(RatingModel rm : ratingModels){
            dtos.add(transferFromRatingModelToDto(rm));
        }
        return dtos;
    }

    // Getting all the rating from  repository and transferring to Dtos to be uses in the end points
    public RatingDto getRating (long id){
        Optional<RatingModel> ratingModel = ratingRepository.findById(id);
        if(ratingModel.isPresent()){
            return transferFromRatingModelToDto(ratingModel.get());
        }else {
            throw new RecordNotFoundException("Not rating found");
        }
    }

    // This method add new rating to the database
    public RatingDto addRatings (RatingDto ratingDto){
        RatingModel rm = transferFromRatingDtoToModel(ratingDto);
        ratingRepository.save(rm);
        return ratingDto;
    }

    //This method delete by id a specific data from the database
    public void deleteRatingModel(Long id){
        ratingRepository.deleteById(id);
    }

    //This method update the already existing data in the database
    public void updateRating(Long id, RatingDto ratingDto){
        if(!ratingRepository.existsById(id)){
            throw new RecordNotFoundException("We could do not found rate and commets");
        }else{
            RatingModel storedRating = ratingRepository.findById(id).orElse(null);
            storedRating.setId(ratingDto.getId());
            storedRating.setTitle(ratingDto.getTitle());
            storedRating.setPoints(ratingDto.getPoints());
        }
    }

    //    Transferring from rating  model  to Dto
    public RatingDto transferFromRatingModelToDto(RatingModel ratingModel) {

        var dto = new RatingDto();

        dto.id = ratingModel.getId();
        dto.title = ratingModel.getTitle();
        dto.points = ratingModel.getPoints();

        return dto;

    }

    // Transferring from rating Dto to  rating model
    public RatingModel transferFromRatingDtoToModel(RatingDto ratingDto) {

        var ratingModel = new RatingModel();

        ratingModel.setId(ratingDto.getId());
        ratingModel.setTitle(ratingDto.getTitle());
        ratingModel.setPoints(ratingDto.getPoints());

        return ratingModel;

    }
}
