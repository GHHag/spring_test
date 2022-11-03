package test.example.test;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping("/superheroes")
    public SuperHero[] getAllSuperHeroes() {
        return superHeroService.getAllSuperHeroes();
    }

    @GetMapping("/superhero/{name}")
    public SuperHero getSuperHeroByName(@PathVariable String name) {
        return superHeroService.getSuperHero(name);
    }

    @GetMapping("/superhero")
    public ResponseEntity<SuperHero> getSuperHeroByNameAndPw(@RequestParam String name, String pw) {
        return superHeroService.getSuperHeroWithSecret(name, pw);
    }

}
