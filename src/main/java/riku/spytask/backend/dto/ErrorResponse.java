package riku.spytask.backend.dto;

import jakarta.websocket.OnError;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
