package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final double CONCERT_A = 440.0;

    public static void main(String[] args) {
        /* create two guitar strings with 37 notes*/
        GuitarString[] strings = new GuitarString[37];
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        for (int i=0; i<37; i++){
            strings[i] = new GuitarString(CONCERT_A * Math.pow(2, (i - 24) / 12.0)) ;
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                if (i>=0 && i <37){
                    strings[i].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i=0; i<37; i++){
                 sample += strings[i].sample();
            }
            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i=0; i<37; i++){
                strings[i].tic();
            }
        }
    }
}