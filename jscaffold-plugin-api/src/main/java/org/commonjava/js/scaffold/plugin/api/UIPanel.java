package org.commonjava.js.scaffold.plugin.api;

import java.io.Serializable;

public class UIPanel
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String title;

    private String pageResource;

    public UIPanel( final String title, final String pageResource )
    {
        this.title = title;
        this.pageResource = pageResource;
    }

    UIPanel()
    {
    }

    public String getTitle()
    {
        return title;
    }

    public String getPageResource()
    {
        return pageResource;
    }

    public void setTitle( final String title )
    {
        this.title = title;
    }

    public void setPageResource( final String pageResource )
    {
        this.pageResource = pageResource;
    }

    public UIPanel copy()
    {
        return new UIPanel( title, pageResource );
    }

}
