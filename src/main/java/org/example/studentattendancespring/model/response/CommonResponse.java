package org.example.studentattendancespring.model.response;

public class CommonResponse<T> {
    private final T data;
    private final int status;
    private final String messageError;

    public CommonResponse(int status, String messageError) {
        this.data = null;
        this.status = status;
        this.messageError = messageError;
    }


    public CommonResponse(T data, int status) {
        this.data = data;
        this.status = status;
        this.messageError = null;
    }

    public T getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessageError() {
        return messageError;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "data=" + data +
                ", status=" + status +
                ", messageError='" + messageError + '\'' +
                '}';
    }
}
