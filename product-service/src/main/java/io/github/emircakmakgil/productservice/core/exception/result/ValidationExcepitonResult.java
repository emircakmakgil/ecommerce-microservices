package io.github.emircakmakgil.productservice.core.exception.result;

import java.util.List;

public class ValidationExcepitonResult extends ExceptionResult{
    private List<String> errors;
    public ValidationExcepitonResult(List<String> errors) {
        super("Validation Error");
        this.errors = errors;
    }
}
