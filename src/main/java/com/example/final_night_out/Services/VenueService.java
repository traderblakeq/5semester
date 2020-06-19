package com.example.final_night_out.Services;


import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.News;
import com.example.final_night_out.Models.Pictures;
import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Repositories.IFirebase;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class VenueService implements IVenueService {

    @Autowired
    IFirebase firebaseRepo;

    @Override
    public Venue findVenueByUid(String uid) throws InterruptedException, ExecutionException {
        return firebaseRepo.fetchVenueByUid(uid);
    }

    @Override
    public List<News> fetchnews()throws InterruptedException, ExecutionException {
        return firebaseRepo.fetchNewsFromFireBase();
    }


    @Override
    public Venue updateOpeningHours(Venue venue) {

        String uid = venue.getUid();

        Map<String, Object> map = new HashMap<>();
        map.put("monday", venue.getMonday());
        map.put("mondayClose", venue.getMondayClose());
        map.put("thuesday", venue.getThuesday());
        map.put("thuesdayClose",venue.getThuesdayClose());
        map.put("wednesday", venue.getWednesday());
        map.put("wednesdayClose",venue.getWednesdayClose());
        map.put("thursday", venue.getThursday());
        map.put("thursdayClose",venue.getThursdayClose());
        map.put("friday", venue.getFriday());
        map.put("fridayClose",venue.getFridayClose());
        map.put("saturday", venue.getSaturday());
        map.put("saturdayClose",venue.getSaturdayClose());
        map.put("sunday", venue.getSunday());
        map.put("sundayClose",venue.getSundayClose());
        return firebaseRepo.saveOpeningHours(uid, map);
    }

    @Override
    public Features findFeatuesByUid(String uid) throws InterruptedException, ExecutionException {

        DocumentSnapshot document = firebaseRepo.fetchFeaturesFireBase(uid);

        return document.toObject(Features.class);
    }

    @Override
    public Features updateFeatures(Features features) throws InterruptedException, ExecutionException {
        return firebaseRepo.saveFeatures(features.getEmail(), features);
    }

    @Transactional
    public Pictures savePics(String  uid, Pictures pictures, MultipartFile imageFile) throws IOException {
        if(!imageFile.isEmpty()) {

            String encodedImage = convertToBase64(imageFile);
            pictures.setImage(encodedImage);
        }
        return firebaseRepo.savePicsToFireStore(uid, pictures);
    }

    @Override
    public String deletePics(String uid) {
        return firebaseRepo.deletePicsFromDb(uid);
    }

    @Override
    public List<Pictures> fetchPictures(String uid) throws InterruptedException, ExecutionException{

        DocumentSnapshot document = firebaseRepo.fetchPicturesFromFireBase(uid);

        List<Pictures> picturesList = new ArrayList<>();

        if(document != null){
            Pictures listOfPics = (Pictures) document.toObject(Pictures.class);
            picturesList.add(listOfPics);
        }

        return picturesList;
    }

    private String convertToBase64(MultipartFile imageFile) throws IOException {

        //Converting imageFile into String
        byte [] byteArr = imageFile.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedImage = "data:image/png;base64," + encoder.encodeToString(byteArr);

        return encodedImage;

    }


}
