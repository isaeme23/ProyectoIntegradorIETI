package com.ieti.demo.controller;

import com.ieti.demo.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/health")
public class HealthController {

    @Autowired
    private HealthService hs = new HealthService();

    @GetMapping("/users")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        try {
            return new ResponseEntity<>(hs.getUsers(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HealthController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error ",HttpStatus.NOT_FOUND);
        }
   }

   @RequestMapping(path = "/players/{id}/{user}", method = RequestMethod.PUT)
   public ResponseEntity<?> updateUser(@PathVariable String id, @PathVariable String user){
        try{
            hs.updateUser(id, user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(HealthController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error ",HttpStatus.FORBIDDEN);
        }
   }

   @DeleteMapping ("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        try{
            hs.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            Logger.getLogger(HealthController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error ",HttpStatus.NOT_FOUND);
        }
   }


    
}
