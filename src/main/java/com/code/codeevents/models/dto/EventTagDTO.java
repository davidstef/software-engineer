package com.code.codeevents.models.dto;

import com.code.codeevents.models.Event;
import com.code.codeevents.models.Tag;

import javax.validation.constraints.NotNull;

public class EventTagDTO {

    @NotNull
    private Event event;

    @NotNull
    private Tag tag;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
