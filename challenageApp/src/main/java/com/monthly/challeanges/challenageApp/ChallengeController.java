package com.monthly.challeanges.challenageApp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is a controller
@RestController
public class ChallengeController {
    private ChallengeService challengeService;


    public ChallengeController(ChallengeService challengeService){
        this.challengeService=challengeService;

    }


    //Creating GET request to get all challenges
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){

        return challengeService.getAllChallenges();
    }

    //Creating POST request to adding a challenge by the user
    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge){
        boolean isChallangeAddded = challengeService.addChallenge(challenge);
        if(isChallangeAddded){
            return "challenge added successfully";
        }
        else{
            return "challenge not added successfully";
        }
    }

    //Creating Get request to get a monthly challenge
    @GetMapping("/challenges/{month}")
    public Challenge getMonthlyChallenges(@PathVariable String month){
        Challenge challenge=challengeService.getMonthlyChallenges(month);
        if(challenge != null){
            return challenge;
        }
        else{
            return null;
        }
    }
}
