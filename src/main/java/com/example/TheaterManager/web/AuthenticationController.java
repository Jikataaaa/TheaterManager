package com.example.TheaterManager.web;

import com.example.TheaterManager.models.auth.AuthenticationResponse;
import com.example.TheaterManager.models.auth.LoginRequest;
import com.example.TheaterManager.models.auth.RegisterRequest;
import com.example.TheaterManager.models.enums.UserRole;
import com.example.TheaterManager.models.view.UserView;
import com.example.TheaterManager.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.TheaterManager.utils.AuthUtil.validateToken;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;



    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request
    ){

        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/roleAccess")
    public ResponseEntity<Boolean> getRoleAccess(@RequestParam("token") String token,
                                                 @RequestParam("username") String username,
                                                 @RequestParam("role") String role){

        String extractUsername = validateToken(token);
        if(extractUsername == null){
            return ResponseEntity.ok(false);
        }

        if(username.equals(extractUsername)){
            UserRole userRole = authenticationService.getUserRole(username);
            String roleName = userRole.name();
            if (roleName.equals(role)) {
                return ResponseEntity.ok(true);
            }else if(roleName.equals("ADMIN") && role.equals("USER")){
                return ResponseEntity.ok(true);
            }else {
                return ResponseEntity.ok(false);
            }
        }else{
            return ResponseEntity.ok(false);
        }
    }
    @GetMapping("/verifyAuthentication")
    public ResponseEntity<Boolean> verifyAuthentication(@RequestParam("token") String token,
                                                        @RequestParam("username") String username){

        String extractUsername = validateToken(token);
        if(extractUsername == null){
            return ResponseEntity.ok(false);
        }
        if(extractUsername.equals(username)){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<UserView>> getAllUsers(){
        return ResponseEntity.ok(authenticationService.getAllUsers());
    }
}
