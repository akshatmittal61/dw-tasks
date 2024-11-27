package akshatmittal61.routes;

import com.codahale.metrics.health.HealthCheck;

public class HealthApi extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
