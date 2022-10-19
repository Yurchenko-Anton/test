package player;

public interface Player {
    String getName();

    String getNick();

    String getTeamName();

    int getGoals();

    int getScore();

    void setName(String name);

    void setNick(String nick);

    void setTeamName(String teamName);

    void setGoals(int goals);

    void setScore(int score);
}
