package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    // The @GetMapping
    @GetMapping("/roll-dice")
    public String showGuessLinks() {
        return "roll-dice/roll-dice";
    }
// Model object is allowuing tranfer data from the controller to the view
    //** do not add dollar sign when using pathvariable in URL in the controllers**
    @GetMapping("/roll-dice/{guess}")
    public String checkGuess(@PathVariable int guess, Model model) {
        int min = 1;
        int max = 6;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1)) + min;
        // Model is allowing us to pass data to the roll-dice result using key-value pairs. The String is the key, and the variable name is the value.
        model.addAttribute("randomNumber", random_int);
        model.addAttribute("guess", guess);
        model.addAttribute("isCorrect", guess == random_int);
        return "roll-dice/roll-dice-result";
    }
}
