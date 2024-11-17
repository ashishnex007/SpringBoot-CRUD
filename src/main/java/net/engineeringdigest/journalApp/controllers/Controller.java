package net.engineeringdigest.journalApp.controllers;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class Controller {

    HashMap<Long, JournalEntity> journalMap = new HashMap<>();

    // get all journals
    @GetMapping
    public List<JournalEntity> getAllJournals(){
        return new ArrayList<>(journalMap.values());
    }

    // add journal
    @PostMapping
    public JournalEntity addJournal(@RequestBody JournalEntity newEntry){
        journalMap.put(newEntry.getId(), newEntry);
        return newEntry;
    }

    // get journal by id
    @GetMapping("/id/{id}")
    public JournalEntity getById(@PathVariable Long id){
        return journalMap.get(id);
    }

    // remove journal by id
    @DeleteMapping("/id/{id}")
    public JournalEntity removeJournal(@PathVariable Long id){
        return journalMap.remove(id);
    }

    // update journal by id
    @PutMapping("/id/{id}")
    public JournalEntity updateJournal(@PathVariable Long id, @RequestBody JournalEntity updatedEntry){
        journalMap.put(id, updatedEntry);
        return updatedEntry;
    }
}
