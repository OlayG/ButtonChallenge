
package com.example.olayg.buttonchallenge.data.entities;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("candidate")
    @Expose
    private String candidate;
    public final static Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2585546729480923685L;

    protected User(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.candidate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(candidate);
    }

    public int describeContents() {
        return  0;
    }

}
