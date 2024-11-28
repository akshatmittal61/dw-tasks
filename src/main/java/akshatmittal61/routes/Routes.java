package akshatmittal61.routes;

import akshatmittal61.core.Task;
import akshatmittal61.db.TaskDao;
import akshatmittal61.utils.Logger;
import com.google.gson.Gson;
import org.apache.juli.logging.Log;
import org.jdbi.v3.core.Jdbi;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Routes {
    TaskDao dao;
    public Routes(Jdbi jdbi) {
        dao = jdbi.onDemand(TaskDao.class);
        try {
            Boolean tasksTableExists = dao.tableExists();
            Logger.debug("Does table exists", tasksTableExists);
            if (!tasksTableExists) {
                dao.createTable();
            }
        } catch (Exception e) {
            dao.createTable();
        }
    }
    @GET
    public List<Task> getAllTasks() {
        return dao.findAll();
    }
    @GET
    @Path("/{id}")
    public Task getTaskById(@PathParam("id") String id) {
        Logger.debug("Id in get call", id);
        return dao.findById(id);
    }
    @POST
    public Task createTask(@Valid Task body) {
        Logger.debug("task to create", body.toString());
        return dao.create(body.getContent(), body.getCompleted());
    }
    @PATCH
    @Path("/{id}")
    public Task updateTask(@PathParam("id") String id, @Valid Task body) {
        Logger.debug("task id to update", id);
        Logger.debug("task to update", body.toString());
        return dao.update(id, body.getContent(), body.getCompleted());
    }
    @DELETE
    @Path("/{id}")
    public Task deleteTask(@PathParam("id") String id) {
        Logger.debug("task to delete", id);
        return dao.delete(id);
    }
}
