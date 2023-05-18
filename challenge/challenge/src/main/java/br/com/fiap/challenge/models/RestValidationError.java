package br.com.fiap.challenge.models;

public record RestValidationError(
    Integer code,
    String field,
    String message
){}
