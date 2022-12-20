package sharing.com.enjoying.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sharing.com.enjoying.dtos.AboutUsDto;
import sharing.com.enjoying.services.AboutUsService;

import java.util.List;

@RestController
public class AboutUsController {
    private final AboutUsService aboutUsService;

    @Autowired
    public AboutUsController(AboutUsService aboutUsService) {
        this.aboutUsService = aboutUsService;
    }

    @GetMapping("/aboutUsGetAll")
    public List<AboutUsDto> getAllAboutUs() {
        List<AboutUsDto> dtos = aboutUsService.getAllDescriptions();

        return dtos;
    }

    @GetMapping("/aboutUsGet/{id}")
    public AboutUsDto getAboutUs(@PathVariable("id") Long id) {
        AboutUsDto dto = aboutUsService.getAboutUs(id);
        return dto;
    }

    @PostMapping("/aboutUsPost")
    public AboutUsDto addAboutUs(@RequestBody AboutUsDto dto) {
        AboutUsDto dto1 = aboutUsService.addAboutUsModel(dto);
        return dto1;
    }

    @DeleteMapping("/aboutUsDelete/{id}")
    public void deleteAboutUs(@PathVariable("id") Long id) {
        aboutUsService.deleteAboutUsModel(id);
    }
}