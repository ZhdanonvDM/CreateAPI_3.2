package ru.hogwarts.school.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getPort")
@Profile("test")
public class InfoControllerTest {
    @Value ("${server.port}")
    private String server_port;

    @GetMapping()
    public ResponseEntity getPort () {
        return ResponseEntity.ok(server_port);
    }
}
