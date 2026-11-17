package com.github.mateusgromowski.simplelinkshortener.handler;

import java.time.LocalDateTime;

public record ExceptionInfo(LocalDateTime timestamp, String message) {

}
