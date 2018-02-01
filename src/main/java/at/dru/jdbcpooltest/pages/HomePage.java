package at.dru.jdbcpooltest.pages;


import at.dru.jdbcpooltest.service.SampleEntityServiceImpl;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.ZonedDateTime;

public class HomePage extends AbstractPage {

    @SpringBean
    private SampleEntityServiceImpl poolTestService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("theTime", ZonedDateTime.now()));
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();

        poolTestService.runTests((WebRequest) RequestCycle.get().getRequest());
    }

    @Override
    protected String getPageTitle() {
        return "Spring Boot with Wicket Demo";
    }
}
