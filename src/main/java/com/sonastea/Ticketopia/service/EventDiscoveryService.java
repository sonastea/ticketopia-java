package com.sonastea.Ticketopia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonastea.Ticketopia.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EventDiscoveryService {

    private final ObjectMapper jacksonObjectMapper;
    private final RestTemplate restTemplate;

    @Value("${ticketmaster.key}")
    private String TICKET_MASTER_KEY;

    @Autowired
    public EventDiscoveryService(ObjectMapper jacksonObjectMapper, RestTemplate restTemplate) {
        this.jacksonObjectMapper = jacksonObjectMapper;
        this.restTemplate = restTemplate;
    }


    private String getTicketMasterRootUrl() {
        return "https://app.ticketmaster.com/discovery/v2/";
    }

    public List<EventDTO> fetchEvents() throws JsonProcessingException {
        String url = getTicketMasterRootUrl() + "events.json?apikey=" + TICKET_MASTER_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Parse the response body into a JsonNode
        JsonNode eventsNode = jacksonObjectMapper.readTree(response.getBody()).path("_embedded").path("events");
        return jacksonObjectMapper.convertValue(eventsNode, new TypeReference<>() {
        });


//        String prettyJson = jacksonObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
    }

}