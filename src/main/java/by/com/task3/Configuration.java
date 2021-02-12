package by.com.task3;

public class Configuration {

    private String location;
    private String filenames;
    private String suffix;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFilenames() {
        return filenames;
    }

    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Configuration{");
        sb.append("location='").append(location).append('\'');
        sb.append(", filenames='").append(filenames).append('\'');
        sb.append(", suffix='").append(suffix).append('\'');
        sb.append('}');
        return sb.toString();
    }
}