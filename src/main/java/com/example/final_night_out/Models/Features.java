package com.example.final_night_out.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Features {

    private String email = "";
    private int ageLimit = 18;
    private boolean LGTB = false;

    @NestedConfigurationProperty
    private Type type = new Type();

    @NestedConfigurationProperty
    private Activities activities = new Activities();

    @NestedConfigurationProperty
    private Smoking smoking = new Smoking();

    @NestedConfigurationProperty
    private TypeOfVenue typeOfVenue = new TypeOfVenue();

    @NestedConfigurationProperty
    private FacilityType facilityType = new FacilityType();

    @NestedConfigurationProperty
    private SoundStyle soundStyle = new SoundStyle();

    @NestedConfigurationProperty
    private MusicStyle musicStyle = new MusicStyle();

    @NestedConfigurationProperty
    private Beverage beverage = new Beverage();

    @NestedConfigurationProperty
    private FoodOptions foodOptions = new FoodOptions();

    @NestedConfigurationProperty
    private DressCode dressCode = new DressCode();

    @Data
    @NoArgsConstructor
    static class Type{

        private boolean bar;
        private boolean nightClub;
        private boolean bodega;
        private boolean pub;
    }

    @Data
    @NoArgsConstructor
    static class TypeOfVenue{

        private boolean cocktail;
        private boolean sports;
        private boolean pool;
        private boolean games;
        private boolean beer;
        private boolean champagne;
        private boolean wine;
        private boolean stripClub;
        private boolean karaoke;
    }

    @Data
    @NoArgsConstructor
    static class Activities{

        private boolean turnaments;
        private boolean dices;
        private boolean dart;
        private boolean billard;
        private boolean snooker;
        private boolean carambole;
        private boolean tableFootball;
        private boolean beerPong;
        private boolean shuffleboard;
        private boolean boardGames;
        private boolean tableTennis;
        private boolean boxingGame;
        private boolean slotMachines;
        private boolean airHockey;
        private boolean simulator;
        private boolean quiz;
    }

    @Data
    @NoArgsConstructor
    static class Smoking{

        private boolean allowedIndoor;
        private boolean areIndoor;
        private boolean notAllowed;
        private boolean privateAreaOutdoor;
    }

    @Data
    @NoArgsConstructor
    static class FacilityType{

        private boolean danceFloor;
        private boolean vipArea;
        private boolean tableReservation;
        private boolean wardrobe;
        private boolean handicapFriendly;
        private boolean tableDancing;
        private boolean podium;
        private boolean karaoke;
        private boolean swimmingPool;
    }

    @Data
    @NoArgsConstructor
    static class SoundStyle{

        private boolean live;
        private boolean dj;
        private boolean jukeBox;
        private boolean playlist;
    }

    @Data
    @NoArgsConstructor
    static class MusicStyle{

        private boolean blues;
        private boolean jazz;
        private boolean electro;
        private boolean techno;
        private boolean house;
        private boolean rap;
        private boolean rock;
        private boolean pop;
        private boolean hipHop;
        private boolean funk;
        private boolean country;
        private boolean rnB;
        private boolean latino;
        private boolean soul;
        private boolean punk;
        private boolean metal;
    }

    @Data
    @NoArgsConstructor
    static class Beverage{

        private boolean beer;
        private boolean specialBeer;
        private boolean simpleDrinks;
        private boolean longDrinks;
        private boolean cocktails;
        private boolean specialCocktails;
        private boolean champagne;
        private boolean licour;
        private boolean specialLicour;
    }

    @Data
    @NoArgsConstructor
    static class FoodOptions{

        private boolean snacks;
        private boolean fastfood;
        private boolean alaCarte;
    }

    @Data
    @NoArgsConstructor
    static class DressCode{

        private boolean casual;
        private boolean fashionable;
        private boolean classy;
        private boolean extravagant;
    }
}
