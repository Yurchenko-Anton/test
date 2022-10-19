package player;

public class SomePlayer implements Player{
    private String name;
    private String nick;
    private String teamName;
    private int score;

    public SomePlayer(String name, String nick, String teamName, int score) {
        this.name = name;
        this.nick = nick;
        this.teamName = teamName;
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
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SomePlayer{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", score=" + score +
                '}';
    }
}
