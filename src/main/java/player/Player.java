package player;

public interface Player {
    String getName();

    String getNick();

    String getTeamName();

    int getScore();

    void setName(String name);

    void setNick(String nick);

    void setTeamName(String teamName);

    void setScore(int score);
}
