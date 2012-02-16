package org.commonjava.js.scaffold.plugin.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UISection
{

    public static final String DEFAULT_TITLE = "_default";

    private String title = DEFAULT_TITLE;

    private List<UIPanel> panels = new ArrayList<UIPanel>();

    public UISection( final String title, final List<UIPanel> panels )
    {
        this.title = title;
        this.panels = panels;
    }

    UISection()
    {
    }

    public String getTitle()
    {
        return title;
    }

    public List<UIPanel> getPanels()
    {
        return panels;
    }

    public void setTitle( final String title )
    {
        this.title = title;
    }

    public void setPanels( final List<UIPanel> panels )
    {
        this.panels = panels;
    }

    public boolean addPanel( final UIPanel panel )
    {
        return panels.add( panel );
    }

    public boolean removePanel( final String panelTitle )
    {
        for ( final UIPanel panel : new HashSet<UIPanel>( panels ) )
        {
            if ( panel.getTitle()
                      .equals( panelTitle ) )
            {
                panels.remove( panel );
                return true;
            }
        }
        return false;
    }

    public boolean removePanel( final UIPanel panel )
    {
        return panels.remove( panel );
    }

    public UISection copy()
    {
        final List<UIPanel> panels = new ArrayList<UIPanel>();
        for ( final UIPanel uiPanel : this.panels )
        {
            panels.add( uiPanel.copy() );
        }

        final UISection uis = new UISection( title, panels );
        return uis;
    }

}
