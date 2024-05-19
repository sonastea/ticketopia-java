package com.sonastea.Ticketopia.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventDatesDTO {

    private StartDTO start;
    private boolean noSpecificTime;

    public StartDTO getStart() {
        return start;
    }

    public void setStart(StartDTO start) {
        this.start = start;
    }

    public boolean isNoSpecificTime() {
        return noSpecificTime;
    }

    public void setNoSpecificTime(boolean noSpecificTime) {
        this.noSpecificTime = noSpecificTime;
    }

    public static class StartDTO {
        private LocalDate localDate;
        private LocalDateTime dateTime;

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
        }
    }

}