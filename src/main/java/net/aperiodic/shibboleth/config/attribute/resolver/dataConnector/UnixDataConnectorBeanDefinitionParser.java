package net.aperiodic.shibboleth.config.attribute.resolver.dataConnector;

import javax.xml.namespace.QName;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;

import org.w3c.dom.Element;

import edu.internet2.middleware.shibboleth.common.config.attribute.resolver.dataConnector.BaseDataConnectorBeanDefinitionParser;


public class UnixDataConnectorBeanDefinitionParser extends BaseDataConnectorBeanDefinitionParser {
 
    public static final QName SCHEMA_NAME = new QName(UnixDataConnectorNamespaceHandler.NAMESPACE, "UnixLogin");
 
    protected Class getBeanClass(Element element) {
        return UnixDataConnectorFactoryBean.class;
    }
  
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        super.doParse(element, builder);
    }
}
