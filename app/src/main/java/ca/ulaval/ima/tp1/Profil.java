package ca.ulaval.ima.tp1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Profil implements Parcelable {

    private String firstname;
    private String lastname;
    private Date birthdate;
    private String idul;

    public Profil(String firstname, String lastname, Date birthdate, String idul) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.idul = idul;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getIdul() {
        return idul;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Profil createFromParcel(Parcel in) {
            return new Profil(in);
        }

        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeLong(birthdate != null ? birthdate.getTime() : -1L);
        dest.writeString(idul);
    }

    protected Profil(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        long tmpBirthdate = in.readLong();
        birthdate = tmpBirthdate != -1 ? new Date(tmpBirthdate) : null;
        idul = in.readString();
    }
}