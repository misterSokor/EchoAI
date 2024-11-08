package com.sokortech.echoai.dto;

import java.util.List;
import com.sokortech.echoai.model.Message;
import lombok.Data;

@Data
public class ChatResponse {

    private List<Choice> choices;

    // constructors, getters and setters

    @Data
    public static class Choice {

        private int index;
        private Message message;

    }
}
