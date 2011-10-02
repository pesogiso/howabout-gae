package gae.howabout.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-10-02 12:21:08")
/** */
public final class SaveDataMeta extends org.slim3.datastore.ModelMeta<gae.howabout.model.SaveData> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<gae.howabout.model.SaveData, com.google.appengine.api.datastore.Key> internalKey = new org.slim3.datastore.CoreAttributeMeta<gae.howabout.model.SaveData, com.google.appengine.api.datastore.Key>(this, "__key__", "internalKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<gae.howabout.model.SaveData> message = new org.slim3.datastore.StringAttributeMeta<gae.howabout.model.SaveData>(this, "message", "message");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<gae.howabout.model.SaveData> permalink = new org.slim3.datastore.StringAttributeMeta<gae.howabout.model.SaveData>(this, "permalink", "permalink");

    private static final SaveDataMeta slim3_singleton = new SaveDataMeta();

    /**
     * @return the singleton
     */
    public static SaveDataMeta get() {
       return slim3_singleton;
    }

    /** */
    public SaveDataMeta() {
        super("SaveData", gae.howabout.model.SaveData.class);
    }

    @Override
    public gae.howabout.model.SaveData entityToModel(com.google.appengine.api.datastore.Entity entity) {
        gae.howabout.model.SaveData model = new gae.howabout.model.SaveData();
        model.setInternalKey(entity.getKey());
        model.setMessage((java.lang.String) entity.getProperty("message"));
        model.setPermalink((java.lang.String) entity.getProperty("permalink"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        gae.howabout.model.SaveData m = (gae.howabout.model.SaveData) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getInternalKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getInternalKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("message", m.getMessage());
        entity.setProperty("permalink", m.getPermalink());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        gae.howabout.model.SaveData m = (gae.howabout.model.SaveData) model;
        return m.getInternalKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        gae.howabout.model.SaveData m = (gae.howabout.model.SaveData) model;
        m.setInternalKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(gae.howabout.model.SaveData) is not defined.");
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
        assignKeyIfNecessary(model);
        incrementVersion(model);
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

}