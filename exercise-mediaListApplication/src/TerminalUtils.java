import java.util.List;

public class TerminalUtils {

    // Methods
    public void displayMenu(){
        // show main menu options

    }

    public void getMenuChoice() {
        // gets and validates selection
    }

    public String getString(String prompt) {
        return"";
    }

    public int getInt(String prompt) {
        return -1;
    }

    public void print(String message){
        System.out.println(message);
    }

    public void displayMediaList(List<Media> mediaList) {
        for (int i = 0; i < mediaList.size(); i++) {
            print(i + ". " + mediaList.get(i).getName());
        }
    }
}
