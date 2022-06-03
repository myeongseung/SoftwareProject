public class Movie {
    private String name;
    private String release;
    private String genre;
    private String director;
    private String actor;
    private String summary;
    private String poaster;

    public String getName(){
        return name;
    }
    public String getRelease(){
        return release;
    }
    public String getGenre(){
        return genre;
    }
    public String getDirector(){
        return director;
    }
    public String getActor(){
        return actor;
    }
    public String getSummary(){
        return summary;
    }
    public String getPoaster(){
        return poaster;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setRelease(String release){
        this.release = release;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setActor(String actor){
        this.actor = actor;
    }
    public void setSummary(String summary){
        this.summary = actor;
    }
    public void setPoaster(String poaster){
        this.poaster = poaster;
    }
}
