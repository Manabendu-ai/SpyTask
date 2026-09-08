package riku.spytask.backend.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
