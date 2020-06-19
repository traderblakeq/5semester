package com.example.final_night_out.Repositories;

import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.News;
import com.example.final_night_out.Models.Pictures;
import com.example.final_night_out.Models.Venue;
import com.google.cloud.firestore.DocumentSnapshot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public interface IFirebase {

    Venue fetchVenueForLogin(String email, String password)throws InterruptedException, ExecutionException;

    Venue fetchSpecificVenueDetails(String venue) throws InterruptedException, ExecutionException;

    Venue saveInitialCreationVenue(Venue venue);

    Venue saveOpeningHours(String uid, Map map);

    Venue fetchVenueByUid(String uid) throws InterruptedException, ExecutionException;

    List<News> fetchNewsFromFireBase() throws InterruptedException, ExecutionException;

    DocumentSnapshot fetchFeaturesFireBase(String uid) throws InterruptedException, ExecutionException;

    Features saveFeatures(String uid, Features features) throws InterruptedException, ExecutionException;

    Pictures savePicsToFireStore(String uid, Pictures pictures);

    String deletePicsFromDb(String uid);

    DocumentSnapshot fetchPicturesFromFireBase(String uid) throws InterruptedException, ExecutionException;
}
