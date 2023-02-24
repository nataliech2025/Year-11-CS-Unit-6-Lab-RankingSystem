public class User {
    private int userRank;
    private int progress;

    public User(){
        userRank = -8;
        progress = 0;
    }

    public int getRank(){
        return userRank;
    }

    public int getProgress(){
        return progress;
    }

    public void incProgress(int activity){
        if(activity == 0 || activity > 8 || activity < -8){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        if(userRank > activity){
            progress++;
        }

        else if(activity == userRank){
            progress += 3;
        }
        else {
            int d = activity - userRank;
            if(activity > 0 && userRank < 0){
                d--;
            }
            progress += d * d * 10;
        }
        changeProgress();
    }

    public void changeProgress(){
        while(progress >= 100) {
            if(userRank == -1){
                userRank = 1;
            }
            else{
                userRank++;
            }
            progress -= 100;
        }
    }

    public String toString(){
        return "User{rank=" + userRank + ", progress=" + progress + "}";
    }
}