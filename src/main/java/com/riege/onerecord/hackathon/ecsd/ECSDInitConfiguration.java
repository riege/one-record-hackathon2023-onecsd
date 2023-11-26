package com.riege.onerecord.hackathon.ecsd;

import org.apache.wicket.protocol.http.WebApplication;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;

@ApplicationInitExtension
public class ECSDInitConfiguration implements WicketApplicationInitConfiguration {

    @Override
    // custom configuration
    public void init(WebApplication webApp) {
        /*
         * In Wicket 9 support for a Content Security Policy (or CSP) has been added.
         * CSP is an added layer of security that helps to detect and mitigate
         * certain types of attacks, including Cross Site Scripting (XSS) and
         * data injection attacks. These attacks are used for everything from
         * data theft to site defacement to distribution of malware.
         * See MDN for more information on CSP.
         *
         * Wicket uses a very strict CSP by default!
         *
         * See https://ci.apache.org/projects/wicket/guide/9.x/single.html#_content_security_policy_csp
         */
        // this allows enough to load the CSS and fonts from the HTML files:
        // v0.1.7 / 2021-AUG-24: completely disable CSP since the "layout" requires it
        // webApp.getCspSettings().blocking().unsafeInline();
        webApp.getCspSettings().blocking().disabled();
    }

}
