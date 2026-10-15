package com.example.tourist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {
    private static final String DEMO_TOKEN = "valid-token-123";
    private final TouristRepository repository;

    public TouristController(TouristRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<String> createTourist(
            @RequestHeader(value = "Token", required = false) String token,
            @RequestBody Tourist tourist) {

        if (token == null || !DEMO_TOKEN.equals(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Token Validation Failed");
        }

        repository.save(tourist);
        return ResponseEntity.ok("Tourist Created Successfully");
    }

    @GetMapping
    public ResponseEntity<?> getTourists() {
        return ResponseEntity.ok(repository.findAll());
    }
}
