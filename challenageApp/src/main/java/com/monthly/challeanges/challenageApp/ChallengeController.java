package com.monthly.challeanges.challenageApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//This is a controller
@RestController
public class ChallengeController {
    private List<Challenge> challenges= new ArrayList<>();

    //creating a constructor
    public ChallengeController(){
        //adding a challenge into a list
        Challenge challenge1=new Challenge(100L, "January", "New challange i am adding here");
        challenges.add(challenge1);
    }


    //Creating GET request to get all challenges
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    //Creating POST request to adding a challenge by the user
    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge){
        challenges.add(challenge);
        return "challenge added successfully";
    }
}
