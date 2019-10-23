package co.ias.bootcamp.springworkshop.controllers;

import co.ias.bootcamp.springworkshop.domain.Key;
import co.ias.bootcamp.springworkshop.repositories.KeysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/keys")
public class KeysController {

    private final KeysRepository keysRepository;

    @Autowired
    public KeysController(KeysRepository keysRepository) {
        this.keysRepository = keysRepository;
    }

    @RequestMapping
    public List<Key> getAllKeys(){
        return keysRepository.findAllKeys();
    }
}
