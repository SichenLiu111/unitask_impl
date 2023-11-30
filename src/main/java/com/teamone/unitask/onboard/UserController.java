package com.teamone.unitask.onboard;

import com.teamone.unitask.onboard.usermodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The controller class for the User entity
 */
@CrossOrigin(origins = "https://uni-task.vercel.app/", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    UserService userService;

//    @CrossOrigin(origins = "https://uni-task-beta-front.vercel.app/", allowCredentials = "true")
    @GetMapping(path = "/getUsername")
    public ResponseEntity<String> getUsernameByJWT(@RequestHeader("Authorization") String header) {

        User cur_user = userService.getUserEmailFromToken(header);

        String username = cur_user.getUsername();

        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
