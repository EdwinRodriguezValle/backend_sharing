package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.CommentsDto;
import Final_assignment.Sharing.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/comments/{id}")
    public CommentsDto getComments(@PathVariable("id") Long id){
        CommentsDto commentsDto = commentsService.getComments(id);
        return commentsDto;
    }

    @PostMapping("/addComments")
    public CommentsDto addCommentsDto(@RequestBody CommentsDto dto){
        CommentsDto commentsDto = commentsService.addComments(dto);
        return commentsDto;
    }

    @DeleteMapping("/deleteComment")
    public void deleteComments(@PathVariable("id") Long id, CommentsDto dto){
        CommentsDto dto1 = commentsService.getComments(id);
    }

    @PutMapping("/ratingAndComments/{id}")
    public CommentsDto updateCommentsDto(@PathVariable("id") Long id, CommentsDto dto ){
       CommentsDto dto1 = commentsService.getComments(id);
        return dto1;

    }
}
