package players;

public abstract class Player {

    protected String name;
    protected String nick;
    protected String teamName;
    protected int goals;
    protected int score;

    public Player(String name, String nick, String teamName, int goals, int score) {
        this.name = name;
        this.nick = nick;
        this.teamName = teamName;
        this.goals = goals;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", mvpScore=" + score +
                '}';
    }
}
