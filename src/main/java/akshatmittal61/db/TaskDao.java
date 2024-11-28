package akshatmittal61.db;

import akshatmittal61.constants.Queries;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface TaskDao {
    @SqlQuery(Queries.TASKS_TABLE_EXISTS)
    Boolean tasksTableExists();

    @SqlUpdate(Queries.CREATE_TASKS_TABLE)
    void createTasksTable();

    @SqlUpdate(Queries.CREATE_TASK)
    void createTask(String content, boolean completed);

    @SqlQuery(Queries.GET_ALL_TASKS)
    ArrayList<String> getAllTasks();

    @SqlQuery(Queries.GET_TASK_BY_ID)
    String getTaskById(int id);

    @SqlUpdate(Queries.UPDATE_TASK)
    Boolean updateTask(int id, String content, boolean completed);

    @SqlUpdate(Queries.DELETE_TASK)
    Boolean deleteTask(int id);
}
