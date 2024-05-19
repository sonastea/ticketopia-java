package com.sonastea.Ticketopia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonastea.Ticketopia.dto.EventDTO;
import com.sonastea.Ticketopia.service.EventDiscoveryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BrowseController {

    private final EventDiscoveryService eventDiscoveryService;

    public BrowseController(EventDiscoveryService eventDiscoveryService) {
        this.eventDiscoveryService = eventDiscoveryService;
    }

    @GetMapping("/browse")
    public String browse(Model model) {
        try {
            List<EventDTO> events = eventDiscoveryService.fetchEvents();
            Map<String, List<EventDTO>> eventsByName = events.stream()
                    .collect(Collectors.groupingBy(EventDTO::getName));
            model.addAttribute("eventsByName", eventsByName);
            model.addAttribute("events", events);
            return "browse";
        } catch (IOException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
