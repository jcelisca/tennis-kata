
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String high(int ppoint, String pres) {

        if (ppoint == 1)
            pres = "Fifteen";
        if (ppoint == 2)
            pres = "Thirty";
        if (ppoint == 3)
            pres = "Forty";

        if (P2point == 0) {
            P1res = pres;
            P2res = "Love";
            return P1res + "-" + P2res;
        }
        P1res = "Love";
        P2res = pres;
        return P1res + "-" + P2res;
    }

    public String big(int ppoint, int ppoint2) {
        String pres="";
        String pres2="";

        if (ppoint == 2)
            pres = "Thirty";
        if (ppoint == 3)
            pres = "Forty";
        if (ppoint2 == 1)
            pres2 = "Fifteen";
        if (ppoint2 == 2)
            pres2 = "Thirty";
        return pres + "-" + pres2;
    }

    public String getScore() {
        String score = "";
        if (P1point == P2point && P1point < 4) {
            if (P1point == 0)
                score = "Love";
            if (P1point == 1)
                score = "Fifteen";
            if (P1point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            score = high(P1point, P1res);
        }
        if (P2point > 0 && P1point == 0) {
            score = high(P2point, P2res);
        }

        if (P1point > P2point && P1point < 4) {
            /*if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;*/
            score = big(P1point,P2point);
        }
        if (P2point > P1point && P2point < 4) {
            /*if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;*/
            score = big(P2point,P1point);
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}