
package com.ciclids.where2go.api.pojoExplore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Tip implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private int createdAt;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("likes")
    @Expose
    @Valid
    private Likes likes;
    @SerializedName("logView")
    @Expose
    private boolean logView;
    @SerializedName("agreeCount")
    @Expose
    private int agreeCount;
    @SerializedName("disagreeCount")
    @Expose
    private int disagreeCount;
    @SerializedName("todo")
    @Expose
    @Valid
    private Todo todo;
    @SerializedName("user")
    @Expose
    @Valid
    private User user;
    public final static Parcelable.Creator<Tip> CREATOR = new Creator<Tip>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Tip createFromParcel(Parcel in) {
            Tip instance = new Tip();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((int) in.readValue((int.class.getClassLoader())));
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.canonicalUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.likes = ((Likes) in.readValue((Likes.class.getClassLoader())));
            instance.logView = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.agreeCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.disagreeCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.todo = ((Todo) in.readValue((Todo.class.getClassLoader())));
            instance.user = ((User) in.readValue((User.class.getClassLoader())));
            return instance;
        }

        public Tip[] newArray(int size) {
            return (new Tip[size]);
        }

    };

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The createdAt
     */
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The createdAt
     */
    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     * @param canonicalUrl The canonicalUrl
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     * @return The likes
     */
    public Likes getLikes() {
        return likes;
    }

    /**
     * @param likes The likes
     */
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    /**
     * @return The logView
     */
    public boolean isLogView() {
        return logView;
    }

    /**
     * @param logView The logView
     */
    public void setLogView(boolean logView) {
        this.logView = logView;
    }

    /**
     * @return The agreeCount
     */
    public int getAgreeCount() {
        return agreeCount;
    }

    /**
     * @param agreeCount The agreeCount
     */
    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }

    /**
     * @return The disagreeCount
     */
    public int getDisagreeCount() {
        return disagreeCount;
    }

    /**
     * @param disagreeCount The disagreeCount
     */
    public void setDisagreeCount(int disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    /**
     * @return The todo
     */
    public Todo getTodo() {
        return todo;
    }

    /**
     * @param todo The todo
     */
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(text);
        dest.writeValue(type);
        dest.writeValue(canonicalUrl);
        dest.writeValue(likes);
        dest.writeValue(logView);
        dest.writeValue(agreeCount);
        dest.writeValue(disagreeCount);
        dest.writeValue(todo);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

}
