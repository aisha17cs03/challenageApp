package com.monthly.challeanges.challenageApp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    private List<Challenge> challenges = new ArrayList<>();
    private Long nextId=2L;


    public ChallengeService(){
        Challenge challenge1=new Challenge(1L, "January", "New challange i am adding here");
        challenges.add(challenge1);
    }

    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public Boolean addChallenge(@RequestBody Challenge challenge){
        if(challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else{
            return false;
        }
    }

    public Challenge getMonthlyChallenges(String month) {
        for(Challenge challenge: challenges){
            if(challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updateChallenge) {
        for(Challenge challenge: challenges){
            if(challenge.getId().equals(id)){
                challenge.setMonth(updateChallenge.getMonth());
                challenge.setDescription(updateChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        //Lambda Expression
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}
