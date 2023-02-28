package cz.klecansky.spring;

import org.springframework.web.bind.annotation.*;

/**
 * Rozdíl mezi anotací @RestController a @Controller a je takový že anotace RestController kromě toho
 * že označí třídu tak že se jedná o bean ale také řekne controlleru aby všechny objekty které vrací
 * automaticky serializoval do JSONu který bude uložene v HTTP response body.
 * Anotace @RestController je kombinací anotací @Controller a @ResponseBody.
 * <p>
 * XML používá k definici prvků značky které jsou poté reprezentováni v stromové struktuře,
 * JSON data jsou uložena jako klíč-hodnota.
 * YAML je striktní nadmnožina JSON s přidáním syntaktického významu pro nový řádek a odsazování.
 */
@RestController
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/hello/{name}")
    public String helloPath(@PathVariable("name") String name) {
        return "Hello " + name + " from Spring Boot application.";
    }

    @GetMapping("/hello")
    public String helloParam(@RequestParam String name) {
        return "Hello " + name + " from Spring Boot application.";
    }

    @GetMapping("/helloObject")
    public Hello helloObject(@RequestBody Hello name) {
        return name;
    }
}
