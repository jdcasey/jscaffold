package org.commonjava.js.scaffold.plugin.cdi;

import java.io.InputStream;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.commonjava.js.scaffold.plugin.api.PluginUI;
import org.commonjava.js.scaffold.plugin.api.UIDescription;
import org.commonjava.web.json.ser.JsonSerializer;

@Path( "/ui" )
@Singleton
public class UIResource
{

    @Inject
    private Instance<PluginUI> pluginUIs;

    @Inject
    private JsonSerializer serializer;

    @GET
    @Path( "/description" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response getUIDescription()
    {
        final UIDescription desc = new UIDescription();
        if ( pluginUIs != null )
        {
            for ( final PluginUI plugin : pluginUIs )
            {
                desc.addPlugin( plugin );
            }
        }

        final String json = serializer.toString( desc );

        return Response.ok( json )
                       .build();
    }

    @GET
    @Path( "/resource/{path: (/.+)}" )
    public Response getResource( @PathParam( "path" ) final String path )
    {
        final InputStream stream = Thread.currentThread()
                                         .getContextClassLoader()
                                         .getResourceAsStream( path );
        if ( stream == null )
        {
            return Response.status( Status.NOT_FOUND )
                           .build();
        }

        return Response.ok( stream )
                       .build();
    }

}
