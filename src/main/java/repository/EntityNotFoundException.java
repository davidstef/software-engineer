package repository;

/**
 * Created by Alex on 18/03/2017.
 */
public class EntityNotFoundException extends Exception {

    private Long entityId;
    private String entityClass;
    private String entityUsername;

    public EntityNotFoundException(Long entityId, String entityClass) {
        this.entityId = entityId;
        this.entityClass = entityClass;
    }

    public EntityNotFoundException(String entityUsername, String entityClass) {
        this.entityUsername = entityUsername;
        this.entityClass = entityClass;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

}
