package at.dru.jdbcpooltest.pages;

import at.dru.jdbcpooltest.WicketWebApplication;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.resource.ContextRelativeResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;

public abstract class AbstractPage extends WebPage {

    @SpringBean
    protected WicketWebApplication wicketWebApplication;

    /**
     * {@inheritDoc}
     */
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        // Standard - Styles
        response.render(CssHeaderItem.forReference(new ContextRelativeResourceReference("css/default.css")));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("windowTitle", getWindowTitle()));
        add(new Label("pageTitle", getPageTitle()));
    }

    protected String getWindowTitle() {
        return getPageTitle() + " - " + wicketWebApplication.getAppName();
    }

    protected abstract String getPageTitle();
}
