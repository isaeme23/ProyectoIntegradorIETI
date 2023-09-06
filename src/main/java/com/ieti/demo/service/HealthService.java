package com.ieti.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HealthService {

    private final Map<String, String> users = new HashMap<>();

    public void save(String user, String id){
        users.put(id, user);
    }

    public String getUser(String id){
        return users.get(id);
    }

    public List<String> getUsers(){
        return (List<String>) users.values();
    }

    public void updateUser(String id, String user){
        users.replace(id, user);
    }

    public void deleteUser(String id){
        users.remove(id);
    }
}
