package gae.howabout.model;
import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class SaveData {

    @Attribute(primaryKey = true)
    private Key internalKey;

    private String message;

    private String permalink;

    public SaveData() {
    }

    public SaveData(String permalink, String message) {
        this.message = message;
        this.permalink = permalink;
        this.internalKey = createKey(permalink);
    }

    public Key getInternalKey() {
        return this.internalKey;
    }

    public void setInternalKey(Key key) {
        this.internalKey = key;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public static Key createKey(String permalink) {
        if (permalink == null) {
            throw new IllegalArgumentException();
        }
        return Datastore.createKey(SaveData.class, permalink);
    }
}
