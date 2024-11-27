package akshatmittal61;

import akshatmittal61.routes.GetAllTasks;
import akshatmittal61.routes.HealthApi;
import akshatmittal61.utils.Logger;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        environment.jersey().register(new GetAllTasks());
        environment.healthChecks().register("Server", new HealthApi());
    }

}
