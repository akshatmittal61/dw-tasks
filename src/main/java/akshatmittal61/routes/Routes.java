package akshatmittal61.routes;

import akshatmittal61.db.TaskDao;
import akshatmittal61.utils.Logger;
import com.google.gson.Gson;
import org.jdbi.v3.core.Jdbi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class Routes {
    TaskDao dao;
    public Routes(Jdbi jdbi) {
        dao = jdbi.onDemand(TaskDao.class);
        try {
            Boolean tasksTableExists = dao.tasksTableExists();
            Logger.debug("Does table exists", tasksTableExists);
            if (!tasksTableExists) {
                dao.createTasksTable();
            }
        } catch (Exception e) {
            dao.createTasksTable();
        }
    }
    @GET
    public String getAllTasks() {
        List<String> list = dao.getAllTasks();
        return new Gson().toJson(list);
    }
}
