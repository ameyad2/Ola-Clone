package com.adprojects.ola_cabs.controller;

import com.adprojects.ola_cabs.security.JwtUtil;
import com.adprojects.ola_cabs.dtos.requests.DriverSignUpRequest;
import com.adprojects.ola_cabs.dtos.responses.JwtResponse;
import com.adprojects.ola_cabs.dtos.requests.LoginRequest;
import com.adprojects.ola_cabs.dtos.requests.SignUpRequest;
import com.adprojects.ola_cabs.exceptions.UserAlreadyExistsException;
import com.adprojects.ola_cabs.models.Driver;
import com.adprojects.ola_cabs.models.User;
import com.adprojects.ola_cabs.models.enums.UserRole;
import com.adprojects.ola_cabs.repositories.DriverRepository;
import com.adprojects.ola_cabs.repositories.UserRepository;
import com.adprojects.ola_cabs.services.CustomUserDetailsService;
import com.adprojects.ola_cabs.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverService driverService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;



    @PostMapping("/user/signup")
    public ResponseEntity<JwtResponse> signupHandler(@RequestBody SignUpRequest signupRequest)throws UserAlreadyExistsException, AuthenticationException{


        User user = userRepository.findByEmail(signupRequest.getEmail());

        JwtResponse jwtResponse=new JwtResponse();


        if(user!=null) {
            throw new UserAlreadyExistsException("User Already Exist With Email "+signupRequest.getEmail());
        }

        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());

        // Create new user account
        User createdUser = new User();
        createdUser.setEmail(signupRequest.getEmail());
        createdUser.setPassword(encodedPassword);
        createdUser.setFullName(signupRequest.getFullName());
        createdUser.setMobile(signupRequest.getMobile());
        createdUser.setRole(UserRole.USER);

        User savedUser=userRepository.save(createdUser);

        Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT token
        String jwt = jwtUtil.generateJwtToken(authentication);

        jwtResponse.setJwt(jwt);
        jwtResponse.setAuthenticated(true);
        jwtResponse.setError(false);
        jwtResponse.setErrorDetails(null);
        jwtResponse.setType(UserRole.USER);
        jwtResponse.setMessage("Account Created Successfully: "+savedUser.getFullName());

        return new ResponseEntity<JwtResponse>(jwtResponse,
                HttpStatus.ACCEPTED);

    }

    @PostMapping("/driver/signup")
    public ResponseEntity<JwtResponse> driverSignupHandler(@RequestBody DriverSignUpRequest driverSignupRequest){

        Driver driver = driverRepository.findByEmail(driverSignupRequest.getEmail());

        JwtResponse jwtResponse=new JwtResponse();

        if(driver!=null) {

            jwtResponse.setAuthenticated(false);
            jwtResponse.setErrorDetails("email already used with another account");
            jwtResponse.setError(true);

            return new ResponseEntity<JwtResponse>(jwtResponse,HttpStatus.BAD_REQUEST);
        }




        Driver createdDriver=driverService.registerDriver(driverSignupRequest);

        Authentication authentication = new UsernamePasswordAuthenticationToken(createdDriver.getEmail(), createdDriver.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtil.generateJwtToken(authentication);

        jwtResponse.setJwt(jwt);
        jwtResponse.setAuthenticated(true);
        jwtResponse.setError(false);
        jwtResponse.setErrorDetails(null);
        jwtResponse.setType(UserRole.DRIVER);
        jwtResponse.setMessage("Account Created Successfully: "+createdDriver.getName());


        return new ResponseEntity<JwtResponse>(jwtResponse,HttpStatus.ACCEPTED);
    }


    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signin(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authentication authentication = authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtil.generateJwtToken(authentication);

        JwtResponse jwtResponse=new JwtResponse();

        jwtResponse.setJwt(jwt);
        jwtResponse.setAuthenticated(true);
        jwtResponse.setError(false);
        jwtResponse.setErrorDetails(null);
        jwtResponse.setMessage("Account Created Successfully: ");

        return new ResponseEntity<JwtResponse>(jwtResponse,HttpStatus.OK);
    }

    private Authentication authenticate(String username, String password) {
        System.out.println("sign in userDetails - "+password);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        System.out.println("sign in userDetails after loaduser- "+userDetails);

        if (userDetails == null) {
            System.out.println("sign in userDetails - null " + userDetails);
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            System.out.println("sign in userDetails - password not match " + userDetails);
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }





}

