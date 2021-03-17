package netflixchallenge.popularity;

class Solution {
    public static boolean identifyTitles(int[] scores) {

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i+1])
                increasing = false;
            if (scores[i] < scores[i+1])
                decreasing = false;
        }

        return (increasing || decreasing);
    }
    public static void main( String args[] ) {
        // Driver code

        int[][] movie_ratings = {
                {1,2,2,3},
                {4,5,6,3,4},
                {8,8,7,6,5,4,4,1}
        };
        for (int[] movie_rating : movie_ratings){
            if (identifyTitles(movie_rating))
                System.out.println("Title Identified and Separated");
            else
                System.out.println("Title Score Fluctuating");
        }
    }
}
