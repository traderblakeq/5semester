package com.example.final_night_out.Repositories;

import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.News;
import com.example.final_night_out.Models.Pictures;
import com.example.final_night_out.Models.Venue;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Log
@Repository
public class FirebaseRepo implements IFirebase{

    public Venue fetchSpecificVenueDetails(String venueName)throws InterruptedException, ExecutionException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference docRef = dbFirestore.collection("Venues").document(venueName);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        System.out.println(document.getData());

        if(document.exists()){
            Venue venue_obj = document.toObject(Venue.class);
            return venue_obj;
        }else {
            System.out.println("No Document");
            return null;
        }
    }

    public Venue fetchVenueForLogin(String email, String password)throws InterruptedException, ExecutionException{

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference docRef = dbFirestore.collection("venues").document(email);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        log.info(String.valueOf(document.getData()));

        if(document.exists()){

            return document.toObject(Venue.class);

        }else {
            log.info("Venue with specific email -- not found!" + getClass());
            return null;
        }
    }

    @Override
    public Venue saveInitialCreationVenue(Venue venue) {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        dbFirestore.collection("venues")
                .document(venue.getEmail())
                .create(venue);

        return venue;
    }


    public Venue saveOpeningHours(String uid, Map map){

              final DocumentReference docRef = FirestoreClient.getFirestore()
                .collection("venues")
                .document(uid);

        docRef.update(map);
        return null;
    }

    @Override
    public Features saveFeatures(String uid, Features features) {

        log.info("saveFeatures " + features);

        ApiFuture<WriteResult> future = FirestoreClient.getFirestore()
                .collection("features")
                .document(uid)
                .set(features);

        return features;
    }

    public Venue fetchVenueByUid(String uid) throws InterruptedException, ExecutionException{

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference docRef = dbFirestore.collection("venues").document(uid);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        if(document.exists()){

            return document.toObject(Venue.class);

        }else {

            log.info("Venue with specific email -- not found!" + getClass());
            return null;
        }

    }

    @Override
    public List<News> fetchNewsFromFireBase() throws InterruptedException, ExecutionException{

        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot>  future =
                dbFirestore.collection("news").get();

        List<News> newsList = new ArrayList<>();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            newsList.add(document.toObject(News.class));
        }

        return newsList;
    }

    @Override
    public DocumentSnapshot fetchFeaturesFireBase(String uid) throws InterruptedException, ExecutionException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference docRef = dbFirestore.collection("features").document(uid);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        if(document.exists()){

            return document;

        }else {

            log.info("Features with specific email -- not found!" + getClass());
            return null;
        }
    }


    @Override
    public Pictures savePicsToFireStore(String uid, Pictures pictures) {

        try {
            ApiFuture<WriteResult> future = FirestoreClient.getFirestore()
                    .collection("pictures")
                    .document(uid)
                    .set(pictures);

        } catch (Exception e){

            log.info(String.valueOf(e));
        }

        return null;
    }

    @Override
    public String deletePicsFromDb(String uid) {
        Firestore dbFireStore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> writeResult = dbFireStore.collection("pictures")
                .document(uid)
                .delete();

        return null;
    }

    @Override
    public DocumentSnapshot fetchPicturesFromFireBase(String uid) throws InterruptedException, ExecutionException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference docRef = dbFirestore.collection("pictures").document(uid);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        if (document.exists()) {

            return document;

        } else {

            log.info("Pictures with specific email -- not found!" + getClass());
            return null;
        }
    }
}
