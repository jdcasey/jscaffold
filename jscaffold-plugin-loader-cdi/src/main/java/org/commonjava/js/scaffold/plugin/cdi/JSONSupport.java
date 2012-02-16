package org.commonjava.js.scaffold.plugin.cdi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONSupport
{

    public String toString( final Object obj )
    {
        return getGson().toJson( obj );
    }

    private Gson getGson()
    {
        return new GsonBuilder().setPrettyPrinting()
                                .create();
    }

}
