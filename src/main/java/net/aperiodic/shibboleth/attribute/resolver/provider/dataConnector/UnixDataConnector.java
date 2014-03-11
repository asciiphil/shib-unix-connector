public class UnixDataConnector extends BaseDataConnector {
 
    public UnixDataConnector() {
    }
 
    public Map<String, BaseAttribute> resolve(ShibbolethResolutionContext resolutionContext)
        throws AttributeResolutionException {
        Map<String, BaseAttribute> result = new HashMap<String, BaseAttribute>();
        String username = resolutionContext.getAttributeRequestContext().getPrincipalName();
        // ???
        return result;
    }
}
