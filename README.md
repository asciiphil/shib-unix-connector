Shibboleth Unix Data Connector
==============================

This is a really simple data connector for [Shibboleth][] that draws
information from Unix account information (as provided by libpam).

  [Shibboleth]: http://shibboleth.net/


Installation and Use
--------------------

Using it should be simple.  Build with `mvn install`, copy the jars in the
`target/shib-unix-connector-<version>-bin.tar.gz` file into your IdP
library directory, and rebuild the IdP WAR.

From there, you need a `DataConnector` definition in your
`attribute-resolver.xml` file:

    <resolver:DataConnector
      id="unixLoginAttributes"
      xmlns="http://aperiodic.net/shibboleth/idp/resolver/dc"
      xsi:type="UnixLogin"/>

The data connector makes the following attributes available:

 * **username** - The account username.
 * **gecos** - The contents of the accounts GECOS field, also known as the
   full name.
 * **uid** - The account's UID.
 * **gid** - The GID of the account's primary group.
 * **homeDir** - The account's home directory.
 * **shell** - The account's shell.
 * **groups** - A list of all of the groups of which the account is a
   member.

Suggested uses include:

    <resolver:AttributeDefinition xsi:type="ad:Simple" id="commonName" sourceAttributeID="gecos">
      <resolver:Dependency ref="unixLoginAttributes" />
      <resolver:AttributeEncoder xsi:type="enc:SAML1String" name="urn:mace:dir:attribute-def:cn" />
      <resolver:AttributeEncoder xsi:type="enc:SAML2String" name="urn:oid:2.5.4.3" friendlyName="cn" />
    </resolver:AttributeDefinition>
    

Limitations
-----------

The data connector assumes that the principal name by which the person
authenticated is the same as the Unix username.  A future version of this
connector will be more configurable.
