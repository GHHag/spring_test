package test.example.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroService {

    private final String SUPER_SECRET_PW = "pw123";

    private SuperHero[] superHeroes = {
            new SuperHero("Batman", 25, new String[] { "cool bil", "cool outfit" }),
            new SuperHero("Superman", 28, new String[] { "flyga", "stark" }),
            new SuperHero("Spiderman", 20, new String[] { "spindel", "svinga sig" }) };

    public SuperHero[] getAllSuperHeroes() {
        return this.superHeroes;
    }

    public SuperHero getSuperHero(String name) {
        for (SuperHero superHero : this.superHeroes) {
            if (superHero.getName().equals(name)) {
                return superHero;
            }
        }

        return null;
    }

    public ResponseEntity<SuperHero> getSuperHeroWithSecret(String name, String pw) {
        if (!this.SUPER_SECRET_PW.equals(pw)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        for (SuperHero superHero : this.superHeroes) {
            if (superHero.getName().equals(name)) {
                return ResponseEntity.ok(superHero);
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
