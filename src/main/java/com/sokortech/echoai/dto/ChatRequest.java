package com.sokortech.echoai.dto;

import java.util.ArrayList;
import java.util.List;
import com.sokortech.echoai.model.Message;
import lombok.Data;

@Data
public class ChatRequest {

    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;

    public ChatRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("system", "You are a helpful assistant."));
        this.messages.add(new Message("user", prompt));
        this.temperature = 0.7; // Optional: set default temperature
        this.n = 1; // Optional: set default response count
    }
}

