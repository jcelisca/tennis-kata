
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }


    public String changeScore(int tempScore, String score){
        switch (tempScore)
            {
                case 0:
                    score = "Love";
                    break;
                case 1:
                    score = "Fifteen";
                    break;
                case 2:
                    score = "Thirty";
                    break;
                case 3:
                    score = "Forty";
                    break;
                default:
                    score ="";
            }
        return score;
    }

    public boolean deuceScore(){
        if(m_score1 == m_score2 && (m_score1 >=3)){
            return true;
        }
        return false;
    }

    public String highScore(){
        if(m_score1 > m_score2){
            return player1Name;
        }
        return player2Name;
    }

    public boolean advantageScore(){
        if(m_score1 >=4 && m_score1 >= (m_score2 + 1)){
            return true;
        }
        if(m_score2 >=4 && m_score2 >= (m_score1 + 1)){
            return true;
        }
        return false;
    }

    public boolean winScore(){
        if(m_score1 >=4 && m_score1 >= (m_score2 + 2)){
            return true;
        }
        if(m_score2 >=4 && m_score2 >= (m_score1 + 2)){
            return true;
        }
        return false;
    }

    public String getScore(){

        if(deuceScore()){
            return "Deuce";
        }

        if(winScore()){
            return "Win for "+highScore();
        }

        if(advantageScore()){
            return "Advantage "+ highScore();
        }

        if(m_score1 == m_score2){
            return changeScore(m_score1, player1Name) + "-All";
        }

        return changeScore(m_score1, player1Name) +"-"+ changeScore(m_score2, player2Name);
    }
}
