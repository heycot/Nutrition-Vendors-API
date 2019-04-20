package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.EntitiesDTO.SearchDTO;
import com.example.nutritionVendors.entities.RecentSearch;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.library.Contants;
import com.example.nutritionVendors.services.RecentSearchService;
import com.example.nutritionVendors.services.SearchService;
import com.example.nutritionVendors.services.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RecentSearchController.BASE_URL)
public class RecentSearchController {


    public final static String BASE_URL = "/api/recent-search";

    @Autowired
    private RecentSearchService recentSearchService;

    @Autowired
    private UserService userService;

    @Autowired
    private SearchService searchService;


    @RequestMapping("/offset/{off}")
    public ResponseEntity getAllByUser(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "off") Integer offset) throws InternalError {
        try{
            List<SearchDTO> searchDTOS = new ArrayList<>();

            if (authorizationHeader == null || authorizationHeader == "" || authorizationHeader == "guest") {
                return ResponseEntity.ok(searchDTOS);

            } else {
                User user = userService.findByToken(authorizationHeader);

                List<RecentSearch> recentSearches = recentSearchService.findAllByUser(user.getId(), offset, Contants.LIMIT);


                return ResponseEntity.ok(searchService.findAllByUser(recentSearches));
            }

        } catch (Exception e){
            System.out.println(e.getCause());
            throw new InternalException("Internal Server Error");
        }
    }
}
