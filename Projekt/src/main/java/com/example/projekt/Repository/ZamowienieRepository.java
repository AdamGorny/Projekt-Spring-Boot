package com.example.projekt.Repository;

import com.example.projekt.Model.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ZamowienieRepository extends JpaRepository<Zamowienie, Integer> {
    //List<Zamowienie> FindByKlient_id(int klient_id);
}
