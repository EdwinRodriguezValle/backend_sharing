package sharing.com.enjoying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sharing.com.enjoying.dtos.RatingAndCommentsDto;
import sharing.com.enjoying.services.RatingAndCommentsService;

import java.util.List;

@RestController
public class RatingAndCommentsController {
    private final RatingAndCommentsService ratingAndCommentsService;

    @Autowired

    public RatingAndCommentsController(RatingAndCommentsService ratingAndCommentsService) {
        this.ratingAndCommentsService = ratingAndCommentsService;
    }

    @GetMapping("/ratingAndComment/")
    public List<RatingAndCommentsDto> getAllRatingAndCommentsDto(){
        var dtos = ratingAndCommentsService.getAllRatingAndCommentsModel();
        return dtos;
    }

    @GetMapping("ratingAndComments/ {id}")
    public RatingAndCommentsDto getRatingAndComments(@PathVariable("id") Long id){
        RatingAndCommentsDto x = ratingAndCommentsService.getRatingAndComments(id);
        return x;
    }

    @PostMapping("/ratingAndComments")

    public RatingAndCommentsDto addRatingAndCommentsDto(@RequestBody RatingAndCommentsDto dto){
        RatingAndCommentsDto y = ratingAndCommentsService.addRatinAndComments(dto);
         return y;
    }

    @DeleteMapping("/ratingAndComment/")
    public void deleteRatingAndComments(@PathVariable("id") Long id, RatingAndCommentsDto dto){
        RatingAndCommentsDto dto1 = ratingAndCommentsService.getRatingAndComments(id);
    }

    @PutMapping("/ratingAndComments/{id}")
    public RatingAndCommentsDto updateRatingAndCommentsDto(@PathVariable("id") Long id, RatingAndCommentsDto dto ){
        RatingAndCommentsDto dto1 = ratingAndCommentsService.getRatingAndComments(id);
        return dto1;

    }
}


