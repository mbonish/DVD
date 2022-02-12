package DVDLib.dto;

import java.util.Objects;

public class DVD {

    public void setDVDId(int DVDId) {
        this.DVDId = DVDId;
    }

    private  int DVDId;
    private String Title;
    private String ReleaseDate;
    private String MPAARating;
    private String Director;
    private String Studio;
    private String UserRating;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.DVDId;
        hash = 29 * hash + Objects.hashCode(this.Title);
        hash = 29 * hash + Objects.hashCode(this.ReleaseDate);
        hash = 29 * hash + Objects.hashCode(this.MPAARating);
        hash = 29 * hash + Objects.hashCode(this.Director);
        hash = 29 * hash + Objects.hashCode(this.Studio);
        hash = 29 * hash + Objects.hashCode(this.UserRating);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (this.DVDId != other.DVDId) {
            return false;
        }
        if (!Objects.equals(this.Title, other.Title)) {
            return false;
        }
        if (!Objects.equals(this.ReleaseDate, other.ReleaseDate)) {
            return false;
        }
        if (!Objects.equals(this.MPAARating, other.MPAARating)) {
            return false;
        }
        if (!Objects.equals(this.Director, other.Director)) {
            return false;
        }
        if (!Objects.equals(this.Studio, other.Studio)) {
            return false;
        }
        if (!Objects.equals(this.UserRating, other.UserRating)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DVD{" + "DVDId=" + DVDId + ", Title=" + Title + ", ReleaseDate=" + ReleaseDate + ", MPAARating=" + MPAARating + ", Director=" 
                + Director + ", Studio=" + Studio + ", UserRating=" + UserRating + '}';
    }

    public DVD(int DVDId) {
        this.DVDId = DVDId;
    }

    public int getDVDId() {
        return DVDId;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public String getUserRating() {
        return UserRating;
    }

    public void setUserRating(String userRating) {
        UserRating = userRating;
    }
}
