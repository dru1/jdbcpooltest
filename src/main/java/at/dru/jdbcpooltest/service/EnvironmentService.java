package at.dru.jdbcpooltest.service;

import org.apache.wicket.request.http.WebRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class EnvironmentService {

    public String resolveOrigin(WebRequest req) {
        HttpServletRequest httpReq = (HttpServletRequest) req.getContainerRequest();
        return httpReq.getRemoteHost();
    }

}
