package player;

public class BasketballPlayer implements Player {
    private String name;
    private String nick;
    private String teamName;
    private int goals;
    private int score;

    public BasketballPlayer(String name, String nick, String teamName, int goals, int score) {
        this.name = name;
        this.nick = nick;
        this.teamName = teamName;
        this.goals = goals;
        this.score = score;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getNick() {
        return nick;
    }

    @Override
    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public int getGoals() {
        return goals;
    }

    @Override
    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", mvpScore=" + score +
                '}';
    }
}
