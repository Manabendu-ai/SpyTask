package riku.spytask.backend.exceptions;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
