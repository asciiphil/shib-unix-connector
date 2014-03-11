package net.aperiodic.shibboleth.config.attribute.resolver.dataConnector;

import edu.internet2.middleware.shibboleth.common.config.attribute.resolver.dataConnector.BaseDataConnectorFactoryBean;

import net.aperiodic.shibboleth.attribute.resolver.provider.dataConnector.UnixDataConnector;

public class UnixDataConnectorFactoryBean extends BaseDataConnectorFactoryBean {
 
    public Class getObjectType() {
        return UnixDataConnector.class;
    }
 
    protected Object createInstance() throws Exception {
        UnixDataConnector connector = new UnixDataConnector();
        populateDataConnector(connector);
        return connector;
    }
}
