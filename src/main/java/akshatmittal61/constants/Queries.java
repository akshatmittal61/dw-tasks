package akshatmittal61.constants;

// TODO: Auto-generate queries for dao for tasks table

public class Queries {
    public static final String TASKS_TABLE_EXISTS = "SELECT EXISTS (SELECT FROM pg_tables WHERE schemaname = 'public' AND tablename = 'tasks')";
    public static final String CREATE_TASKS_TABLE = "CREATE TABLE tasks (id UUID DEFAULT uuid_generate_v4(), content varchar(255), completed boolean DEFAULT false, created_at timestamp DEFAULT CURRENT_TIMESTAMP, updated_at timestamp DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (id));";
    public static final String GET_ALL_TASKS = "SELECT * FROM tasks";
    public static final String GET_TASK_BY_ID = "SELECT * FROM tasks WHERE id = :id";
    public static final String CREATE_TASK = "INSERT INTO tasks (content, completed) VALUES (:content, :completed)";
    public static final String UPDATE_TASK = "UPDATE tasks SET content = :content, completed = :completed, updated_at = CURRENT_TIMESTAMP WHERE id = :id RETURNING *";
    public static final String DELETE_TASK = "DELETE FROM tasks WHERE id = :id RETURNING *";
}
