package br.com.primeirocrudspring.springbootcommsql.dto;

import java.util.Objects;

public class ResponseDTO {
    public String message;
    public long contRecords;
    public Object records;

    public ResponseDTO(String message, long contRecords, Object records) {
        this.message = message;
        this.contRecords = contRecords;
        this.records = records;
    }

    public ResponseDTO(String message, Object records) {
        this.message = message;
        this.records = records;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(long contRecords) {
        this.contRecords = contRecords;
    }

    public ResponseDTO(Object records) {
        this.records = records;
    }

    public ResponseDTO(Object records, long contRecords) {
        this.records = records;
        this.contRecords = contRecords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getContRecords() {
        return contRecords;
    }

    public void setContRecords(long contRecords) {
        this.contRecords = contRecords;
    }

    public Object getRecords() {
        return records;
    }

    public void setRecords(Object records) {
        this.records = records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDTO that = (ResponseDTO) o;
        return contRecords == that.contRecords && Objects.equals(message, that.message) && Objects.equals(records, that.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, contRecords, records);
    }
}
