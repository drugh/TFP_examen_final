package ro.tefacprogramator.m4.examen_final_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.tefacprogramator.m4.examen_final_app.entity.Toy;
import ro.tefacprogramator.m4.examen_final_app.repositories.ToyRepository;

@Service
public class ToyService {
    
    @Autowired
    private ToyRepository repo;

    public boolean addToysToDB(Toy toy) {
        try {
            if (toy.getDescription() == "") {
                return false;
            } else if (toy.getPrice() == 0.0) {
                return false;
            } else if (toy.getTypeID() <= 0) {
                return false;
            } else if(toy.getCategoryID() <= 0) {
                return false;
            }
            repo.save(toy);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public List<Toy> getAllToysFromDB() {
        return repo.lsitOfToys();
    }

}
