package com.example.final_night_out.Services;

import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Repositories.IFirebase;

import java.util.concurrent.ExecutionException;

public interface IAdminService{
    Venue initialCreationVenue(Venue venue);
    Features initialCreationFeatures(Features features)throws InterruptedException, ExecutionException;
}
