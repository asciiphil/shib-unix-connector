package net.aperiodic.shibboleth.attribute.resolver.provider.dataConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.internet2.middleware.shibboleth.common.attribute.BaseAttribute;
import edu.internet2.middleware.shibboleth.common.attribute.provider.BasicAttribute;
import edu.internet2.middleware.shibboleth.common.attribute.resolver.AttributeResolutionException;
import edu.internet2.middleware.shibboleth.common.attribute.resolver.provider.ShibbolethResolutionContext;
import edu.internet2.middleware.shibboleth.common.attribute.resolver.provider.dataConnector.BaseDataConnector;

import org.jvnet.libpam.PAMException;
import org.jvnet.libpam.UnixUser;

public class UnixDataConnector extends BaseDataConnector {

    public UnixDataConnector() {
        super();
    }
 
    protected <T> void addBaseAttributes(Map<String, BaseAttribute> attributes, String name, List<T> results) {
        BaseAttribute<T> attribute = new BasicAttribute<T>(name);
            
        for(T result : results){
            attribute.getValues().add(result);
        }
        attributes.put(name, attribute);
    }

    public Map<String, BaseAttribute> resolve(ShibbolethResolutionContext resolutionContext)
        throws AttributeResolutionException {
        Map<String, BaseAttribute> result = new HashMap<String, BaseAttribute>();
        String username = resolutionContext.getAttributeRequestContext().getPrincipalName();
        try {
            UnixUser account = new UnixUser(username);

            addBaseAttributes(result, "username", Arrays.asList(account.getUserName()));
            addBaseAttributes(result, "gecos", Arrays.asList(account.getGecos()));
            addBaseAttributes(result, "uid", Arrays.asList(account.getUID()));
            addBaseAttributes(result, "gid", Arrays.asList(account.getGID()));
            addBaseAttributes(result, "homeDir", Arrays.asList(account.getDir()));
            addBaseAttributes(result, "shell", Arrays.asList(account.getShell()));
            addBaseAttributes(result, "groups", new ArrayList<String>(account.getGroups()));

            return result;
        } catch (PAMException e) {
            throw new AttributeResolutionException("Unable to load information: " + e.getMessage());
        }
    }

    public void validate() throws AttributeResolutionException {
        if (false) throw new AttributeResolutionException("UnixDataConnector: SHould never happen.");
    }

}
