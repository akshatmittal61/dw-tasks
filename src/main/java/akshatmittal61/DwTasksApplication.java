package akshatmittal61;

import akshatmittal61.routes.Routes;
import akshatmittal61.routes.HealthApi;
import akshatmittal61.utils.Logger;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class DwTasksApplication extends Application<DwTasksConfiguration> {

    public static void main(final String[] args) throws Exception {
        Logger.info("Heyo this is Akshat's first Dropwizard application");
        new DwTasksApplication().run(args);
    }

    @Override
    public String getName() {
        return "DwTasks";
    }

    @Override
    public void initialize(final Bootstrap<DwTasksConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DwTasksConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.healthChecks().register("Server", new HealthApi());
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi =factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        environment.jersey().register(new Routes(jdbi));
    }

}
