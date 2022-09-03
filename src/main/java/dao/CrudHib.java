package dao;

public interface CrudHib<Entity, Id> {
   void save(Entity model);
   void update(Entity model);
   void delete(Entity model);
   Entity read(Id modelId);
}
