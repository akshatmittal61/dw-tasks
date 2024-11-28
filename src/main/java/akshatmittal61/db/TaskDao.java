package akshatmittal61.db;

import akshatmittal61.constants.Queries;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface TaskDao {
    @SqlUpdate(Queries.CREATE_TASKS_TABLE)
    void createTasksTable();

    @SqlUpdate(Queries.CREATE_TASK)
    void createTask(String content, boolean completed);

    @SqlUpdate(Queries.GET_ALL_TASKS)
    ArrayList<String> getAllTasks();

    @SqlUpdate(Queries.GET_TASK_BY_ID)
    String getTaskById(int id);

    @SqlUpdate(Queries.UPDATE_TASK)
    String updateTask(int id, String content, boolean completed);

    @SqlUpdate(Queries.DELETE_TASK)
    String deleteTask(int id);    
}
