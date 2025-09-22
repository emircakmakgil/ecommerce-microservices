package io.github.emircakmakgil.productservice.core.exception.result;

public class ExceptionResult {
    private String type;

    public ExceptionResult(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
