package com.ilkerdev.reservation.reservationbackend.rest;

import com.ilkerdev.reservation.reservationbackend.entity.Place;
import com.ilkerdev.reservation.reservationbackend.service.PlaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PlaceRestController {
    private PlaceServiceImpl placeService;

    @Autowired
    public PlaceRestController(PlaceServiceImpl placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    public List<Place> findAll(){
        return placeService.findAll();
    }

    @PostMapping("/places")
    public Place addPlace(@RequestBody Place place){
        // user.setId("");
        placeService.save(place, 0);
        return place;
    }

    @PutMapping("/places")
    public Place updatePlace(@RequestBody Place place){
        placeService.save(place , 1); // 0 = add , else = update
        return place;
    }

    @DeleteMapping("/places/{placeId}")
    public String deletePlace(@PathVariable String placeId){
        Place place = placeService.findById(placeId);
        if(place == null){
            throw new RuntimeException("Place not found.");
        }
        placeService.deleteById(placeId);
        return "Place " + placeId + " is deleted.";
    }

    @GetMapping("/places/{placeId}")
    public Place findById(@PathVariable String userId){
        Place place = placeService.findById(userId);
        if (place == null){
            throw new RuntimeException("Place not found");
        }
        return  place;

    }
}
