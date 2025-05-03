package com.monthly.challeanges.challenageApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is a controller
@RestController
//we use request mmapping if the repeative end point so we define in request mapping and for every request
// we do not need to write repeative task again and again only we write unique part so our class looks like clean
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;


    public ChallengeController(ChallengeService challengeService){
        this.challengeService=challengeService;

    }


    //Creating GET request to get all challenges
    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        //handle custom http status  code
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    //Creating POST request to adding a challenge by the user
    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isChallangeAddded = challengeService.addChallenge(challenge);
        if(isChallangeAddded){
            //handle custom http status  code
            return new ResponseEntity<>("challenge added successfully", HttpStatus.OK);
        }
        else{
            //handle custom http status  code
            return new ResponseEntity<>("challenge not added successfully", HttpStatus.NOT_FOUND);
        }
    }

    //Creating Get request to get a monthly challenge
    @GetMapping("/{month}")
    public ResponseEntity <Challenge> getMonthlyChallenges(@PathVariable String month){
        Challenge challenge=challengeService.getMonthlyChallenges(month);
        if(challenge != null){
            //handle custom http status  code
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else{
            //handle custom http status  code
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Creating put request to get a replace the challenge id month and description
    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updateChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updateChallenge);
        if(isChallengeUpdated){
            //handle custom http status  code
            return new ResponseEntity<>("challenge updated successfully", HttpStatus.OK);
        }
        else{
            //handle custom http status  code
            return new ResponseEntity<>("challenge not updated successfully", HttpStatus.NOT_FOUND);
        }
    }

    //creating a delete request to remove the data
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            //handle custom http status  code
            return new ResponseEntity<>("challenge deleted successfully", HttpStatus.OK);
        }
        else{
            //handle custom http status  code
            return new ResponseEntity<>("challenge not deleted successfully", HttpStatus.NOT_FOUND);
        }
    }

}
