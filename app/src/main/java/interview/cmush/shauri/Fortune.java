package interview.cmush.shauri;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fortune {

    @SerializedName("fortune")
    @Expose
    private List<String> fortune = null;

    public List<String> getFortune() {
        return fortune;
    }

    public void setFortune(List<String> fortune) {
        this.fortune = fortune;
    }

}