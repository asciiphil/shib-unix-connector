package net.aperiodic.shibboleth.config.attribute.resolver.dataConnector;

import edu.internet2.middleware.shibboleth.common.config.BaseSpringNamespaceHandler;

public class UnixDataConnectorNamespaceHandler extends BaseSpringNamespaceHandler {

    public static final String NAMESPACE = "http://aperiodic.net/shibboleth/idp/resolver/dc";

    public void init() {
        registerBeanDefinitionParser(UnixDataConnectorBeanDefinitionParser.SCHEMA_NAME,
                                     new UnixDataConnectorBeanDefinitionParser());
    }
}
