package fr.treeptik.btrfs.Devoxx2018.controller;

import fr.treeptik.btrfs.Devoxx2018.domain.FanType;
import fr.treeptik.btrfs.Devoxx2018.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomePageController {

    @Autowired
    public UserService userService;

    @GetMapping
    public String index(ModelMap model) {
        System.out.println("index");
        model.addAttribute("usersCount", userService.countUser());
        model.addAttribute("usersFanChuckCount", userService.countUserByFanType(FanType.CHUCK));
        model.addAttribute("usersFanJeanClaudeCount", userService.countUserByFanType(FanType.JVCD));
        return "index";
    }

    @PostMapping
    public String modify() {
        return "index";
    }

    @DeleteMapping
    public String deleteData(ModelMap model) {
        userService.deleteAllUsers();
        model.addAttribute("usersCount", userService.countUser());
        model.addAttribute("usersFanChuckCount", userService.countUserByFanType(FanType.CHUCK));
        return "index";
    }
}
