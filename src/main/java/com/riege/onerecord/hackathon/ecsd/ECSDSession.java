package com.riege.onerecord.hackathon.ecsd;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.riege.onerecord.hackathon.ecsd.domain.SecurityCheckJob;

public class ECSDSession extends WebSession {

    private SecurityCheckJob securityCheckJob;

    public ECSDSession(Request request) {
        super(request);
    }

    // *********************************************************************************************

    public SecurityCheckJob getSecurityCheckJob() {
        if (securityCheckJob == null) {
            securityCheckJob = SecurityCheckJob.createDemo();
        }
        return securityCheckJob;
    }

    public void setSecurityCheckJob(SecurityCheckJob securityCheckJob) {
        this.securityCheckJob = securityCheckJob;
    }

}
