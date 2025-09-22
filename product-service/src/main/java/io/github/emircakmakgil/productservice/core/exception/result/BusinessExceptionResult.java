package io.github.emircakmakgil.productservice.core.exception.result;

public class BusinessExceptionResult extends ExceptionResult{
    private String message;

    public BusinessExceptionResult(String message) {
        super("BusinessException");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
