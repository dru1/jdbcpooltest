package at.dru.jdbcpooltest.pages;


import at.dru.jdbcpooltest.service.PoolTestServiceImpl;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends AbstractPage {

    @SpringBean
    private PoolTestServiceImpl poolTestService;

    @Override
    protected void onConfigure() {
        super.onConfigure();

        poolTestService.runTests((WebRequest) RequestCycle.get().getRequest());
    }

    @Override
    protected String getPageTitle() {
        return "Home";
    }
}
