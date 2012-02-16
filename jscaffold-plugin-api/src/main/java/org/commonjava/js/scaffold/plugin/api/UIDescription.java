package org.commonjava.js.scaffold.plugin.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UIDescription
{

    private List<PluginUI> plugins = new ArrayList<PluginUI>();

    public UIDescription( final PluginUI... plugins )
    {
        this.plugins.addAll( Arrays.asList( plugins ) );
    }

    public UIDescription( final Collection<PluginUI> plugins )
    {
        this.plugins.addAll( plugins );
    }

    public UIDescription()
    {
    }

    public boolean addPlugin( final PluginUI plugin )
    {
        return plugins.add( plugin );
    }

    public boolean removePlugin( final PluginUI plugin )
    {
        return plugins.remove( plugin );
    }

    public List<PluginUI> getPlugins()
    {
        return plugins;
    }

    public void setPlugins( final Collection<PluginUI> plugins )
    {
        this.plugins = new ArrayList<PluginUI>( plugins );
    }

}
