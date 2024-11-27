package akshatmittal61.routes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/api/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class GetAllTasks {
    @GET
    public ArrayList<String> getAllTasks() {
//        ArrayList<String> tasks = ["Get a new phone", "Eat dinner"];
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Get a new phone");
        tasks.add("Eat dinner");
        return tasks;
    }
}
