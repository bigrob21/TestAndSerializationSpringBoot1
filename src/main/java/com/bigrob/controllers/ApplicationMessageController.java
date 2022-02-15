package com.bigrob.controllers;

import com.bigrob.models.ManagedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationMessageController {
    @Autowired private ManagedMessage messageProvider;

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ManagedMessage> message() {
        return ResponseEntity.ok(messageProvider);
    }

}
