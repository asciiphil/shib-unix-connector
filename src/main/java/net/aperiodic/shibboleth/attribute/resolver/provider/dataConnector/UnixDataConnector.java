package net.aperiodic.shibboleth.attribute.resolver.provider.dataConnector;

import org.jvnet.libpam.UnixUser;

public class UnixDataConnector extends BaseDataConnector {

    public UnixDataConnector() {
        super();
    }
 
    protected void addBaseAttributes(Map<String, BaseAttribute> attributes, String name, List<T> results) {
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
        org.jvnet.libpam.UnixUser account = new org.jvnet.libpam.UnixUser(username);
        
        addBaseAttributes(result, 'username', new ArrayList<String>([account.getUserName()]));
        addBaseAttributes(result, 'gecos', new ArrayList<String>([account.getGecos()]));
        addBaseAttributes(result, "uid", new ArrayList<Integer>([account.getUID()]));
        addBaseAttributes(result, "gid", new ArrayList<Integer>([account.getGID()]));
        addBaseAttributes(result, "homeDir", new ArrayList<String>([account.getDir()]));
        addBaseAttributes(result, "shell", new ArrayList<String>([account.getShell()]));
        addBaseAttributes(result, "groups", new ArrayList<String>(account.getGroups()));


        return result;
    }
}
