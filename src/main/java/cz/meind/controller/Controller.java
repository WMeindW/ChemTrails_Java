package cz.meind.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.Scanner;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    private final String resources1 = "/home/ubuntu/chem-trails/static/";
    private final String resources = "src/main/resources/build/";

    @ResponseBody
    @GetMapping("/")
    public String index() {
        return read("index.html");
    }

    @ResponseBody
    @GetMapping(value = "/javascript", produces = "application/javascript")
    public String javascript() {
        return read("index.js");
    }

    @ResponseBody
    @GetMapping(value = "/css")
    public String css() {
        return read("index.css");
    }

    @ResponseBody
    @GetMapping(value = "/atom.svg", produces = "image/svg")
    public String atom() {
        return read("atom.svg");
    }

    @ResponseBody
    @GetMapping(value = "/atom-radioactive.svg", produces = "image/svg")
    public String atomRadioactive() {
        return read("atom-radioactive.svg");
    }

    private String read(String path) {
        StringBuilder out = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(resources + path));
            while (scanner.hasNext()) out.append(scanner.nextLine());
            scanner.close();
        } catch (Exception e) {
            return null;
        }
        return out.toString();
    }
}
