package at.dru.jdbcpooltest.service;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
