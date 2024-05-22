package com.example.projekt.Repository;

import com.example.projekt.Model.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ZamowienieRepository extends JpaRepository<Zamowienie, Integer> {
    @Query(value = "SELECT * FROM Zamowienie WHERE klient_id = :klient_id", nativeQuery = true)
    List<Zamowienie> ZnajdzPoKliencie(int klient_id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Zamowienie WHERE but_id = :but_id", nativeQuery = true)
    void UsunPoId(int but_id);
}
