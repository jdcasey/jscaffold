package org.commonjava.js.scaffold.plugin.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PluginUI
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String pluginName;

    private List<String> stylesheets = new ArrayList<String>();

    private List<UISection> uiSections = new ArrayList<UISection>();

    public PluginUI( final String pluginName, final List<String> stylesheets, final List<UISection> uiSections )
    {
        this.pluginName = pluginName;
        this.stylesheets = stylesheets;
        this.uiSections = uiSections;
    }

    PluginUI()
    {
    }

    public PluginUI copy()
    {
        final List<UISection> sections = new ArrayList<UISection>( uiSections.size() );
        for ( final UISection uiSection : uiSections )
        {
            sections.add( uiSection.copy() );
        }

        return new PluginUI( pluginName, new ArrayList<String>( stylesheets ), sections );
    }

    public String getPluginName()
    {
        return pluginName;
    }

    public List<String> getStylesheets()
    {
        return stylesheets;
    }

    public List<UISection> getUISections()
    {
        return uiSections;
    }

    void setPluginName( final String pluginName )
    {
        this.pluginName = pluginName;
    }

    void setStylesheets( final List<String> stylesheets )
    {
        this.stylesheets = stylesheets;
    }

    void setUiSections( final List<UISection> uiSections )
    {
        this.uiSections = uiSections;
    }

}
