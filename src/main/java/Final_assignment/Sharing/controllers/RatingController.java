package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.BookingDto;
import Final_assignment.Sharing.Dtos.RatingDto;
import Final_assignment.Sharing.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    //Connexion with service class
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    //Crud endpoint
    @GetMapping("/getAllRating")
    public List<RatingDto> getAllRating() {
        var dtos = ratingService.getAllRatingModel();

        return dtos;
    }

    @GetMapping("/rating/{id}")
    public RatingDto getRatingById(@PathVariable("id") Long id) {
        RatingDto ratingDto = ratingService.getRating(id);
        return ratingDto;
    }

    @PostMapping("/postRating")
    public RatingDto addRating(@RequestBody RatingDto dto) {
        RatingDto ratingDto = ratingService.addRatings(dto);
        return ratingDto;
    }

    @DeleteMapping("/deleteRating/{id}")
    public void deleteRating(@PathVariable("id") Long id){
        ratingService.deleteRatingModel(id);
    }

    @PutMapping("/putRating/{id}")
    public RatingDto updateRating(@PathVariable("id") Long id, @RequestBody RatingDto ratingDto){
        ratingService.updateRating(id, ratingDto);
        return ratingDto;
    }

}
