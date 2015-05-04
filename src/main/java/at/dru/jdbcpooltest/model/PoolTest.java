package at.dru.jdbcpooltest.model;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class PoolTest extends DefaultEntity {

    private String randomString;

    @Basic(optional = true)
    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    private String originalHost;

    @Basic(optional = true)
    public String getOriginalHost() {
        return originalHost;
    }

    public void setOriginalHost(String originalHost) {
        this.originalHost = originalHost;
    }
}
