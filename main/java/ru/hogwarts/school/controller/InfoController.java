package ru.hogwarts.school.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getPort")
public class InfoController {
    @Value ("${server.port}")
    private String server_port;

    @GetMapping()
    public ResponseEntity getPort () {
        return ResponseEntity.ok(server_port);
    }
}
