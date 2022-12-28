package Final_assignment.Sharing.service;

import Final_assignment.Sharing.Dtos.CommentsDto;
import Final_assignment.Sharing.exceptions.RecordNotFoundException;
import Final_assignment.Sharing.models.CommentsModel;
import Final_assignment.Sharing.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;

    //Crud methods
    // Getting all the comments from  repository and transferring to Dtos to be user in the end points
    public List<CommentsDto> getAllCommentsModel(){
        List<CommentsDto> dtos = new ArrayList<>();
        List<CommentsModel> commentsModels = commentsRepository.findAll();
        for(CommentsModel cm : commentsModels){
            dtos.add(transferFromCommentsModelToDto(cm));
        }
        return dtos;
    }

    //Get individual comments to be transfer to the client if exists in de database
     public CommentsDto getComments (long id){
        Optional<CommentsModel> commentsModel = commentsRepository.findById(id);
        if(commentsModel.isPresent()){
            return transferFromCommentsModelToDto(commentsModel.get());
        }else {
            throw new RecordNotFoundException("Not comments found");
        }
    }

    // This method add new comments to the database
    public CommentsDto addComments(CommentsDto commentsDto){
        CommentsModel cm = transferFromCommentsDtoToModel(commentsDto);
        commentsRepository.save(cm);
        return commentsDto;
    }

    //This method delete by id a specific data from the database
    public void deleteRatingAndCommentsModel(Long id){
        commentsRepository.deleteById(id);
    }

    //This method update the already existing data in the database
    public void updateComments(Long id, CommentsDto commentsDto){
        if(!commentsRepository.existsById(id)){
            throw new RecordNotFoundException("We could do not found  any commet");
        }else{
            CommentsModel storedComments = commentsRepository.findById(id).orElse(null);
            storedComments.setId(commentsDto.getId());
            storedComments.setTitle(commentsDto.getTitle());
            storedComments.setComments(commentsDto.getComments());
        }
    }

    //    Transferring from comments  model  to Dto
    public CommentsDto transferFromCommentsModelToDto(CommentsModel commentsModel) {

        var dto = new CommentsDto();

        dto.id = commentsModel.getId();
        dto.title = commentsModel.getTitle();
        dto.comments = commentsModel.getComments();

        return dto;

    }

    // Transferring from comments Dto to  comments model
    public CommentsModel transferFromCommentsDtoToModel(CommentsDto commentsDto) {

        var commentsModel = new CommentsModel();

        commentsModel.setComments(commentsDto.getComments());
        commentsModel.setTitle(commentsDto.getTitle());
        commentsModel.setComments(commentsDto.getComments());

        return commentsModel;

    }
}
