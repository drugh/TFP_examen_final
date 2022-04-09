package ro.tefacprogramator.m4.examen_final_app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ro.tefacprogramator.m4.examen_final_app.entity.Toy;
import ro.tefacprogramator.m4.examen_final_app.service.ToyService;

@RestController
public class ToyController {
    
    @Autowired
    private ToyService service;

    @CrossOrigin
    @PostMapping("/toy/add")
    public Map<String, Object> addToys(@RequestBody Toy toy) {
        var result = new HashMap<String, Object>();

        if(service.addToysToDB(toy)) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    @GetMapping("/toy/getAll")
    public List<Toy> getAllToys() {

        return service.getAllToysFromDB();

    }






}
