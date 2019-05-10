package com.example.nutritionVendors.controllers;

import com.example.nutritionVendors.EntitiesDTO.UserDTO;
import com.example.nutritionVendors.entities.Comment;
import com.example.nutritionVendors.entities.Favorites;
import com.example.nutritionVendors.entities.Shop;
import com.example.nutritionVendors.entities.User;
import com.example.nutritionVendors.library.UserTokenHandle;
import com.example.nutritionVendors.services.CommentService;
import com.example.nutritionVendors.services.FavoritesService;
import com.example.nutritionVendors.services.ShopService;
import com.example.nutritionVendors.services.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public final static String BASE_URL = "/api/user";

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FavoritesService favoritesService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) throws InternalError {

        try {

            User user1 = userService.findOneByEmailAndPassword(user.getEmail(), user.getPassword());

            if (user1 != null) {
                user1.setPassword("");
                return ResponseEntity.ok(user1);
            } else {
                return ResponseEntity.ok(new User());
            }
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit/{date}")
    public ResponseEntity editInfor(@RequestHeader(value = "Authorization") String authorizationHeader, @RequestBody User user,
                                    @PathVariable(name = "date") String dateStr) throws InternalError {

        try {

            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(null);

            } else {
                return ResponseEntity.ok(userService.editInfor(authorizationHeader, user, dateStr));
            }

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/infor")
    public ResponseEntity getInforUser(@RequestHeader(value = "Authorization") String authorizationHeader) throws InternalError {

        try {
            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(null);

            } else {
                return ResponseEntity.ok(userService.findByToken(authorizationHeader));
            }

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/upload")
    @Consumes({"application/json", MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity uploadImage(@PathVariable Integer user_id, @RequestParam(value = "files", required = false) MultipartFile file) throws InternalError {

        try {
            return ResponseEntity.ok(userService.saveImage(file));
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception with sign up", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDTO userDTO) throws InternalError {

        try {
            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);

            User user = new User();
            List<Shop> shops = new ArrayList<>();
            List<Comment> comments = new ArrayList<>();
            List<Favorites> favorites = new ArrayList<>();

            user.setId(0);
            user.setPhone("");
            user.setToken("");
            user.setAvatar(userDTO.getAvatar());
            user.setCreate_date(ts);
            user.setBirthday(ts);
            user.setAddress("");
            user.setStatus(1);
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setShops(shops);
            user.setFavorites(favorites);
            user.setComments(comments);

            return ResponseEntity.ok(userService.signUp(user));
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception with sign up", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/check/{pass}")
    public  ResponseEntity checkPassword(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "pass") String pass){

        try {
            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(0);

            } else {
                if ( userService.findByTokenAndPassword(authorizationHeader, pass) != null) {
                    return ResponseEntity.ok(1);
                } else {

                    return ResponseEntity.ok(0);
                }
            }

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/change/{pass}")
    public  ResponseEntity changePassword(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable(name = "pass") String pass){

        try {
            if (authorizationHeader == null || authorizationHeader == "") {
                return ResponseEntity.ok(0);

            } else {
                return ResponseEntity.ok(userService.changePass(authorizationHeader, pass));
            }

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new ResponseEntity<>("internal exception", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity getOne(@PathVariable(name = "id") Integer id){
        User user = userService.findOneById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public  ResponseEntity getAll(){
        List<User> user = userService.findAll();

        return ResponseEntity.ok(user);
    }
}
