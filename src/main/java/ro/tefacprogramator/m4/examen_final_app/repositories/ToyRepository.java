package ro.tefacprogramator.m4.examen_final_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ro.tefacprogramator.m4.examen_final_app.entity.Toy;

public interface ToyRepository extends JpaRepository<Toy, Integer> {
    
    @Query(
        value = "SELECT ToyID, Description, Price, TypeName, CategoryName FROM toy t LEFT JOIN category c ON t.CategoryID = c.CategoryID LEFT JOIN type ty ON t.TypeID = ty.TypeID;",
        nativeQuery = true
    )
    public List<Toy> lsitOfToys();
}
