package com.sonastea.Ticketopia.dto;

import java.util.List;

public class EventDTO {

    private String name;
    private String id;
    private EventDatesDTO dates;
    private List<EventImagesDTO> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EventDatesDTO getDates() {
        return dates;
    }

    public void setDates(EventDatesDTO dates) {
        this.dates = dates;
    }

    public void setImages(List<EventImagesDTO> images) {
        this.images = images;
    }

    public List<EventImagesDTO> getImages() {
        return images;
    }

}