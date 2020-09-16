package ru.sergei.komarov.bikesharingsupport.controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.bikesharingsupport.services.UsersService;

import java.util.Map;

@RestController
public class AuthenticationController {

    private BCryptPasswordEncoder passwordEncoder;
    private UsersService usersService;
    private AuthenticationManager authenticationManager;

    public AuthenticationController(BCryptPasswordEncoder passwordEncoder,
                                    UsersService usersService,
                                    AuthenticationManager authenticationManager) {

        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonElement authenticate(@RequestBody Map<String, String> body) {

        String username = body.get("username");
        String password = body.get("password");

        JsonObject response = null;

        if (username != null && password != null) {
            response = new JsonObject();
            Authentication authentication = null;
            try {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
                authentication = this.authenticationManager.authenticate(token);
                System.out.println("Logging in with `" + authentication.getPrincipal() + "`");

                response.addProperty("message", "OK");
                response.addProperty("authenticated", authentication.isAuthenticated());
            } catch (Exception e) {
                System.err.println("Failure in autoLogin: " + e);

                response.addProperty("message", "NOT_FOUND");
                response.addProperty("authenticated", false);
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        return response;
    }
}
