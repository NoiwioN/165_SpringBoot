package net.gibb.kletterapp.services;

import io.netty.handler.codec.EncoderException;

import net.gibb.kletterapp.models.Ort;
import net.gibb.kletterapp.repositories.OrtRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrtService {
    private final OrtRepository ortRepository;

    public OrtService(OrtRepository ortRepository) {
        this.ortRepository = ortRepository;
    }
    public List<Ort> findAll() {
        return ortRepository.findAll();
    }
    public Ort findById(Long id) {
        return ortRepository.findById(id).orElseThrow(EncoderException::new);
    }
    public void update(Ort ort) {
        Iterable<Ort> orte = findAll();
        for (Ort o : orte) {
            if (o.getId().equals(ort.getId())) {
                ortRepository.save(ort);
                return;
            }
        }
        throw new RuntimeException("User doesn't exist");
    }

    public void create(Ort ort){
        ortRepository.save(ort);
    }
    public void deleteById(Long id){
        ortRepository.deleteById(id);
    }
}
