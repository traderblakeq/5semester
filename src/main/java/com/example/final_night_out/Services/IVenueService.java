package com.example.final_night_out.Services;

import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.News;
import com.example.final_night_out.Models.Pictures;
import com.example.final_night_out.Models.Venue;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IVenueService {

    Venue findVenueByUid(String uid) throws InterruptedException, ExecutionException;

    Venue updateOpeningHours(Venue venue);

    List<News> fetchnews() throws InterruptedException, ExecutionException;

    Features findFeatuesByUid(String uid) throws InterruptedException, ExecutionException;

    Features updateFeatures(Features features) throws InterruptedException, ExecutionException;;

    Pictures savePics(String uid, Pictures pictures, MultipartFile imageFile) throws IOException;

    String deletePics(String uid);

    List<Pictures> fetchPictures(String uid) throws InterruptedException, ExecutionException;

}
